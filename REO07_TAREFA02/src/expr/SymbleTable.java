package expr;

import java.util.HashMap;
import java.util.Map;

public class SymbleTable {

    public Map<String, Integer> symbleTable;

    public SymbleTable() {
        this.symbleTable = new HashMap<>();
    }

    public void add(String id, int value){
        symbleTable.put(id,value);
    }

    public int valueof(String id){
        return symbleTable.get(id);
    }

    public boolean check(String id){
        if (symbleTable.containsKey(id)) return true;
        else return false;
    }

    public void print(){
        System.out.println(symbleTable.toString());
    }
}
