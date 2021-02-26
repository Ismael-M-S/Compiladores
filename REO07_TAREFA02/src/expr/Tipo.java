package expr;

public class Tipo {
    private String tipo;

    public Tipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        if (!(tipo.equals("INT") || tipo.equals("FLOAT"))) {
            return String.format("Este tipo nao existe: %s", tipo);
        }

        return tipo;
    }

    @Override
    public String toString() {
        return tipo;
    }
}
