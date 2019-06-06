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

/**
 * 
 * @author Matthew Kustec and Connor Hanswyk
 *
 */
public class AttackBoard {
    private static Cell[][] aBoard;
    private int rows;
    private static int cols;
	
    // Creates Attack Board
    /**
     * Attack Board
     * @param aRows
     * @param aCols
     * Creates a 2D Array of Cells
     */
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

    // Places ships on Attack Board
    /**
     * placeShips
     * @param ships
     * Places ships on board
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
                    
                    // An ArrayList to store coordinates of ships on the board
                    ArrayList<Cell> coordinates = new ArrayList<>();

                    // get the first column and remove it 
                    int col = cols.get(0);
                    cols.remove(0);
                    int rowStart = rand.nextInt(rows-s.getSize());

                    for (int n = rowStart; n < rowStart + s.getSize(); n++) {
                            aBoard[n][col].setState(CellState.MYSTERYSHIP);
                            coordinates.add(aBoard[n][col]);
                    }
            }
            display();
    }
    
    // Takes the input of player and determines if it hits or misses the targetted ships
    /**
     * isAttacked
     * @param input
     * @param ships
     * Attacks the AI's ships using input from player
     */
    public void isAttacked(String input, Ship[] ships){
        String letter = input.substring(0, input.length()-1);
        String number = input.substring(input.length()-1);
        int numberCoordinate;
        int letterCoordinate;
        
        letterCoordinate = letterConversion(letter);
        numberCoordinate = numberConversion(number);
      
        if(aBoard[numberCoordinate][letterCoordinate].getState() == CellState.MYSTERYSHIP) {
            aBoard[numberCoordinate][letterCoordinate].setState(CellState.HIT);
            /*
            for (int i = 0; i < 5; i++){
                //Trying to determine which ship was hit at given coordinate? HELP?
                Ship s = ships[i];
                s.shipWasHit();
            }
            */
            BattleshipDriver.computerShipLives = BattleshipDriver.computerShipLives-1;
            System.out.println("Hit!");
        }
        
        else if(aBoard[numberCoordinate][letterCoordinate].getState() == CellState.UNKNOWN) {
            aBoard[numberCoordinate][letterCoordinate].setState(CellState.MISS);
            System.out.println("Miss!");
        }
        
        else {
            System.out.println("You have already selected this coordinate. Please choose another");
        }
    }
    
    // Converts input coordinate letter into number to be compared with the Attck Board
    /**
     * letterConversion
     * @param letter
     * @return
     * Converts letter String into a number to compare on board
     */
    public int letterConversion(String letter) {
        
        switch (letter) {
		case "A":
			return 0;
		case "B":
			return 1;
		case "C":
			return 2;
                case "D":
			return 3;
                case "E":
			return 4;
                case "F":
			return 5;
                case "G":
			return 6;
                case "H":
			return 7;
                case "I":
			return 8;
                case "J":
			return 9;
		default:
			return 0;
		}
    }
    
    /**
     * numberConversion
     * @param number
     * @return
     * Converts number into an int to compare with board
     */
    public int numberConversion(String number) {
        
        switch (number) {
		case "0":
			return 0;
		case "1":
			return 1;
		case "2":
			return 2;
                case "3":
			return 3;
                case "4":
			return 4;
                case "5":
			return 5;
                case "6":
			return 6;
                case "7":
			return 7;
                case "8":
			return 8;
                case "9":
			return 9;
		default:
			return 0;
		}
    }
    
    // Displays the Attack Board
    /**
     * Displays the board
     */
    public void display() {
        String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
        System.out.println("ATTACK BOARD");
        System.out.print("   ");
        for (String letter : letters)
            System.out.printf("%3s ", letter);
            System.out.println();

        for (int i = 0; i < rows; i++) {
            System.out.printf("%3d",(i));
            for (int j = 0; j < cols; j++) {
                System.out.printf("%3s ", aBoard[i][j]);
            }
            System.out.println();

        }
    }
}
