package games;
import java.util.Scanner;

public class TickTacToe{
	games.Player Player1, Player2;
	public Board board;
	
	public void startGame() {
		Scanner s = new Scanner(System.in);
		Player1 = takePlayerInput(1);
		Player2 = takePlayerInput(2);
		while(Player1.getSymbol() == Player2.getSymbol()) {
			System.out.println("Symbol Already taken !! Pick another one ...");
			char symbol = s.next().charAt(0);
			Player2.setSymbol(symbol);
		}
	
		// CREATION OF BOARD
		board = new Board(Player1.getSymbol(), Player2.getSymbol());
		
		// CONDUCTING GAME
		boolean isPlayer1Turn = true;
		int status = Board.INCOMPLETE;
		while(status == Board.INCOMPLETE || status == Board.INVALID) {
			// PLAYER 1 TURN
			if(isPlayer1Turn) {
				System.out.println("Player1 = "+Player1.getName()+"'s turn");
				System.out.print("Enter x-coordinate : ");
				int x = s.nextInt();
				System.out.print("Enter y-coordinate : ");
				int y = s.nextInt();
				status = board.move(Player1.getSymbol(), x, y);
				if(status != Board.INVALID) {
					isPlayer1Turn=false;
					board.print();
				}else {
					System.out.println("Invalid Move !! Try Again !!");
				}
			}
			// PLAYER 2 TURN
			else {
				System.out.println("Player1 = "+Player2.getName()+"'s turn");
				System.out.print("Enter x-coordinate : ");
				int x = s.nextInt();
				System.out.print("Enter y-coordinate : ");
				int y = s.nextInt();
				status = board.move(Player2.getSymbol(),x,y);
				if(status != board.INVALID) {
					isPlayer1Turn=true;
					board.print();
				}
			}
		}
		if(status == Board.PLAYER1_WINS) {
			System.out.println("Player 1 "+Player1.getName()+" won the game");
		}else if(status == Board.PLAYER2_WINS){
			System.out.println("Player 2 "+Player2.getName()+" won the game");
		}else {
			System.out.println("Draw !!");
		}
	}
		
	
	private Player takePlayerInput(int num) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter Player : "+num+" : name : ");
		String name = s.nextLine();
		System.out.println("Enter Player : "+num+" :: symbol : ");
		char symbol = s.next().charAt(0);
		Player p = new Player(name, symbol);
		return p;
	}

	public static void main(String[] args) {
		TickTacToe t = new TickTacToe();
		t.startGame();
	}
}
