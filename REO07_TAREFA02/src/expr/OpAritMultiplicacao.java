package expr;

public class OpAritMultiplicacao extends OpArit {
    public OpAritMultiplicacao(Expression esquerda, Expression direita) {
        super(esquerda, direita, '*');
    }
}
