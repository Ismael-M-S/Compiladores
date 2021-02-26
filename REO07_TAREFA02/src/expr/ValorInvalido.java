package expr;

public class ValorInvalido extends Valor {
    private String valor;

    public ValorInvalido(String valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return valor;
    }
}
