package tp;

public class Token {
	private final TokenType type;
	private final String lexem;
	
	public Token(TokenType type, String lexem) {
		this.type = type;
		this.lexem = lexem;
	}

	public TokenType getType() {
		return type;
	}

	public String getLexem() {
		return lexem;
	}
	
	@Override
	public String toString() {
		return "Token{ type: " + type + ", " + "lexem: " + lexem + "}";
	}
	
}
