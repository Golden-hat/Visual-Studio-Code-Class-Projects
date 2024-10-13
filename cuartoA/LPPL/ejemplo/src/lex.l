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
letra           [a-zA-Z]
id              {letra}({digito}|{letra}|_)*
entero          {digito}+
real            {digito}*.{digito}+
cte             {entero}|{real}
comentario      //({digito}|{letra}| )*}\n

%%

"+"		 	      	{ retornar (MAS_) ; }
"-"             { retornar (MENOS_) ; }
"*"             { retornar (POR_) ; }
"/"             { retornar (DIV_) ; }
"("             { retornar (OPAR_) ; }
")"             { retornar (CPAR_) ; }
"=="            { retornar (EQ_); } 
"="             { retornar (ASIG_) ; }
"{"             { retornar (OLLA_) ; }
"}"             { retornar (CLLA_) ; }
"["             { retornar (OCOR_) ; }
"]"             { retornar (CCOR_) ; }
"&&"            { retornar (AND_) ; }
"||"            { retornar (OR_) ; }
"!="            { retornar (NEQ_) ; }
"<"             { retornar (LE_) ; }
">"             { retornar (GE_) ; }
"<="            { retornar (LEQ_) ; }
">="            { retornar (GEQ_) ; }
"!"             { retornar (NOT_) ; }
"true"          { retornar (TRUE_) ; }
"false"         { retornar (FALSE_) ; }
"read"          { retornar (READ_) ; }
"print"         { retornar (PRINT_) ; }
"if"            { retornar (IF_) ; }
"else"          { retornar (ELSE_) ; }
"for"           { retornar (FOR_) ; }
"return"        { retornar (RET_) ; }
"int"           { retornar (INT_) ; }
"bool"          { retornar (BOOL_) ; }
";"             { retornar (SCOL_) ; }
{delimitador}   {if (verbosidad) ECHO ; }
{cte}           { retornar (CTE_) ; }
{id}            { retornar (ID_) ;  }
.				        { yyerror("Caracter desconocido") ;}

%%

int verbosidad = FALSE; 

void yyerror(const char *msg){
  fprintf(stderr, "\nError en la linea %d: %s\n", yylineno, msg);
}

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