/*
 * Battleship game Driver. Uses classes DefenseBoard, AttackBoard, Ship, CellState, and Cell
 */

/**
 *
 * @author Matthew Kustec and Connor Hanswyk
 */
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.ArrayList;

/**
 * Battleship Game Culminating Project: Driver
 * @author Matthew Kustec and Connor Hanswyk
 *
 */
public class BattleshipDriver {
    /**
     * Lives for player and AI to be used as Game Winning Conditions
     */
	public static int playerShipLives;
    public static int computerShipLives;
    
    /**
     * Main Method / Runs Game
     * @param args
     */
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
		
		// Create an array of ships
		Ship[] ships = new Ship[5];
		
		ships[0] = new Ship("Carrier", CARRIER_SIZE);
		ships[1] = new Ship("Battleship", BATTLESHIP_SIZE);
		ships[2] = new Ship("Cruiser", CRUISER_SIZE);
		ships[3] = new Ship("Submarine",SUBMARINE_SIZE);
		ships[4] = new Ship("Destroyer", DESTROYER_SIZE);
		
                // Places ships on boards and displays boards. 
                // Player's ships are visible, AI's ships are hiddden 
		aboard.placeShips(ships);
		dboard.placeShips(ships);
                
                // Sets lives for player and computer (one life per each cell occupied by a ship)
                playerShipLives = 17;
                computerShipLives = 17;
		
		//Takes player input of desired target coordinate
		Scanner in = new Scanner(System.in);
		
                System.out.println("Welcome to Battleship!");
                
                boolean gameIsDone = false;
                boolean computerWon = false;
                boolean playerWon = false;
                
                // Ensures that game continues until game is ended by result of player or computer winning
                while(gameIsDone == false) {
                    
                    System.out.println("Where would you like to fire? (Capital letter and number)");		
                    String input = in.nextLine().trim();
                    
                    // Ensures player target input is a Letter-Number coordinate (ie: A2)
                    if(Pattern.matches("[A-J][0-9]", input)){
                        // Player and computer attack
                        aboard.isAttacked(input, ships);
                        dboard.isAttacked(ships);
                        
                        // Update boards
                        aboard.display();
                        dboard.display();
                        
                        if (playerShipLives == 0) {
                            gameIsDone = true;
                            computerWon = true;
                        }
                        else if(computerShipLives == 0){
                            gameIsDone = true;
                            playerWon = true;
                        }
                    }
                    // Informs player if Letter-Number coordinate was not entered
                    else {
                        System.out.println("Error. Please enter Letter-Number coordinates (ie: A2)");
                    }
                }
                
                // Output if player lost
                if(computerWon == true){
                    System.out.println("Oh no! You lose! Better luck next time :)");
                }
                
                // Output if player won
                else {
                    System.out.println("Congratulations! You won the game! :)");
                }
        }
}
