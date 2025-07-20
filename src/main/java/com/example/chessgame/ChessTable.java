package com.example.chessgame;

import java.util.Objects;

public class ChessTable {
    private Piece[][] chessTable;

    public ChessTable() {
        //init board
        chessTable = new Piece[8][8];
        for (int i = 0; i < 8; i++)
            for (int j = 0; j < 8; j++) {
                switch (i) {
                    //spaghetti ass code
                    case 0:
                        if (j == 0 || j == 7) {
                            chessTable[i][j] = new Rook("white", i, j);
                        }
                        if (j == 1 || j == 6) {
                            chessTable[i][j] = new Knight("white", i, j);
                        }
                        if (j == 2 || j == 5) {
                            chessTable[i][j] = new Bishop("white", i, j);
                        }
                        if (j == 3) {
                            chessTable[i][j] = new King("white", i, j);
                        }
                        if (j == 4) {
                            chessTable[i][j] = new Queen("white", i, j);
                        }
                        break;
                    case 1:
                        chessTable[i][j] = new Pawn("white", i, j);
                        break;
                    case 6:
                        chessTable[i][j] = new Pawn("black", i, j);
                        break;
                    case 7:
                        if (j == 0 || j == 7) {
                            chessTable[i][j] = new Rook("black", i, j);
                        }
                        if (j == 1 || j == 6) {
                            chessTable[i][j] = new Knight("black", i, j);
                        }
                        if (j == 2 || j == 5) {
                            chessTable[i][j] = new Bishop("black", i, j);
                        }
                        if (j == 3) {
                            chessTable[i][j] = new Queen("black", i, j);
                        }
                        if (j == 4) {
                            chessTable[i][j] = new King("black", i, j);
                        }
                        break;
                    default:
                        chessTable[i][j] = null;
                        break;
                }
            }
    }

    public void doMove(int startX, int startY, int endX, int endY) {
        Piece piece = chessTable[startX][startY];
        if(piece.isValidMove(this, endX, endY)){
            chessTable[endX][endY] = piece;
            piece.setX(endX);
            piece.setY(endY);
            chessTable[startX][startY] = null;
        }
        else {
            throw new IllegalArgumentException("Invalid move");
        }
    }

    public Piece getPiece(int x, int y){
        return chessTable[x][y];
    }
    // Should swap to FEN
    public void showTable() {
        System.out.println("0 1 2 3 4 5 6 7  ");
        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                if(chessTable[i][j] != null) {
                    System.out.print(chessTable[i][j] + " ");
                }
                else {
                    System.out.print("  ");
                }
            }
            System.out.print(" " + i);
            System.out.println();
        }
        System.out.println();
    }
}