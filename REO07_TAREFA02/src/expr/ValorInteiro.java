package expr;

public class ValorInteiro extends Valor {
    private int valor;

    public ValorInteiro(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    @Override
    public String toString() {
        return Integer.toString(valor);
    }
}
