package expr;

public class Variavel extends Expression {
    String name;

    public Variavel(String name) {
        this.name=name;
    }

    @Override
    public String toString() {
        return name;
    }
}
