/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew Kustec and Connor Hanswyk
 */
public class Cell {
private CellState state;
	
	/**
	 * Cell
	 * @param cs
	 */
	public Cell(CellState cs) {
		state = cs;
		
	}
	

	/**
	 * setState
	 * @param cs
	 * Sets the state of the cell
	 */
	public void setState (CellState cs){
		state = cs;
	}
	
	/**
	 * CellState
	 * @return
	 * Gets the CellState
	 */
	public CellState getState() {
		return state;
	}

	public String toString() {
		switch (state) {
		case HIT:
			return "X";
		case MISS:
			return "O";
		case UNKNOWN:
			return "?";
		case EMPTY:
			return "-";
		case SHIP:
			return "+";
		case MYSTERYSHIP:
			return "?";
		default:
			return "?";
		}
	}
}
