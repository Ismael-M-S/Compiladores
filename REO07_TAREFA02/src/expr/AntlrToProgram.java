package expr;

import antlr4.GramaticaBaseVisitor;
import antlr4.GramaticaParser;

import java.util.ArrayList;
import java.util.List;

public class AntlrToProgram extends GramaticaBaseVisitor<Programa> {
    public List<String> semanticErrors;
    public SymbleTable symbleTable;

    @Override
    public Programa visitPrograma(GramaticaParser.ProgramaContext ctx) {

        Programa prog = new Programa();

        semanticErrors = new ArrayList<>();

        symbleTable = new SymbleTable();

        AntlrToExpression exprVisitor = new AntlrToExpression(semanticErrors, symbleTable);

        for (int i =0;i<ctx.getChildCount();i++){
            if (i!=ctx.getChildCount()-1){
                prog.addExpression(exprVisitor.visit(ctx.getChild(i)));
            }
        }

        return prog;
    }
}
