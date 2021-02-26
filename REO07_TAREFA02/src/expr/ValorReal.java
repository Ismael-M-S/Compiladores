package expr;

public class ValorReal extends Valor {
    private float valor;

    public ValorReal(float valor) {
        this.valor = valor;
    }

    public float getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return Float.toString(valor);
    }
}
