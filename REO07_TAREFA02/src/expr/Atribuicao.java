package expr;

public class Atribuicao extends Expression{
    String id;
    Tipo tipo;
    int valor;

    public Atribuicao(String id, String tipo, int valor) {
        this.id = id;
        this.tipo = new Tipo(tipo);
        this.valor = valor;
    }

    @Override
    public String toString() {
        String.format("%d:%s=%");
        return id+" = "+Integer.toString(valor);
    }
}
