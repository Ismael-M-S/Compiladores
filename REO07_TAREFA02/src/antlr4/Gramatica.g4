grammar Gramatica;

@header{
    package antlr4;
}

prog: ((attr | opArit) ';')* EOF          #Programa
    ;

attr: ID ':' TIPO '=' (INT | FLOAT)     #Atribuicao
    ;

opArit: opArit '*' opArit       #Multiplicacao
    | opArit '+' opArit       #Soma
    | INT                 #Inteiro
    | FLOAT               #Real
    | ID                  #Variavel
    ;

TIPO: ('INT' | 'FLOAT');
ID: (LETRA | '_')(LETRA | NUM)*;
INT: NUM+;
FLOAT: NUM+'.'NUM+;

LETRA: [a-zA-Z];
NUM: [0-9];
WS: [ \r\t\n]* -> skip;
