#! -*- encoding: utf8 -*-

## Nombres: 

########################################################################
########################################################################
###                                                                  ###
###  Todos los métodos y funciones que se añadan deben documentarse  ###
###                                                                  ###
########################################################################
########################################################################

import argparse
import os
import re
from typing import Optional

"""
Este método coge un diccionario y devuelve su contenido
en una lista de tuplas ordenadas por orden creciente de valor
"""
def sort_dic_by_values(d:dict) -> list:
    return sorted(d.items(), key=lambda a: (-a[1], a[0]))

class WordCounter:

    def __init__(self):
        """
           Constructor de la clase WordCounter
        """
        self.clean_re = re.compile('\W+')

    def write_stats(self, filename:str, stats:dict, use_stopwords:bool, full:bool):
        """
        Este método escribe en fichero las estadísticas de un texto
            
        :param 
            filename: el nombre del fichero destino.
            stats: las estadísticas del texto.
            use_stopwords: booleano, si se han utilizado stopwords
            full: boolean, si se deben mostrar las stats completas
        """

        """
        Para que salgan en orden al imprimirlas, ordenamos las entradas del diccionario

        Utilizamos un diccionario auxiliar que primer toma las keys en orden alfabético
        del diccionario original, las guarda en orden, y luego itera buscando el valor
        que corresponde en el diccionario original.

        Esto es necesario porque de lo contrario el valor asociado a las keys se pierde.
        """
        aux = sorted(stats['word'])
        inOrderWords = {}
        for i in aux:
            inOrderWords[i] = stats['word'].get(i)

        aux = sorted(stats['symbol'])
        inOrderSymbol = {}
        for i in aux:
            inOrderSymbol[i] = stats['symbol'].get(i)

        aux = sorted(stats['bigramS'])
        inOrderBigramS = {}
        for i in aux:
            inOrderBigramS[i] = stats['bigramS'].get(i)

        aux = sorted(stats['bigramW'])
        inOrderBigramW = {}
        for i in aux:
            inOrderBigramW[i] = stats['bigramW'].get(i)

        aux = sorted(stats['suffix'])
        inOrderSuffix = {}
        for i in aux:
            inOrderSuffix[i] = stats['suffix'].get(i)

        aux = sorted(stats['preffix'])
        inOrderPreffix = {}
        for i in aux:
            inOrderPreffix[i] = stats['preffix'].get(i)

        NumOrderWords = sort_dic_by_values(inOrderWords)
        NumOrderSymbol = sort_dic_by_values(inOrderSymbol)
        NumOrderBigramS = sort_dic_by_values(inOrderBigramS)
        NumOrderBigramW = sort_dic_by_values(inOrderBigramW)
        NumOrderSuffix = sort_dic_by_values(inOrderSuffix)
        NumOrderPreffix = sort_dic_by_values(inOrderPreffix)

        with open(filename, 'w', encoding='utf-8', newline='\n') as fh:
            if full:
                fh.write("Lines: "+str(stats['nlines'])+"\n")
                fh.write("Number of words (including stopwords): "+str(stats['nwords']+ stats['nstopwords'])+"\n")
                if use_stopwords: fh.write("Number of words (without stopwords): "+str(stats['nwords'])+"\n")
                fh.write("Vocabulary size: "+str(len(stats['word']))+"\n")
                fh.write("Number of symbols: "+str(stats['nsymbols'])+"\n")
                fh.write("Number of different symbols: "+str(len(stats['symbol']))+"\n")
                fh.write("Words (alphabetical order): \n")
                for i in inOrderWords:
                    fh.write("\t"+i+": "+str(inOrderWords.get(i))+"\n")
                fh.write("Words (by frequency): \n")
                for i in NumOrderWords:
                    fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")
                fh.write("Symbols (alphabetical order): \n")
                for i in inOrderSymbol:
                    fh.write("\t"+i+": "+str(inOrderSymbol.get(i))+"\n")
                fh.write("Symbols (by frequency): \n")
                for i in NumOrderSymbol:
                    fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")

                if stats['bigrams']:
                    fh.write("Word pairs (alphabetical order): \n")
                    for i in inOrderBigramW:
                        fh.write("\t"+i+": "+str(inOrderBigramW.get(i))+"\n")
                    fh.write("Word pairs (by frequency): \n")
                    for i in NumOrderBigramW:
                        fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")
                    fh.write("Symbols pairs (alphabetical order): \n")
                    for i in inOrderBigramS:
                        fh.write("\t"+i+": "+str(inOrderBigramS.get(i))+"\n")
                    fh.write("Symbol pairs (by frequency): \n")
                    for i in NumOrderBigramS:
                        fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")

                fh.write("Prefixes (by frequency): \n")
                for i in NumOrderPreffix:
                    fh.write("\t"+str(i[0])+"-: "+str(i[1])+"\n")
                fh.write("Suffixes (by frequency): \n")
                for i in NumOrderSuffix:
                    fh.write("\t-"+str(i[0])+": "+str(i[1])+"\n")

            if not full:
                fh.write("Lines: "+str(stats['nlines'])+"\n")
                fh.write("Number of words (including stopwords): "+str(stats['nwords']+ stats['nstopwords'])+"\n")
                if use_stopwords: fh.write("Number of words (without stopwords): "+str(stats['nwords'])+"\n")
                fh.write("Vocabulary size: "+str(len(stats['word']))+"\n")
                fh.write("Number of symbols: "+str(stats['nsymbols'])+"\n")
                fh.write("Number of different symbols: "+str(len(stats['symbol']))+"\n")
                fh.write("Words (alphabetical order): \n")
                counter = 0
                for i in inOrderWords:
                    if counter < 20:
                        fh.write("\t"+i+": "+str(inOrderWords.get(i))+"\n")
                    counter += 1
                fh.write("Words (by frequency): \n")
                counter = 0
                for i in NumOrderWords:
                    if counter < 20:
                        fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")
                    counter += 1
                fh.write("Symbols (alphabetical order): \n")
                counter = 0
                for i in inOrderSymbol:
                    if counter < 20:
                        fh.write("\t"+i+": "+str(inOrderSymbol.get(i))+"\n")
                    counter += 1
                fh.write("Symbols (by frequency): \n")
                counter = 0
                for i in NumOrderSymbol:
                    if counter < 20:
                        fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")
                    counter += 1

                if stats['bigrams']:
                    counter = 0
                    fh.write("Word pairs (alphabetical order): \n")
                    for i in inOrderBigramW:
                        if counter < 20:
                            fh.write("\t"+i+": "+str(inOrderBigramW.get(i))+"\n")
                        counter += 1
                    counter = 0
                    fh.write("Word pairs (by frequency): \n")
                    for i in NumOrderBigramW:
                        if counter < 20:
                            fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")
                        counter += 1
                    counter = 0
                    fh.write("Symbols pairs (alphabetical order): \n")
                    for i in inOrderBigramS:
                        if counter < 20:
                            fh.write("\t"+i+": "+str(inOrderBigramS.get(i))+"\n")
                        counter += 1
                    counter = 0
                    fh.write("Symbol pairs (by frequency): \n")
                    for i in NumOrderBigramS:
                        if counter < 20:
                            fh.write("\t"+str(i[0])+": "+str(i[1])+"\n")
                        counter += 1
                
                counter = 0
                fh.write("Prefixes (by frequency): \n")
                for i in NumOrderPreffix:
                    if counter < 20:
                        fh.write("\t"+str(i[0])+"-: "+str(i[1])+"\n")
                    counter += 1

                counter = 0
                fh.write("Suffixes (by frequency): \n")
                for i in NumOrderSuffix:
                    if counter < 20:
                        fh.write("\t-"+str(i[0])+": "+str(i[1])+"\n")
                    counter += 1    
            pass


    def file_stats(self, fullfilename:str, lower:bool, stopwordsfile:Optional[str], bigrams:bool, full:bool):
        
        """
        Este método calcula las estadísticas de un fichero de texto

        :param 
            fullfilename: el nombre del fichero, puede incluir ruta.
            lower: booleano, se debe pasar todo a minúsculas?
            stopwordsfile: nombre del fichero con las stopwords o None si no se aplican
            bigram: booleano, se deben calcular bigramas?
            full: booleano, se deben montrar la estadísticas completas?
        """
        stopwords = set() if stopwordsfile is None else set(open(stopwordsfile, encoding='utf-8').read().split())

        # variables for results

        sts = {
        'nwords': 0,
        'nlines': 0,
        'nsymbols': 0,
        'nstopwords':0,
        'word': {},
        'symbol': {},
        'preffix': {},
        'suffix': {},
        'bigramW': {},
        'bigramS': {},
        'bigrams': bigrams
        }

        file = open(fullfilename)
        aux = file.readlines()

        """
        Empezamos a rellenar los parámetros.
    
        Cuando nos encontremos una key que no esté en el diccionario,
        la inicializamos a 0 e inmediatamente sumamos 1. Si ya está en
        el diccionario, simplemente sumamos 1.
        """
        for line in aux:
            sts['nlines'] += 1
            if lower:
                line = line.lower()

            space = re.compile(r'\b\w+\b')
            list = space.findall(line)

            for i in list:
                if i not in stopwords:
                    if i not in sts['word']:
                        sts['word'][i] = 0
                    sts['word'][i] += 1
                    sts['nwords'] += 1
                    for j in i:
                        if j not in sts['symbol']:
                            sts['symbol'][j] = 0
                        sts['symbol'][j] += 1
                        sts['nsymbols'] += 1
                if i in stopwords:
                    sts['nstopwords'] += 1

                """
                Generamos los bigramas y los prefijos-sufijos de los pares de letras
                """
                iter = 0
                if i not in stopwords:
                    while iter < len(i)-1:
                        #Prefijos
                        if iter < 3 and iter + 1 != len(i) -1:
                            preffix = i[0:iter+2]
                            if preffix not in sts['preffix']:
                                sts['preffix'][preffix] = 0
                            sts['preffix'][preffix] += 1
                        #Sufijos
                        if iter >= len(i) - 4 and iter != 0:
                            suffix = i[iter:len(i)]
                            if suffix not in sts['suffix']:
                                sts['suffix'][suffix] = 0
                            sts['suffix'][suffix] += 1

                        if i[iter]+""+i[iter+1] not in sts['bigramS']:
                            sts['bigramS'][i[iter]+""+i[iter+1]] = 0
                        sts['bigramS'][i[iter]+""+i[iter+1]] += 1
                        iter += 1

            """
            Generamos los bigramas
            """
            if len(list) != 0:
                list.insert(0, "$")
                list.append("$")
                
                iter = 0
                while iter < len(list) - 1:
                    if list[iter] not in stopwords and list[iter+1] not in stopwords:
                        if list[iter]+" "+list[iter+1] not in sts['bigramW']:
                            sts['bigramW'][list[iter]+" "+list[iter+1]] = 0
                        sts['bigramW'][list[iter]+" "+list[iter+1]] += 1
                    iter += 1    

        extension = ""
        """
        Ahora comprobamos las flags que se han triggereado para escribir correctamente
        la extensión de archivo:
        """
        if lower:
            extension = extension + "l"
        if stopwordsfile is not None:
            extension = extension + "s"
        if bigrams:
            extension = extension + "b"
        if full:
            extension = extension + "f"

        # AYUDA: line = self.clean_re.sub(' ', line)

        filename, ext0 = os.path.splitext(fullfilename)
        
        new_filename = filename +"_"+extension+"_"+"stats"+ext0
        self.write_stats(new_filename, sts, stopwordsfile is not None, full)


    def compute_files(self, filenames:str, **args):
        """
        Este método calcula las estadísticas de una lista de ficheros de texto

        :param 
            filenames: lista con los nombre de los ficheros.
            args: argumentos que se pasan a "file_stats".

        :return: None
        """

        for filename in filenames:
            self.file_stats(filename, **args)

if __name__ == "__main__":

    parser = argparse.ArgumentParser(description='Compute some statistics from text files.')
    parser.add_argument('file', metavar='file', type=str, nargs='+',
                        help='text file.')

    parser.add_argument('-l', '--lower', dest='lower',
                        action='store_true', default=False, 
                        help='lowercase all words before computing stats.')

    parser.add_argument('-s', '--stop', dest='stopwords', action='store',
                        help='filename with the stopwords.')

    parser.add_argument('-b', '--bigram', dest='bigram',
                        action='store_true', default=False, 
                        help='compute bigram stats.')

    parser.add_argument('-f', '--full', dest='full',
                        action='store_true', default=False, 
                        help='show full stats.')

    args = parser.parse_args()
    wc = WordCounter()
    wc.compute_files(args.file,
                     lower=args.lower,
                     stopwordsfile=args.stopwords,
                     bigrams=args.bigram,
                     full=args.full)
