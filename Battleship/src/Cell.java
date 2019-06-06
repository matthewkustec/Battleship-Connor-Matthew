/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Matthew
 */
public class Cell {
private CellState state;
	
	
	public Cell(CellState cs) {
		state = cs;
		
	}
	

	
	public void setState (CellState cs){
		state = cs;
	}
	
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
