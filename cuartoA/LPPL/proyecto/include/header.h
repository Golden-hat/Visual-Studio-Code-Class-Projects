#include <stdio.h>

/*****************************************************************************/
/*****************************************************************************/
#ifndef _HEADER_H
#define _HEADER_H

/************************************* Variables externas definidas en el AL */
#define TRUE  1
#define FALSE 0

#define OP_NOT 0
#define OP_SUMA 1
#define OP_RESTA 2
#define OP_MULT 3
#define OP_DIV 4
#define OP_MAYOR 5
#define OP_MENOR 6
#define OP_MAYORIG 7
#define OP_MENORIG 8
#define OP_IGUAL 9
#define OP_NOTIGUAL 10
#define OP_OR 11
#define OP_AND 12

typedef struct lista{
    int ref;
    int talla;
} List;

typedef struct texp{
   int t;           
} Expr;

extern int yylex();
extern int yyparse();

extern FILE *yyin;
extern int   yylineno;

/****************************************************** Funciones auxiliares */
extern void yyerror(const char * msg) ;   /* Tratamiento de errores          */

extern int verbosidad ;

#endif  /* _HEADER_H */
/*****************************************************************************/
/*****************************************************************************/
