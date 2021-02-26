package app;

import antlr4.GramaticaLexer;
import antlr4.GramaticaParser;
import expr.AntlrToProgram;
import expr.Programa;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.util.Scanner;

public class Analisador {
    private static GramaticaParser getParser(String nomeArquivo) {
        GramaticaParser parser = null;

        try {
            CharStream input = CharStreams.fromFileName(nomeArquivo);
            GramaticaLexer lexer = new GramaticaLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            parser = new GramaticaParser(tokens);
            /*
            parser = new GramaticaParser(
                new CommonTokenStream(
                    new GramaticaLexer(
                        CharStreams.fromFileName(nomeArquivo)
                    )
                )
            );
            */
        } catch (IOException e) {
            e.printStackTrace();
        }

        return parser;
    }

    public static void main(String[] args) {
        System.out.print("Nome do arquivo de entrada: ");
        String fileName = new Scanner(System.in).nextLine();
        GramaticaParser parser = getParser(fileName);

        ParseTree ast = parser.prog();

        AntlrToProgram progVisitor = new AntlrToProgram();
        System.out.println("***Visitando AST");
        Programa prog = progVisitor.visit(ast);

        if (progVisitor.semanticError.isEmpty()) {
            System.out.println("Resultado da Análise: OK");
        } else {
            System.out.println("Resultado da Análise: " + progVisitor.semanticError.size() + "erros encontrados");
            for (String err : progVisitor.semanticError) {
                System.out.println(err);
            }
        }
    }
}
