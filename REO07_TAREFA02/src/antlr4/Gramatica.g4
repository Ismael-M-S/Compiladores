grammar Gramatica;

@header{
    package antlr4;
}

prog: ((attr | expr) ';')* EOF          #Programa
    ;

attr: ID ':' TIPO '=' (INT | FLOAT)     #Atribuicao
    ;

expr: expr '*' expr       #Multiplicacao
    | expr '+' expr       #Soma
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
