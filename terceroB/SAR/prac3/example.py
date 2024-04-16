from typing import List
info = {}

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

def index_sentence(sentence:str, info):
    n = info['n']

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
            if index >= len(wordlist) - i:
                break
            gram = 0
            while gram < i:
                if gram != i-1:
                    engram.append(wordlist[gram+index])
                elif gram == i-1:
                    if tuple(engram) not in info['lm'][i]:
                        info['lm'][i][tuple(engram)] = {}
                    if tuple(engram) in info['lm'][i]:
                        if wordlist[gram+index] in info['lm'][i][tuple(engram)]:
                            info['lm'][i][tuple(engram)][wordlist[gram+index]] += 1
                        else:
                            info['lm'][i][tuple(engram)][wordlist[gram+index]] = 0
                            info['lm'][i][tuple(engram)][wordlist[gram+index]] += 1
                gram += 1
            engram = []

def compute_lm(filenames:List[str], lm_name:str, n:int):
    info = {'name': lm_name, 'filenames': filenames, 'n': n, 'lm': {}}
    for i in range(2, n+1):
        info['lm'][i] = {}

    for filename in filenames:
        with open(filename, encoding='utf-8') as fh:

            # Generamos la frase antes de llamar a una nueva línea,
            # ya que el salto de línea no define una nueva frase.
            phrase = ""

            for line in fh:
                if line == "":
                    index_sentence(phrase, info)
                    phrase = ""
                    break
                for letter in line:
                    if letter in [".", ";", "!", "?"]:
                        index_sentence(phrase, info)
                        phrase = ""
                    else:
                        phrase += letter
        index_sentence(phrase, info) 
    return info

def pretty_print_dict(d):
	#take empty string
	pretty_dict = '' 
	
	#get items for dict
	for k, v in d.items():
		pretty_dict += f'{k}: \n'
		for value in v:
			pretty_dict += f' \t{value}: {v[value]}\n'
	#return result
	return pretty_dict

info = compute_lm(filenames=["spam-1.txt"], lm_name="", n=5)
print(pretty_print_dict(info['lm'][3]))

