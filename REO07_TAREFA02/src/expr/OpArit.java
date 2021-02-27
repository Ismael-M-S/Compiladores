package expr;

public abstract class OpArit extends Expression {
    Expression esquerda;
    Expression direita;
    char operacao;

    public OpArit(Expression esquerda, Expression direita, char operacao) {
        this.esquerda = esquerda;
        this.direita = direita;
        this.operacao = operacao;
    }

    public Expression getDireita() {
        return direita;
    }

    public Expression getEsquerda() {
        return esquerda;
    }

    public char getOperacao() {
        return operacao;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s", getEsquerda(), getOperacao(), getDireita());
    }
}
