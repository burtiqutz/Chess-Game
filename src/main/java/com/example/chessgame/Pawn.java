package com.example.chessgame;

import java.util.Objects;

public class Pawn extends Piece {

    public Pawn(String color, int x, int y) {
        super(color, x, y);
        super.setType('P');
    }
    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {

        if (newY != this.getY()) {
            return false;
        }
        if (Math.abs(newX - this.getX()) > 1) { //can only move 1 block
            return false;
        }

        return isPathClear(newX, newY, chessTable);
    }

    private boolean isPathClear(int x, int y, ChessTable chessTable) {
        int direction = this.getColor().equals("white") ? 1 : -1;
        int nextX = x + direction;

        if (nextX < 0 || nextX > 7)
            return false;

        return chessTable.getPiece(nextX, y) == null;
    }

    @Override
    public String toString() {
        if(this.getColor().equals("white")){
            return "P";
        } else
            return "p";
    }
}