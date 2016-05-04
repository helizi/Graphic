package gameEngine;


import java.awt.*;
import java.util.ArrayList;

public class Piece {
    private boolean[][] pattern;
    private Color color;
    private int Coloumn;
    private int y;

    public void rotateClockwise(){
        int len = pattern.length;
        boolean[][] newPattern  = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                newPattern[j][len - 1 - i] = pattern[i][j];
            }
        }
        pattern = newPattern;
    }
    public void rotateCounterClockwise(){
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public Cell[] getCells(){
        ArrayList<Cell> toReturnCells = new ArrayList<>();
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if(pattern[i][j]){
                    Cell cellOfThesePiece = new Cell(y + (pattern.length - 1 + i)*Cell.SIZE, Coloumn + j, color);
                    toReturnCells.add(cellOfThesePiece);
                }
            }
        }
        return toReturnCells.toArray(new Cell[toReturnCells.size()]);
    }
    public boolean isValidPiece(){
        for (int i = 0; i < pattern.length; i++) {
            for (int j = 0; j < pattern.length; j++) {
                if(pattern[i][j]){
                    if(Coloumn + j < 0)
                        return false;
                    if(Coloumn + j >= GameEngine.);

                    if()
                }

            }
        }
    }

    public void shiftRight(){
        Coloumn = ++Coloumn;
    }

    public void shifLeft(){
        Coloumn = --Coloumn;
    }

    public void moveDown(){
        y = y - 5;
    }

    public void moveUp(){
        y = y + 5;
    }

    public int getY() {
        return y;
    }
}
