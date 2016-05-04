package gameEngine;

import java.awt.Color;

public class Cell {
	static final int SIZE = 30;
	private int y;
	private int Coloumn;
	private Color color;

	public Cell(int y, int Coloumn, Color color){
		this.Coloumn = Coloumn;
		this.color = color;
		this.y = y;
	}

	public Color getColor() {
		return null;
	}

	public int getColumn() {
		return this.Coloumn;
	}

	public int getY() {
		return this.y;
	}

	public void setColoumn(int newColoumn){
		this.Coloumn = newColoumn;
	}

	public void setY(int newY){
		this.y = newY;
	}

	public void moveDown(){
		this.y = ++this.y;
	}

	public static boolean overlap(Cell c1, Cell c2){
		if(c1.Coloumn == c2.Coloumn){
			if(Math.abs(c1.y - c2.y) < 30 )
				return false;
		}
	return true;
	}



}
