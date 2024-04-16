#!/usr/bin/env python
#! -*- encoding: utf8 -*-
# 3.- Mono Library

import pickle
import random
import re
import sys
from typing import List, Optional, TextIO

## Nombres:

########################################################################
########################################################################
###                                                                  ###
###  Todos los métodos y funciones que se añadan deben documentarse  ###
###                                                                  ###
########################################################################
########################################################################


def convert_to_lm_dict(d: dict):
    for k in d:
        l = sorted(((y, x) for x, y in d[k].items()), reverse=True)
        d[k] = (sum(x for x, _ in l), l)

def removeNonAlph(text):
  """
  Removes all non-alphanumeric characters from a string.

  """

  filter = ""

  # Loop through each character in the text
  for char in text:
    # Check if the character is alphanumeric
    if char.isalnum() or char == " ":
      # If it is, add to the filter
      filter += char

  return filter

class Monkey():

    def __init__(self):
        self.r1 = re.compile('[.;?!]')
        self.r2 = re.compile('\W+')
        self.info = {}

    def get_n(self):
        return self.info.get('n', 0)

    def index_sentence(self, sentence:str):
        n = self.info['n']

        for i in range (2, n+1):
            sentence = sentence.lower()
            sentence = removeNonAlph(sentence)

            wordlist = sentence.split()
            dollar = 0
            while dollar < i-1:
                # Añadimos n-1 símbolos finales al principio de la frase.
                wordlist.insert(0, "$")
                dollar += 1
            wordlist.append("$")

            for index, token in enumerate(wordlist):
                engram = []
                if index >= len(wordlist) - i + 1:
                    break
                gram = 0
                # se van seleccionando los pares bigrama-palabra a lo largo de la frase
                while gram < i:
                    # conforma el bigrama
                    if gram != i-1:
                        engram.append(wordlist[gram+index])
                    # conforma la palabra asociada al bigrama
                    elif gram == i-1:
                        # si no existe el diccionario asociado al bigrama, se crea
                        if tuple(engram) not in self.info['lm'][i]:
                            self.info['lm'][i][tuple(engram)] = {}
                        # si existe...
                        if tuple(engram) in self.info['lm'][i]:
                            # ... y la palabra analizada ya se ha visto, se aumenta el recuento
                            if wordlist[gram+index] in self.info['lm'][i][tuple(engram)]:
                                self.info['lm'][i][tuple(engram)][wordlist[gram+index]] += 1
                            # ... y la palabra analizada NO se ha visto todavía para el bigrama, se inicializa
                            else:
                                self.info['lm'][i][tuple(engram)][wordlist[gram+index]] = 0
                                self.info['lm'][i][tuple(engram)][wordlist[gram+index]] += 1
                    gram += 1
                engram = []

    def compute_lm(self, filenames:List[str], lm_name:str, n:int):
        self.info = {'name': lm_name, 'filenames': filenames, 'n': n, 'lm': {}}
        for i in range(2, n+1):
            self.info['lm'][i] = {}
        for filename in filenames:
            with open(filename, encoding='utf-8') as fh:

                # Generamos la frase antes de llamar a una nueva línea,
                # ya que el salto de línea no define una nueva frase.
                phrase = ""

                for line in fh:
                    line += " "
                    if len(line) == 1:
                        self.index_sentence(phrase)
                        phrase = ""
                    else:
                        for letter in line:
                            if letter in [".", ";", "!", "?"]:
                                self.index_sentence(phrase)
                                phrase = ""
                            else:
                                phrase += letter
                # Al finalizar la lectura siempre lanzamos lo que quede.
                self.index_sentence(phrase)

        for i in range(2, n+1):
            convert_to_lm_dict(self.info['lm'][i])

    def load_lm(self, filename:str):
        with open(filename, "rb") as fh:
            self.info = pickle.load(fh)

    def save_lm(self, filename:str):
        with open(filename, "wb") as fh:
            pickle.dump(self.info, fh)

    def save_info(self, filename:str):
        with open(filename, "w", encoding='utf-8', newline='\n') as fh:
            self.print_info(fh=fh)

    def show_info(self):
        self.print_info(fh=sys.stdout)

    def print_info(self, fh:TextIO):
        print("#" * 20, file=fh)
        print("#" + "INFO".center(18) + "#", file=fh)
        print("#" * 20, file=fh)
        print(f"language model name: {self.info['name']}", file=fh)
        print(f'filenames used to learn the language model: {self.info["filenames"]}', file=fh)
        print("#" * 20, file=fh)
        print(file=fh)
        for i in range(2, self.info['n']+1):
            print("#" * 20, file=fh)
            print("#" + f'{i}-GRAMS'.center(18) + "#", file=fh)
            print("#" * 20, file=fh)
            for prev in sorted(self.info['lm'][i].keys()):
                wl = self.info['lm'][i][prev]
                print(f"'{' '.join(prev)}'\t=>\t{wl[0]}\t=>\t{', '.join(['%s:%s' % (x[1], x[0]) for x in wl[1]])}" , file=fh)


    def generate_sentences(self, n:Optional[int], nsentences:int=10, prefix:Optional[str]=None):
        
        # Limpiamos primero el prefijo
        if n is None:
            n = self.info['n']
        else:
            n = n
        
        storedPrefix = ""
        prefLength = 0
        prefixCopy = ""

        if prefix is not None:
            prefix = prefix.lower()
            prefix = removeNonAlph(prefix)

            storedPrefix = prefix

            wordlist = prefix.split()
            prefLength = len(wordlist)

            dollar = 0
            if n != 2:
                while dollar <= n - len(wordlist):
                    # Añadimos n - len(wordlist) símbolos finales al principio de la frase.
                    wordlist.insert(0, "$")
                    dollar += 1
            
            prefix = tuple(wordlist)
            prefixCopy = tuple(wordlist)
        else:
            aux = []
            dollar = 0
            while dollar < n-1:
                # Añadimos n-1 símbolos finales al principio de la frase.
                aux.insert(0, "$")
                dollar += 1
            prefix = tuple(aux)
            prefixCopy = tuple(prefix)

        lines = 0
        while lines < nsentences:
            sentence = ""
            nwords = 0
            sentence += storedPrefix

            # Actualizamos la variable prefijo con el valor de los siguientes bigramas en cada iteración.
            # Guardar el prefijo de partida nos sirve para añadirlo al principio de cada frase.

            finished = False
            while nwords < 50 - prefLength and not finished:
                try:
                    ponderElem = []
                    ponderWeights = []
                    prefix = prefix[(-n+1):len(prefix)]

                    for i in self.info['lm'][n][prefix][1]:
                        ponderElem.append(i[1])
                        ponderWeights.append(i[0])
                    
                    chosen = random.choices(ponderElem, weights=ponderWeights, k=1)
                    if "$" in chosen:
                        # Si la palabra elegido es un símbolo de terminación, concluimos la frase
                        finished = True
                        continue
                    if sentence == "":
                        sentence += ""+str(chosen[0])
                    else:
                        sentence += " "+str(chosen[0])

                    last = n-2
                    if n > 2:
                        currentList = list(prefix)[-last:]

                        auxList = currentList + chosen
                        prefix = tuple(auxList)
                    else:
                        prefix = tuple(chosen)
                    
                    nwords += 1
                # Si no encontramos un bigrama del que partir dado el prefijo de entrada, devolvemos un error.
                except KeyError:
                    sentence = storedPrefix 
                    print("Generation can't be started with such prefix. Try another one.")
                    print()
                    print("'"+sentence+"'")
                    return
            prefix = prefixCopy
            print(sentence)
            print()
            lines += 1
        pass

if __name__ == "__main__":
    print("Este fichero es una librería, no se puede ejecutar directamente")


