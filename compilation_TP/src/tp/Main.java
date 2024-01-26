package tp;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        String input = "(1+2)*333";
        Lexer lexer = new Lexer(input);
        List<Token> tokens = lexer.getResult();
        Parser parser = new Parser(tokens);
        int result = parser.parseExpression();
        System.out.println("Le résultat de l'expression '" + input + "' est : " + result);
    }
}

