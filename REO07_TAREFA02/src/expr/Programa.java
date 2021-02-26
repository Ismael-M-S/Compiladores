package expr;

import java.util.ArrayList;
import java.util.List;

public class Programa {
    public List<Expression> expressoes;

    public Programa() {
        this.expressoes = new ArrayList<>();
    }

    public void addExpression(Expression e) {
        this.expressoes.add(e);
    }

    public void printExpressions() {
        System.out.println("Programa fonte:");
        for (int i = 0; i < this.expressoes.size(); i++) {
            System.out.println(this.expressoes.get(i).toString());
        }
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Programa fonte:");

        for (int i = 0; i < expressoes.size(); i++) {
            s.append(String.format("\n%s", expressoes.get(i)));
        }

        return s.toString();
    }
}
