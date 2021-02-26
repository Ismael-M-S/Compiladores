package expr;

public class Atribuicao extends Expression {
    Variavel id;
    Tipo tipo;
    Valor valor;

    public Atribuicao(String id, String tipo, String valor) {
        this.id = new Variavel(id);
        this.tipo = new Tipo(tipo);

        if (valor.matches("[-+]?[0-9]*\\.[0-9]+")) {
            this.valor = new ValorReal(Float.parseFloat(valor));
        } else if (valor.matches("[-+]?[0-9]+")) {
            this.valor = new ValorInteiro(Integer.parseInt(valor));
        } else {
            this.valor = new ValorInvalido(valor);
        }
    }

    @Override
    public String toString() {
        return String.format("%s:%s=%s", id, tipo, valor);
    }
}
