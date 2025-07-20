package com.example.chessgame;

import java.util.Objects;

public class Bishop extends Piece {

    public Bishop(String color, int x, int y) {
        super(color, x, y);
        super.setType('B');
    }
    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
            return false;

        if(isPathClear(newX, newY, chessTable)){
            Piece dest = chessTable.getPiece(newX, newY);
            return dest == null || !Objects.equals(dest.getColor(), this.getColor());
        }

        return false;
    }

    private boolean isPathClear(int x, int y, ChessTable chessTable) {
        //bishop can move diagonally
        int xDirection = (x > this.getX()) ? 1 : -1;
        int yDirection = (y > this.getY()) ? 1 : -1;

        int currentX = this.getX() + xDirection;
        int currentY = this.getY() + yDirection;

        while(currentX != x && currentY != y) {
            if(chessTable.getPiece(currentX, currentY) != null){
                return false;   //path blocked, cant go at specified destination
            }
            currentX += xDirection;
            currentY += yDirection;
        }

        return true;
    }
    @Override
    public String toString() {
        if(this.getColor().equals("white")){
            return "B";
        } else
            return "b";
    }
}