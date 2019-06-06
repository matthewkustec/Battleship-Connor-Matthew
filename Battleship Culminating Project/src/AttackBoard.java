import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class AttackBoard {
	private static Cell[][] aBoard;
	private int rows;
	private static int cols;
	
	public AttackBoard(int aRows, int aCols) {
		aBoard = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				aBoard[i][j] = new Cell(CellState.UNKNOWN); // no color
			}
		}
		
		// display letter and number coordinates on board
				//aBoard [0][1] = "a";
	}
	
	public void placeShips(Ship[] ships) {
		Random rand = new Random();
		int shipsPlaced = 0;
		ArrayList<Integer> cols = new ArrayList<>();
		
		for (int i=0; i<10; i++) {
			cols.add(i);
		}
		
		// shuffle the cols for randomness
		Collections.shuffle(cols);
		
		
		for (int i = 0; i < 5; i++) {
			Ship s = ships[i];
			
			// get the first column and remove it 
			int col = cols.get(0);
			cols.remove(0);
			int rowStart = rand.nextInt(rows-s.getSize());
			
			for (int n = rowStart; n < rowStart + s.getSize(); n++) {
				aBoard[n][col].setState(CellState.MYSTERYSHIP);
			}
			shipsPlaced = shipsPlaced + 1;
			display();
		}
	}
	
	public void display() {
		String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
		System.out.println("ATTACK BOARD");
		System.out.print("   ");
		for (String letter : letters)
				System.out.printf("%3s ", letter);
		System.out.println();
		
		for (int i = 0; i < rows; i++) {
			System.out.printf("%3d",(i+1));
			for (int j = 0; j < cols; j++) {
				System.out.printf("%3s ", aBoard[i][j]);
			}
			System.out.println();
	
		}
	}
}
