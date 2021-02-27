package expr;

import antlr4.GramaticaBaseVisitor;
import antlr4.GramaticaParser;
import org.antlr.v4.runtime.Token;

import java.util.ArrayList;
import java.util.List;

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

    private SymbleTable symbleTable;

    public AntlrToExpression(List<String> semanticErrors, SymbleTable symbleTable) {
        declaredVariables = new ArrayList<>();
        this.semanticErrors = semanticErrors;
        this.symbleTable=symbleTable;
    }

    @Override
    public Expression visitAtribuicao(GramaticaParser.AtribuicaoContext ctx) {
        Atribuicao atrb;
        String type = "INVALIDO";
        String id = "INVALIDO";
        String value = "INVALIDO";
        boolean erro = false;

        if (ctx.TIPO() != null) type = ctx.TIPO().getText();
        else erro = true;

        if (ctx.ID() != null) id = ctx.ID().getText();
        else erro = true;

        if (ctx.INT() != null) {
            value = ctx.INT().getText();
        }
        else if (ctx.FLOAT() != null) {
            value = ctx.FLOAT().getText();
        }
        else erro = true;

        atrb = new Atribuicao(id, type, value);

        if (symbleTable.check(id)) {
            semanticErrors.add("ERRO: Variavel já declarada : " + id);
            erro = true;
        }

        if (!atrb.isValid()) {
            semanticErrors.add("ERRO: Variável " + id + " é " + atrb.tipo.getTipo() + ", mas o valor atribuído é " + atrb.getTipoVerdadeiro());
            erro = true;
        }

        if (!erro) {
            symbleTable.add(id, atrb.valor);
        }

        System.out.println("Visitou Atribuicao");
        System.out.println(atrb);

        return atrb;
    }


    @Override
    public Expression visitInteiro(GramaticaParser.InteiroContext ctx) {
        String numtxt = ctx.getChild(0).getText();

        ValorInteiro inteiro = new ValorInteiro(Integer.parseInt(numtxt));
        inteiro.setType("INT");

        System.out.println("Visitou Inteiro");
        System.out.println(inteiro);

        return inteiro;
    }

    @Override
    public Expression visitReal(GramaticaParser.RealContext ctx) {
        String numtxt = ctx.getChild(0).getText();

        ValorReal real = new ValorReal(Float.parseFloat(numtxt));
        real.setType("FLOAT");

        System.out.println("Visitou Real");
        System.out.println(real);

        return real;
    }

    @Override
    public Expression visitVariavel(GramaticaParser.VariavelContext ctx) {
        String id = ctx.getChild(0).getText();

        Variavel variavel = new Variavel(id);
        if (!symbleTable.check(id)) {
            semanticErrors.add("ERRO: Variavel nao declarada : "+id);
            variavel.setType("ERRO_VND");
        }
        else if (symbleTable.valueof(id) instanceof ValorInteiro) {
            variavel.setType("INT");
        }
        else {
            variavel.setType("FLOAT");
        }

        System.out.println("Visitou Variavel");
        System.out.println(variavel);

        return variavel;
    }

    @Override
    public Expression visitSoma(GramaticaParser.SomaContext ctx) {
        Expression left= visit(ctx.getChild(0));
        Expression right= visit(ctx.getChild(2));

        OpArit soma = new OpAritSoma(left, right);
        if (left.getType().equals("ERRO_VND") || right.getType().equals("ERRO_VND")) {
            soma.setType("ERRO_VND");
        }
        else if (left.getType().equals("INT") && right.getType().equals("INT")){
            soma.setType("INT");
        }
        else {
            soma.setType("FLOAT");
        }

        System.out.println("Visitou Soma");
        System.out.println(soma);

        return  soma;
    }

    @Override
    public Expression visitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx) {
        Expression left= visit(ctx.getChild(0));
        Expression right= visit(ctx.getChild(2));

        OpArit multiplicacao = new OpAritMultiplicacao(left, right);
        if (left.getType().equals("ERRO_VND") || right.getType().equals("ERRO_VND")) {
            multiplicacao.setType("ERRO_VND");
        }
        else if (left.getType().equals("INT") && right.getType().equals("INT")){
            multiplicacao.setType("INT");
        }
        else {
            multiplicacao.setType("FLOAT");
        }

        System.out.println("Visitou Multiplicacao");
        System.out.println(multiplicacao);

        return multiplicacao;
    }
}
