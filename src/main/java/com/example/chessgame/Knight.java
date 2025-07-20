package com.example.chessgame;

import java.util.Objects;

public class Knight extends Piece {

    public Knight(String color, int x, int y) {
        super(color, x, y);
        super.setType('N');
    }

    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
            return false;

        int dx = Math.abs(newX - this.getX());
        int dy = Math.abs(newY - this.getY());
        if (!((dx == 2 && dy == 1) || (dx == 1 && dy == 2)))
            return false;

        // Check if path is clear (it is always true)
        if (isPathClear(newX, newY, chessTable)) {
            Piece dest = chessTable.getPiece(newX, newY);
            if (dest == null || !Objects.equals(chessTable.getPiece(newX, newY).getColor(), this.getColor())) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathClear(int x, int y, ChessTable chessTable) {
        return true;
    }

    @Override
    public String toString() {
        return this.getColor().equals("white") ? "N" : "n";
    }
}