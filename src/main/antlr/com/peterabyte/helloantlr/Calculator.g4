grammar Calculator;

@header {
package com.peterabyte.helloantlr;
}

expressions : (expr SEMICOLON)*;

expr : NUMBER #numberExpr
     | expr ADD expr #addExpr
     | expr SUB expr #subExpr
     | IDENTIFIER EQ expr #assignExpr
     | FUNCTION PAR_START expr (COMMA expr)* PAR_END #functionExpr
     ;

ADD : '+';

SUB : '-';

EQ : '=';

FUNCTION : 'print';

PAR_START : '(';

PAR_END : ')';

COMMA : ',';

IDENTIFIER : ('a'..'z' | 'A'..'Z' | '_') ('a'..'z' | 'A'..'Z' | '_' | '0'..'9')*;

NUMBER : '-'? ('0' | '1'..'9' ('0'..'9')*) ('.' ('0'..'9')+)?;

SEMICOLON : ';';

WS : [ \t\r\n]+ -> skip;
