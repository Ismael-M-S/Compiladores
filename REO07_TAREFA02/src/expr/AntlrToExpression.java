package expr;

import antlr4.GramaticaBaseVisitor;
import antlr4.GramaticaParser;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class AntlrToExpression extends GramaticaBaseVisitor<Expression> {

    private List<String> declaredVariables;

    /*
     * Semantic Errors:
     * (1) Duplicate variable declaration;
     * (2) Variable not declared.
     * (3) Type conflict
     * (4) OpArit using non declared variables
     * */
    private List<String> semanticErrors;

    public AntlrToExpression(List<String> semanticErrors) {
        declaredVariables = new ArrayList<>();
        this.semanticErrors = semanticErrors;
    }

    @Override
    public Expression visitAtribuicao(GramaticaParser.DeclaracaoContext ctx) {
        Token token = ctx.TIPO().getSymbol();
        int linha = token.getLine();
        int coluna = token.getCharPositionInLine();
        String type = ctx.TIPO().getText();
        String id = ctx.ID().getText();
        String value = ctx.VALOR().getText();
        System.out.println("Visitou Declaracao");
        System.out.println(id + " " + type + " " + value);
        Atribuicao atrb = new Atribuicao(id, type, value);
        if (atrb.valor instanceof ValorInvalido){
            semanticErrors.add("Erro: Variável " + id + " é "+tipo.getTipo()+", mas o valor atribuído é "+atrb.getTipoVerdadeiro()+" (" + linha + "," + coluna + ").");
        }
        return atrb;
    }


    @Override
    public Expression visitInteiro(GramaticaParser.NumeroContext ctx) {
        String numtxt = ctx.getChild(0).getText();
        return new ValorInteiro(Integer.parseInt(numtxt));
    }

    @Override
    public Expression visitReal(GramaticaParser.NumeroContext ctx) {
        String numtxt = ctx.getChild(0).getText();
        return new ValorReal(Float.parseFloat(numtxt));
    }

    @Override
    public Expression visitVariavel(GramaticaParser.VariavelContext ctx) {
        String id=ctx.getChild(0).getText();
        return new Variavel(id);
    }

    @Override
    public Expression visitSoma(GramaticaParser.SomaContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        OpArit soma = new OpAritSoma(left, right);
        if (left.type=="int" && right.type=="int"){
            soma.setType("int");
        }
        else{
            soma.setType("float");
        }
        return  soma;
    }

    @Override
    public Expression visitMultiplicacao(GramaticaParser.SomaContext ctx) {
        Expression left=visit(ctx.getChild(0));
        Expression right=visit(ctx.getChild(2));
        OpArit multiplicacao = new OpAritMultiplicacao(left, right);
        if (left.type=="int" && right.type=="int"){
            soma.setType("int");
        }
        else{
            soma.setType("float");
        }
        return multiplicacao;
    }
}
