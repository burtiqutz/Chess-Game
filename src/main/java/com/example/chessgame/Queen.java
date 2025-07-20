package com.example.chessgame;

import java.util.Objects;

public class Queen extends Piece {

    public Queen(String color, int x, int y) {
        super(color, x, y);
        super.setType('Q');
    }
    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
            return false;

        if (this.getX() == newX || this.getY() == newY) {
            //move like a rook
            if (isPathClearRook(newX, newY, chessTable)) {
                Piece dest = chessTable.getPiece(newX, newY);
                if(dest == null || !Objects.equals(chessTable.getPiece(newX, newY).getColor(), this.getColor())){
                    return true;
                }
            }
        }
        if(Math.abs(newX - this.getX()) == Math.abs(newY - this.getY())){
            //moves like a bishop
            if (isPathClearBishop(newX, newY, chessTable)) {
                Piece dest = chessTable.getPiece(newX, newY);
                if(dest == null || !Objects.equals(chessTable.getPiece(newX, newY).getColor(), this.getColor())){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPathClearRook(int x, int y, ChessTable chessTable) {
        if (this.getX() == x) {  // Moving vertically
            int step = (y > this.getY()) ? 1 : -1; // Determine direction of move
            for (int i = this.getY() + step; i != y; i += step) {
                if (chessTable.getPiece(x, i) != null) {
                    return false; // Path blocked by another piece
                }
            }
        } else if (this.getY() == y) {
            int step = (x > this.getX()) ? 1 : -1;
            for (int i = this.getX() + step; i != x; i += step) {
                if (chessTable.getPiece(i, y) != null) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isPathClearBishop(int x, int y, ChessTable chessTable) {
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

    private boolean isPathClear(int x, int y, ChessTable chessTable) {

        return true;
    }
    @Override
    public String toString() {
        if(this.getColor().equals("white")){
            return "Q";
        } else
            return "q";
    }
}
