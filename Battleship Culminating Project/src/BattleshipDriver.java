import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

public class BattleshipDriver {

	public static void main(String[] args) {
		
		// Setup constants for board size
		final int ROWS = 10;
		final int COLS = 10;
		final int CARRIER_SIZE = 5;
	    final int BATTLESHIP_SIZE = 4;
	    final int CRUISER_SIZE = 3;
	    final int SUBMARINE_SIZE = 3;
	    final int DESTROYER_SIZE = 2;
		
		// Create the boards
		AttackBoard aboard = new AttackBoard(ROWS, COLS);
		DefenseBoard dboard = new DefenseBoard(ROWS, COLS);
		
		//aboard.display();
		//dboard.display();
		
		// Create an array of ships
		Ship[] ships = new Ship[5];
		
		
		ships[0] = new Ship("Carrier", CARRIER_SIZE);
		ships[1] = new Ship("Battleship", BATTLESHIP_SIZE);
		ships[2] = new Ship("Cruiser", CRUISER_SIZE);
		ships[3] = new Ship("Submarine",SUBMARINE_SIZE);
		ships[4] = new Ship("Destroyer", DESTROYER_SIZE);
		
		dboard.placeShips(ships);
		aboard.placeShips(ships);
		
		aboard.display();
		dboard.display();
		
		//Takes player input of desired target coordinate
		Scanner in = new Scanner(System.in);
		
		System.out.println("Where would you like to fire? (Capital letter and number)");		
		String input = in.nextLine().trim();
		/*
		 * if (aBoard[][]==CellState.SHIP) {
			
		}
		*/
		System.out.println(Pattern.matches("[A-J][0-9]",input));
		
	}

}
