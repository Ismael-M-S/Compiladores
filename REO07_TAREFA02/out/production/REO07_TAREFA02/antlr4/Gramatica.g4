grammar Gramatica;

@header{
    package antlr4;
}

prog: ((attr | opArit) ';')* EOF    #Programa
    ;

attr: ID ':' TIPO '=' VALOR         #Atribuicao
    ;

opArit: opArit '*' opArit           #Multiplicacao
    | opArit '+' opArit             #Soma
    | INT                           #Inteiro
    | FLOAT                         #Real
    | ID                            #Variavel
    ;

ID: (LETRA | '_')(LETRA | NUM)*;
TIPO: ('INT' | 'FLOAT');
VALOR: (INT | FLOAT);

INT: NUM+;
FLOAT: NUM+'.'NUM+;

LETRA: [a-zA-Z];
NUM: [0-9];
WS: [ \r\t\n]* -> skip;
