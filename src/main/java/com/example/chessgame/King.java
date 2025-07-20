package com.example.chessgame;

public class King extends Piece {

    public King(String color, int x, int y) {
        super(color, x, y);
        super.setType('K');
    }

    @Override
    public boolean isValidMove(ChessTable chessTable, int newX, int newY) {
        int dx = Math.abs(newX - this.getX());
        int dy = Math.abs(newY - this.getY());

        if (newX < 0 || newX > 7 || newY < 0 || newY > 7)
            return false;

        // King moves only one square in any direction
        if (dx <= 1 && dy <= 1 && (dx + dy) > 0) {
            Piece dest = chessTable.getPiece(newX, newY);
            // Destination must be empty or occupied by opponent
            if (dest == null || !dest.getColor().equals(this.getColor())) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return this.getColor().equals("white") ? "K" : "k";
    }
}
