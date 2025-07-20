package com.example.chessgame;

import java.util.Objects;

public class Rook extends Piece {

    public Rook(String color, int x, int y) {
        super(color, x, y);
        super.setType('R');
    }
    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
            return false;

        if (this.getX() == newX || this.getY() == newY) {
            // Check if path is clear
            if (isPathClear(newX, newY, chessTable)) {
                Piece dest = chessTable.getPiece(newX, newY);
                if (dest == null || !Objects.equals(dest.getColor(), this.getColor())) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isPathClear(int x, int y, ChessTable chessTable) {
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

    public String toString() {
        if(this.getColor().equals("white")){
            return "R";
        } else
            return "r";
    }
}
