grammar Calculator;

@header {
package com.peterabyte.helloantlr;
}

expressions : (expr SEMICOLON)*;

expr : NUMBER                                                                       #numberExpr
     | IDENTIFIER                                                                   #idExpr
     | left=expr op=(ADD | SUB) right=expr                                          #binaryExpr
     | IDENTIFIER EQ value=expr                                                     #assignExpr
     | name=(PRINT | MIN | MAX) PAR_START args+=expr (COMMA args+=expr)* PAR_END    #functionExprMultiArgs
     | name=ABS PAR_START arg=expr PAR_END                                          #functionExprSingleArg
     ;

ADD : '+';

SUB : '-';

EQ : '=';

PRINT : 'print';

MIN : 'min';

MAX : 'max';

ABS : 'abs';

PAR_START : '(';

PAR_END : ')';

COMMA : ',';

IDENTIFIER : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;

NUMBER : '-'? ('0' | '1'..'9' ('0'..'9')*) ('.' ('0'..'9')+)?;

SEMICOLON : ';';

WS : [ \t\r\n]+ -> skip;
