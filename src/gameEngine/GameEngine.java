package gameEngine;

import com.sun.prism.impl.ps.CachingEllipseRep;

public class GameEngine {
	private Piece movinegPiece;
	private int numberOfColoumns;
	private int numberOfy;

	public int getNumberOfColoumns() {
		return numberOfColoumns;
	}

	public int getNumberOfy() {
		return numberOfy;
	}

	public void rotateClockwise() {
		movinegPiece.rotateClockwise();
		for (int i = 0; i < movinegPiece.getCells().length; i++) {
			for (int j = 0; j < getStableCells().length; j++) {
				if(Cell.overlap(movinegPiece.getCells()[i], getStableCells()[j])){
					movinegPiece.rotateCounterClockwise();
				}
			}
		}
		if(!movinegPiece.isValidPiece()){
			movinegPiece.rotateCounterClockwise();
		}

	}

	public void rotateCounterClockwise() {
		movinegPiece.rotateCounterClockwise();
		for (int i = 0; i < movinegPiece.getCells().length; i++) {
			for (int j = 0; j < getStableCells().length; j++) {
				if(Cell.overlap(movinegPiece.getCells()[i], getStableCells()[j])){
					movinegPiece.rotateClockwise();
				}
			}
		}
		if(!movinegPiece.isValidPiece()){
			movinegPiece.rotateClockwise();
		}
	}

	public void shiftLeft() {
		for (int i = 0; i < getMovablePiece().length; i++) {

		}
	}

	public void shiftRight() {
		for (int i = 0; i < getMovablePiece().length; i++) {
			int currentColoumn = getMovablePiece()[i].getColumn();
			getMovablePiece()[i].setColoumn(--currentColoumn);
		}
	}

	public void update() throws GameOverException {

	}

	public Cell[] getStableCells() {
		return null;
	}

	public Cell[] getMovablePiece() {
		return null;
	}

}
