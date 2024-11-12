%{
       #include "header.h"
	#include "libtds.h" 
       #include <stdio.h>
	#include <string.h>
%}

%union {
       int cent;
       char *ident;
       List list;
       Expr texp;
}

%token MAS_ MENOS_ POR_ DIV_ PARA_ PARC_ EQ_ ASIG_
%token LLAA_ LLAC_ CORA_ CORC_ AND_ OR_ NEQ_ LE_ GE_ LEQ_ GEQ_ NOT_ TRUE_ FALSE_
%token READ_ PRINT_ IF_ ELSE_ FOR_ RET_ 
%token INT_ BOOL_ SCOL_  COL_

%token <cent> CTE_
%token <ident> ID_
%type <list> listParamForm listParamAct paramForm
%type <cent>  
       programa decla declaVar tipoSimp declaFunc
       bloque declaVarLocal inst instExpre listDecla
       instEntSal instSelec instIter paramAct 
       opLogic opIgual opRel opAd opMul opUna

%type <texp> expreOP expre expreLogic expreIgual expreRel expreAd expreMul expreUna expreSufi const

%%

programa 
       : 
       { dvar=0; niv = 0; cargaContexto(niv); } 
       listDecla 
       { if(verTDS) mostrarTDS(); }
       ;

listDecla 
       : decla              { $$ = $1; }
       | listDecla decla    { $$ = $1 + $2; }
       ;

decla 
       : declaVar           { $$ = 0; }
       | declaFunc          { $$ = $1; }
       ;

declaVar 
       : tipoSimp ID_ SCOL_
       | tipoSimp ID_ ASIG_ const SCOL_
       | tipoSimp ID_ CORA_ CTE_ CORC_ SCOL_
       ;

tipoSimp : INT_
       | BOOL_
       ;

declaFunc : tipoSimp ID_ PARA_ paramForm PARC_ bloque
       ;

paramForm : listParamForm
       |
       ;

listParamForm : tipoSimp ID_
       | tipoSimp ID_ COL_ listParamForm
       ;

bloque : LLAA_ declaVarLocal listInst RET_ expre SCOL_ LLAC_
       ;

declaVarLocal : declaVarLocal declaVar
       | 
       ;

listInst : listInst inst
       |
       ;

inst : LLAA_ listInst LLAC_
       | instExpre
       | instEntSal
       | instSelec
       | instIter
       ;

instExpre : expre SCOL_
       | SCOL_
       ;

instEntSal: READ_ PARA_ ID_ PARC_ SCOL_
       | PRINT_ PARA_ expre PARC_ SCOL_
       ;

instSelec : IF_ PARA_ expre PARC_ inst ELSE_ inst
       ;

instIter : FOR_ PARA_ expreOP SCOL_ expre SCOL_ expreOP PARC_ inst
       ;

expreOP : expre
       | 
       ;

expre : expreLogic 
       | ID_ ASIG_ expre
       | ID_ CORA_ expre CORC_ ASIG_ expre
       ;

expreLogic : expreIgual 
       | expreLogic opLogic expreIgual
       ;

expreIgual 
       : expreRel
       | expreIgual opIgual expreRel
       ;

expreRel 
       : expreAd 
       | expreRel opRel expreAd
       ;

expreAd 
       : expreMul
       | expreAd opAd expreMul
       ;

expreMul 
       : expreUna
       | expreMul opMul expreUna
       ;

expreUna 
       : expreSufi
       | opUna expreUna
       ;

expreSufi 
       : const
       | PARA_ expre PARC_
       | ID_
       | ID_ CORA_ expre CORC_
       | ID_ PARA_ paramAct PARC_
       ;

paramAct 
       : listParamAct
       |
       ;

listParamAct 
       : expre
       | expre COL_ listParamAct
       ;

const 
       : CTE_         { $$.t = T_ENTERO; }
       | TRUE_        { $$.t = T_LOGICO; }
       | FALSE_       { $$.t = T_LOGICO; }
       ;

opLogic
       : AND_    { $$ = OP_AND; }
       | OR_     { $$ = OP_OR; }
       ;

opIgual
       : EQ_     { $$ = OP_IGUAL; }
       | NEQ_    { $$ = OP_NOTIGUAL; }
       ;

opRel
       : GE_     { $$ = OP_MAYOR; }
       | LE_     { $$ = OP_MENOR; }
       | GEQ_    { $$ = OP_MAYORIG; }
       | LEQ_    { $$ = OP_MENORIG; }
       ;

opAd
       : MAS_    { $$ = OP_SUMA; }
       | MENOS_  { $$ = OP_RESTA; }
       ;

opMul
       : POR_    { $$ = OP_MULT; }
       | DIV_    { $$ = OP_DIV; }
       ;

opUna
       : MAS_    { $$ = OP_SUMA; }
       | MENOS_  { $$ = OP_RESTA; }
       | NOT_    { $$ = OP_NOT; }
       ;
