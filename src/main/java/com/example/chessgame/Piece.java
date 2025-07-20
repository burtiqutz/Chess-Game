package com.example.chessgame;

public abstract class Piece {
    private String color;
    private int x, y;
    private char type;
    public Piece() {
        this.color = "none";
        this.x = 0;
        this.y = 0;
        this.type = '?';
    }
    public Piece(String color, int x, int y) {
        this.color = color;
        this.x = x;
        this.y = y;
    }

    public abstract boolean isValidMove(ChessTable chessTable, int newX, int newY);

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
    }
    public char getType() {
        return type;
    }
    public void setType(char type) {
        this.type = type;
    }
    public String toString(){
        return "_";
    }
}
