// Generated from Gramatica.g4 by ANTLR 4.9.1

package antlr4;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GramaticaParser}.
 */
public interface GramaticaListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by the {@code Programa}
     * labeled alternative in {@link GramaticaParser#prog}.
     *
     * @param ctx the parse tree
     */
    void enterPrograma(GramaticaParser.ProgramaContext ctx);

    /**
     * Exit a parse tree produced by the {@code Programa}
     * labeled alternative in {@link GramaticaParser#prog}.
     *
     * @param ctx the parse tree
     */
    void exitPrograma(GramaticaParser.ProgramaContext ctx);

    /**
     * Enter a parse tree produced by the {@code Atribuicao}
     * labeled alternative in {@link GramaticaParser#attr}.
     *
     * @param ctx the parse tree
     */
    void enterAtribuicao(GramaticaParser.AtribuicaoContext ctx);

    /**
     * Exit a parse tree produced by the {@code Atribuicao}
     * labeled alternative in {@link GramaticaParser#attr}.
     *
     * @param ctx the parse tree
     */
    void exitAtribuicao(GramaticaParser.AtribuicaoContext ctx);

    /**
     * Enter a parse tree produced by the {@code Multiplicacao}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void enterMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);

    /**
     * Exit a parse tree produced by the {@code Multiplicacao}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void exitMultiplicacao(GramaticaParser.MultiplicacaoContext ctx);

    /**
     * Enter a parse tree produced by the {@code Variavel}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void enterVariavel(GramaticaParser.VariavelContext ctx);

    /**
     * Exit a parse tree produced by the {@code Variavel}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void exitVariavel(GramaticaParser.VariavelContext ctx);

    /**
     * Enter a parse tree produced by the {@code Soma}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void enterSoma(GramaticaParser.SomaContext ctx);

    /**
     * Exit a parse tree produced by the {@code Soma}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void exitSoma(GramaticaParser.SomaContext ctx);

    /**
     * Enter a parse tree produced by the {@code Real}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void enterReal(GramaticaParser.RealContext ctx);

    /**
     * Exit a parse tree produced by the {@code Real}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void exitReal(GramaticaParser.RealContext ctx);

    /**
     * Enter a parse tree produced by the {@code Inteiro}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void enterInteiro(GramaticaParser.InteiroContext ctx);

    /**
     * Exit a parse tree produced by the {@code Inteiro}
     * labeled alternative in {@link GramaticaParser#opArit}.
     *
     * @param ctx the parse tree
     */
    void exitInteiro(GramaticaParser.InteiroContext ctx);
}