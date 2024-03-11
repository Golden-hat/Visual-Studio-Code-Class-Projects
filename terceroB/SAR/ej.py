import re

def obtener_terminos(cadena):
    # Utilizar expresión regular para encontrar términos separados por espacios y símbolos de puntuación
    expresion_regular = r'\b\w+\b|[.,;?!]'
    terminos = re.findall(expresion_regular, cadena)
    return terminos

# Ejemplo de uso
cadena_ejemplo = "Esto es un ejemplo de términos separados por espacios, con símbolos de puntuación."
terminos_encontrados = obtener_terminos(cadena_ejemplo)
print(terminos_encontrados)