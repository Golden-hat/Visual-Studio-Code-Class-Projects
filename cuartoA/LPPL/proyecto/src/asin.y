%{
#include "header.h"
%}

%token MAS_ MENOS_ POR_ DIV_ PARA_ PARC_ EQ_ ASIG_
%token LLAA_ LLAC_ CORA_ CORC_ AND_ OR_ NEQ_ LE_ GE_ LEQ_ GEQ_ NOT_ TRUE_ FALSE_
%token READ_ PRINT_ IF_ ELSE_ FOR_ RET_ 
%token INT_ BOOL_ SCOL_ CTE_ ID_ COL_

%%

programa : listDecla 
       ;

listDecla : decla
       | listDecla decla
       ;

decla : declaVar
       | declaFunc
       ;

declaVar : tipoSimp ID_ SCOL_
       | tipoSimp ID_ ASIG_ const SCOL_
       | tipoSimp ID_ CORA_ CTE_ CORC_ SCOL_
       ;

const : CTE_
       | TRUE_
       | FALSE_
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

expreIgual : expreRel
       | expreIgual opIgual expreRel
       ;

expreRel : expreAd 
       | expreRel opRel expreAd
       ;

expreAd : expreMul
       | expreAd opAd expreMul
       ;

expreMul : expreUna
       | expreMul opMul expreUna
       ;

expreUna : expreSufi
       | opUna expreUna
       ;

expreSufi : const
       | PARA_ expre PARC_
       | ID_
       | ID_ CORA_ expre CORC_
       | ID_ PARA_ paramAct PARC_
       ;

paramAct : listParamAct
       |
       ;

listParamAct : expre
       | expre COL_ listParamAct
       ;

opLogic : AND_ | OR_ ;

opIgual : EQ_ | NEQ_ ;

opRel : GE_ | LE_ | GEQ_ | LEQ_ ;

opAd : MAS_ | MENOS_ ; 

opMul : POR_ | DIV_ ;

opUna : MAS_ | MENOS_ | NOT_ ;

%%
