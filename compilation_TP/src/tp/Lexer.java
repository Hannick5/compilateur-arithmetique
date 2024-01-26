package tp;

import java.util.ArrayList;
import java.util.List;
	
public class Lexer {
	private List<Token> result = new ArrayList<Token>();
	
	public Lexer(String input) {
		for(int i = 0; i < input.length(); i++) {
			switch(input.charAt(i)) {
			case '(':
				result.add(new Token(TokenType.LPAREN, "("));
				break;
			case ')':
				result.add(new Token(TokenType.RPAREN, ")"));
				break;
			case '0':
			case '1':
			case '2':
			case '3':
			case '4':
			case '5':
			case '6':
			case '7':
			case '8':
			case '9':
				StringBuilder number = new StringBuilder();
			    while (i < input.length() && Character.isDigit(input.charAt(i))) {
			        number.append(input.charAt(i));
			        i++;
			    }
			    result.add(new Token(TokenType.NUMBER, number.toString()));
			    i--;
			    break;
			case '-':
				result.add(new Token(TokenType.MOINS, "-"));
				break;
			case '+':
				result.add(new Token(TokenType.PLUS, "+"));
				break;
			case '*':
				result.add(new Token(TokenType.FOIS, "*"));
				break;
			case ' ':
				result.add(new Token(TokenType.NULL, " "));
				break;
			}
			
		}
		
		
	}
	
	public List<Token> getResult(){
		return this.result;
	}
 	
}
