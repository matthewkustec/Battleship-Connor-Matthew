/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
public class DefenseBoard {
    private static Cell[][] dBoard;
    private static int rows;
    private static int cols;
    private Object xrand;
	
    /**
     * Defense Board 
     * @param aRows
     * @param aCols
     * Creates 2D Array of Cells / Makes grid
     */
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
    * placeShips
    * @param ships
    * Places array of ship objects onto Defense Board
    */
    public void placeShips(Ship[] ships) {
        Random rand = new Random();
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
            }
            display();
	}
		
	
	
    // display letter and number coordinates on board
    /**
     * Displays board
     */
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

    /**
     * isAttacked
     * @param ships
     * Takes AI's target coordinate and updates Defense Board if Hit or Missed
     */
    public void isAttacked(Ship[] ships) {
        boolean moveMade = false;
        
        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> cols = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            rows.add(i);
            cols.add(i);
        }
        
        Random xRand = new Random();
        Random yRand = new Random();
        int xCoordinate = rows.get(xRand.nextInt(rows.size()));
        int yCoordinate = cols.get(yRand.nextInt(cols.size()));
      
        while(moveMade == false) {
            if(dBoard[xCoordinate][yCoordinate].getState() == CellState.SHIP) {
                dBoard[xCoordinate][yCoordinate].setState(CellState.HIT);
                /*
                for (int i = 0; i < 5; i++){
                //Trying to determine which ship was hit at given coordinate? HELP?
                Ship s = ships[i];
                s.shipWasHit();
                }
                */
                BattleshipDriver.playerShipLives = BattleshipDriver.playerShipLives-1;
                moveMade = true;
                System.out.println("The computer made a hit!");
            }
        
            else if(dBoard[xCoordinate][yCoordinate].getState() == CellState.EMPTY) {
                dBoard[xCoordinate][yCoordinate].setState(CellState.MISS);
                moveMade = true;
                System.out.println("The computer missed!");
            }
            else {
                moveMade = false;
            }    
        }    
    }
}
