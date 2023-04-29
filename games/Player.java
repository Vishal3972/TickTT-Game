package games;

public class Player {
	private String name;
	private char symbol;
	
	public Player(String name, char symbol) {
		setName(name);
		setSymbol(symbol);
	}
	
	public void setName(String name) {
		if(name.length() == 0) {
			System.out.println("Enter valid name");
			setName(name);
		}
		this.name=name;
	}
	
	public void setSymbol(char symbol) {
		System.out.println("Please Enter symbol");
		if(symbol == '\0') {
			setSymbol(symbol);
		}
		this.symbol=symbol;
	}
	
	public String getName() {
		return name;
	}
	
	public char getSymbol() {
		return symbol;
	}
}
