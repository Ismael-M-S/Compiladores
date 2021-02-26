package expr;

import java.util.HashMap;
import java.util.Map;

public class SymbleTable {

    public Map<String, Integer> symbleTable;

    public SymbleTable() {
        this.symbleTable = new HashMap<>();
    }

    public void add(String id, int value) {
        symbleTable.put(id, value);
    }

    public int valueof(String id) {
        return symbleTable.get(id);
    }

    public boolean check(String id) {
        return (symbleTable.containsKey(id));
    }

    public void print() {
        System.out.println(symbleTable.toString());
    }

    @Override
    public String toString() {
        return symbleTable.toString();
    }
}
