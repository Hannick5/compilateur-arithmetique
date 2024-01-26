package tp;

import java.util.List;

public class Parser {
    private List<Token> tokens;
    private int pos = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public int parseExpression() {
        int num = parseFois();
        while (pos < tokens.size() && (isPlus() || isMoins())) {
            Token op = tokens.get(pos++);
            if (op.getType() == TokenType.PLUS) {
                num += parseFois();
            } else if (op.getType() == TokenType.MOINS) {
                num -= parseFois();
            }
        }
        return num;
    }

    private int parseFois() {
        int num = parseParenthesis();
        while (pos < tokens.size() && isFois()) {
            Token op = tokens.get(pos++);
            if (op.getType() == TokenType.FOIS) {
                num *= parseParenthesis();
            }
        }
        return num;
    }

    private int parseParenthesis() {
        if (isNumber()) {
            return Integer.parseInt(tokens.get(pos++).getLexem());
        } else if (isLeftParenthesis()) {
            pos++;
            int num = parseExpression();
            if (isRightParenthesis()) {
                pos++;
                return num;
            }
        }
        throw new RuntimeException("Unexpected token " + tokens.get(pos));
    }
    
    private boolean isNumber() {
    	return tokens.get(pos).getType() == TokenType.NUMBER;
    }
    
    private boolean isPlus() {
    	return tokens.get(pos).getType() == TokenType.PLUS;
    }
    
    private boolean isMoins() {
    	return tokens.get(pos).getType() == TokenType.MOINS;
    }
    
    private boolean isFois() {
    	return tokens.get(pos).getType() == TokenType.FOIS;
    }
    
    private boolean isLeftParenthesis() {
    	return tokens.get(pos).getType() == TokenType.LPAREN;
    }
    
    private boolean isRightParenthesis() {
    	return tokens.get(pos).getType() == TokenType.RPAREN;
    }
}
