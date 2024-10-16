/* A Bison parser, made by GNU Bison 3.8.2.  */

/* Bison interface for Yacc-like parsers in C

   Copyright (C) 1984, 1989-1990, 2000-2015, 2018-2021 Free Software Foundation,
   Inc.

   This program is free software: you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation, either version 3 of the License, or
   (at your option) any later version.

   This program is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.

   You should have received a copy of the GNU General Public License
   along with this program.  If not, see <https://www.gnu.org/licenses/>.  */

/* As a special exception, you may create a larger work that contains
   part or all of the Bison parser skeleton and distribute that work
   under terms of your choice, so long as that work isn't itself a
   parser generator using the skeleton or a modified version thereof
   as a parser skeleton.  Alternatively, if you modify or redistribute
   the parser skeleton itself, you may (at your option) remove this
   special exception, which will cause the skeleton and the resulting
   Bison output files to be licensed under the GNU General Public
   License without this special exception.

   This special exception was added by the Free Software Foundation in
   version 2.2 of Bison.  */

/* DO NOT RELY ON FEATURES THAT ARE NOT DOCUMENTED in the manual,
   especially those whose name start with YY_ or yy_.  They are
   private implementation details that can be changed or removed.  */

#ifndef YY_YY_ASIN_H_INCLUDED
# define YY_YY_ASIN_H_INCLUDED
/* Debug traces.  */
#ifndef YYDEBUG
# define YYDEBUG 0
#endif
#if YYDEBUG
extern int yydebug;
#endif

/* Token kinds.  */
#ifndef YYTOKENTYPE
# define YYTOKENTYPE
  enum yytokentype
  {
    YYEMPTY = -2,
    YYEOF = 0,                     /* "end of file"  */
    YYerror = 256,                 /* error  */
    YYUNDEF = 257,                 /* "invalid token"  */
    MAS_ = 258,                    /* MAS_  */
    MENOS_ = 259,                  /* MENOS_  */
    POR_ = 260,                    /* POR_  */
    DIV_ = 261,                    /* DIV_  */
    PARA_ = 262,                   /* PARA_  */
    PARC_ = 263,                   /* PARC_  */
    EQ_ = 264,                     /* EQ_  */
    ASIG_ = 265,                   /* ASIG_  */
    LLAA_ = 266,                   /* LLAA_  */
    LLAC_ = 267,                   /* LLAC_  */
    CORA_ = 268,                   /* CORA_  */
    CORC_ = 269,                   /* CORC_  */
    AND_ = 270,                    /* AND_  */
    OR_ = 271,                     /* OR_  */
    NEQ_ = 272,                    /* NEQ_  */
    LE_ = 273,                     /* LE_  */
    GE_ = 274,                     /* GE_  */
    LEQ_ = 275,                    /* LEQ_  */
    GEQ_ = 276,                    /* GEQ_  */
    NOT_ = 277,                    /* NOT_  */
    TRUE_ = 278,                   /* TRUE_  */
    FALSE_ = 279,                  /* FALSE_  */
    READ_ = 280,                   /* READ_  */
    PRINT_ = 281,                  /* PRINT_  */
    IF_ = 282,                     /* IF_  */
    ELSE_ = 283,                   /* ELSE_  */
    FOR_ = 284,                    /* FOR_  */
    RET_ = 285,                    /* RET_  */
    INT_ = 286,                    /* INT_  */
    BOOL_ = 287,                   /* BOOL_  */
    SCOL_ = 288,                   /* SCOL_  */
    CTE_ = 289,                    /* CTE_  */
    ID_ = 290,                     /* ID_  */
    COL_ = 291                     /* COL_  */
  };
  typedef enum yytokentype yytoken_kind_t;
#endif

/* Value type.  */
#if ! defined YYSTYPE && ! defined YYSTYPE_IS_DECLARED
typedef int YYSTYPE;
# define YYSTYPE_IS_TRIVIAL 1
# define YYSTYPE_IS_DECLARED 1
#endif


extern YYSTYPE yylval;


int yyparse (void);


#endif /* !YY_YY_ASIN_H_INCLUDED  */
