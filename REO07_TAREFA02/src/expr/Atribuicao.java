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
            this.id.setType("INT");
        } else if (valor.matches("[-+]?[0-9]+")) {
            this.valor = new ValorInteiro(Integer.parseInt(valor));
            this.id.setType("FLOAT");
        } else {
            this.valor = new ValorInvalido(valor);
            this.id.setType("INVALIDO");
        }
    }

    public boolean isValid() {
        return (getTipoVerdadeiro().equals(tipo.getTipo()));
    }

    public String getTipoVerdadeiro() {
        if (valor instanceof ValorInteiro) {
            return "INT";
        }
        else if (valor instanceof ValorReal) {
            return "FLOAT";
        }
        else {
            return "INVALIDO";
        }
    }

    @Override
    public String toString() {
        return String.format("%s:%s=%s", id, tipo, valor);
    }
}
