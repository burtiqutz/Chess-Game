package com.example.chessgame;

import java.util.Objects;

public class Knight extends Piece {

    public Knight(String color, int x, int y) {
        super(color, x, y);
        super.setType('K');
    }

    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {
        if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
            return false;

        // Check if path is clear
        if (isPathClear(newX, newY, chessTable)) {
            Piece dest = chessTable.getPiece(newX, newY);
            if (dest == null || !Objects.equals(chessTable.getPiece(newX, newY).getColor(), this.getColor())) {
                return true;
            }
        }

        return false;
    }

    private boolean isPathClear(int x, int y, ChessTable chessTable) {
        //knight moves in an L shape
        //path cant really be blocked for a knight, so we return true
        return true;
    }

    @Override
    public String toString() {
        if (this.getColor().equals("white")) {
            return "K";
        } else
            return "k";
    }
}