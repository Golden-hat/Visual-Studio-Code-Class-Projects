%{
#include "header.h"
#include "asin.h"

#define  retornar(x) {if (verbosidad) ECHO ; return (x) ; }
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
real            {digito}*"."{digito}+
cte             {entero}|{real}
comentario      \/\/.*

%%

"+"		 	      	{ retornar (MAS_) ; }
"-"             { retornar (MENOS_) ; }
"*"             { retornar (POR_) ; }
"/"             { retornar (DIV_) ; }
"("             { retornar (PARA_) ; }
")"             { retornar (PARC_) ; }
"=="            { retornar (EQ_); } 
"="             { retornar (ASIG_) ; }
"{"             { retornar (LLAA_) ; }
"}"             { retornar (LLAC_) ; }
"["             { retornar (CORA_) ; }
"]"             { retornar (CORC_) ; }
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
","             { retornar (COL_) ; }
{delimitador}   {if (verbosidad) ECHO ; }
{comentario}    {if (verbosidad) ECHO ; }
{cte}           { retornar (CTE_) ; }
{id}            { retornar (ID_) ;  }
.				        { yyerror("Caracter desconocido") ;}

%%
