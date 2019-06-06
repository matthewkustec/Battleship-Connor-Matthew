import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class DefenseBoard {
	private static Cell[][] dBoard;
	private static int rows;
	private static int cols;
	
	public DefenseBoard(int aRows, int aCols) {
		dBoard = new Cell[aRows][aCols];
		rows = aRows;
		cols = aCols;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				dBoard[i][j] = new Cell(CellState.EMPTY); // no color
			}
		}
	}
	
	/**
	 * 
	 * @param ships
	 */
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
				dBoard[n][col].setState(CellState.SHIP);
			}
			shipsPlaced = shipsPlaced + 1;
			display();
		}
	}
		
	
	
	// display letter and number coordinates on board
	public void display() {
		String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
		System.out.println("DEFENSE BOARD");
		System.out.print("   ");
		for (String letter : letters)
				System.out.printf("%3s ", letter);
		System.out.println();
		
		for (int i = 0; i < rows; i++) {
			System.out.printf("%3d",(i));
			for (int j = 0; j < cols; j++) {
				System.out.printf("%3s ", dBoard[i][j]);
			}
			System.out.println();
	
		}
	}
}
