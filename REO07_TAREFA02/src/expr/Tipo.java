package expr;

public class Tipo extends Expression {
    private String tipo;

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isValid() {
        return !(tipo.equals("INT") || tipo.equals("FLOAT"));
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
