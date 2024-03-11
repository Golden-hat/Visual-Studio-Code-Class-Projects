#!/usr/bin/env python
#! -*- encoding: utf8 -*-

# 1.- Pig Latin

import re
import sys
from typing import Optional, Text
from os.path import isfile

class Translator():

    def __init__(self, punt:Optional[Text]=None):
        """
        Constructor de la clase Translator

        :param punt(opcional): una cadena con los signos de puntuación
                                que se deben respetar
        :return: el objeto de tipo Translator
        """
        if punt is None:
            punt = ".,;?!"
        self.re = re.compile(r"(\w+)([" + punt + r"]*)")

    def translate_word(self, word:Text) -> Text:
        """
        Recibe una palabra en inglés y la traduce a Pig Latin

        :param word: la palabra que se debe pasar a Pig Latin
        :return: la palabra traducida
        """
        if not word[0].isalpha():
            return word

        count = 0
        startsWithCapital = False
        allCapital = False
        for i in word:
            if word[0].isupper(): startsWithCapital = True
            if i.isupper():
                count = count + 1
        if(count == len(word)): allCapital = True

        word = word.lower()

        vowels = "aeiouy"
        if vowels.__contains__(word[0]):
            word = word + "yay"
        else:
            auxStr = ""
            count = 0
            for i in word:
                if not vowels.__contains__(i):
                    auxStr = auxStr + i
                    count = count + 1
                else:
                    word = word[count:len(word)] + auxStr + "ay"
                    break

        if startsWithCapital: word = word[0].upper() + word[1:len(word)]
        if allCapital: word = word.upper()

        new_word = word

        return new_word

    def translate_sentence(self, sentence:Text) -> Text:
        """
        Recibe una frase en inglés y la traduce a Pig Latin

        :param sentence: la frase que se debe pasar a Pig Latin
        :return: la frase traducida
        """
        space = re.compile(r'\b\w+\b|[.,;?!]')
        list = space.findall(sentence)
        new_sentence = ""
        begin = True
        for i in list:
            if ".,;?!".__contains__(i):
                new_sentence += i 
            else:
                if begin:
                    begin = False
                    new_sentence += self.translate_word(i)
                else:
                    new_sentence += " "+self.translate_word(i)
        sentence = new_sentence

        return sentence

    def translate_file(self, filename:Text):
        """
        Recibe un fichero y crea otro con su tradución a Pig Latin

        :param filename: el nombre del fichero que se debe traducir
        :return: None
        """ 
        if not isfile(filename):
            print(f'{filename} no existe o no es un nombre de fichero', file=sys.stderr)
            return
        

        space = re.compile(r'\b\w+\b|[.,;?!]')
        list = space.findall(filename)
        print(list)

        with open(list[0]+"_latin."+list[2],'w') as file:
            pass

        i = open(filename)
        o = open(list[0]+"_latin."+list[2], "a")

        aux = i.readlines()

        for line in aux:
            o.write(self.translate_sentence(line))
            o.write("\n")
        
        o.close()

if __name__ == "__main__":
    if len(sys.argv) > 2:
        print(f'Syntax: python {sys.argv[0]} [filename]')
        exit()
    t = Translator()
    if len(sys.argv) == 2:
        t.translate_file(sys.argv[1])
    else:
        t.translate_word("brandy")
        sentence = input("ENGLISH: ")
        while len(sentence) > 1:
            print("PIG LATIN:", t.translate_sentence(sentence))
            sentence = input("ENGLISH: ")