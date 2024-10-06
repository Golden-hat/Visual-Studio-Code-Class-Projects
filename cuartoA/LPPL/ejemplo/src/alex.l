/*****************************************************************************/
/**  Ejemplo de FLEX: S E M - 1             2018-2019 <jbenedi@dsic.upv.es> **/
/**  V. 20                                                                  **/
/*****************************************************************************/
%{
#include <stdio.h>
#include <string.h>
#include "header.h"

#define  retornar(x) {if (verbosidad) ECHO;}

%}
/*----------------------------------------------------------------------
  Dado que las funciones "input()" y "unput(c)" son costosas y no las
  utilizaremos, evitaremos que se generen automaticamente sus rutinas
  correspondientes desactivandolas mediante las siguientes opciones:
----------------------------------------------------------------------*/
%option noinput
%option nounput
/*----------------------------------------------------------------------
  Para mantener el numero de linea actual en la variable global yylineno
----------------------------------------------------------------------*/
%option yylineno

delimitador     [ \t\n]+
digito          [0-9]
entero          {digito}+

%%

{delimitador}   {if (verbosidad) ECHO ; }
"+"		 		{ retornar (MAS_) ; }
"-"             { retornar (MENOS_) ; }
"*"             { retornar (POR_) ; }
"/"             { retornar (DIV_) ; }
"("             { retornar (OPAR_) ; }
")"             { retornar (DIV_) ; }
{entero}        { retornar (CTE_) ; }
.				{ yyerror("Caracter desconocido") ;}

%%
int verbosidad = FALSE; 

/*****************************************************************************/
void yyerror(const char *msg){
/*  Tratamiento de errores.                                                  */
  fprintf(stderr, "\nError en la linea %d: %s\n", yylineno, msg);
}

/*****************************************************************************/
int main(int argc, char **argv) {
	int i, n=1 ;

	for (i=1; i<argc; ++i)
      if (strcmp(argv[i], "-v")==0) { verbosidad = TRUE; n++; }
	if (argc == n+1)
      if ((yyin = fopen (argv[n], "r")) == NULL)
      	fprintf (stderr, "El fichero '%s' no es valido\n", argv[n]) ;     
      else yylex ();
	else fprintf (stderr, "Uso: cmc [-v] fichero\n");

	return (0);
} 

/*****************************************************************************/
