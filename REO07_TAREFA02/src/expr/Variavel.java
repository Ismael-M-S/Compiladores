package expr;

public class Variavel extends Expression {
    String nome;

    public Variavel(String nome) {
        this.nome = nome;
    }

    public boolean isValid() {
        return nome.matches("([a-zA-Z] | '_')([a-zA-Z] | [0-9])*");
    }

    @Override
    public String toString() {
        return nome;
    }
}
