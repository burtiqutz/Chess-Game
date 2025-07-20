package com.example.chessgame;

import java.util.Objects;
import java.util.Scanner;
//*
public class Game {
    private ChessTable chessTable;
    private String currentPlayer;
    private boolean isCheck;

    public Game(){
        chessTable = new ChessTable();
        currentPlayer = "white";
        isCheck = false;
        this.chessTable.showTable();
    }

    public void startGame(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            System.out.println("Player: " + currentPlayer);
            System.out.print("Please give move input (StX, StY, EndX, EndY), or -1 to quit: ");
            try {
                int startX = scanner.nextInt();
                if (startX == -1) break;
                int startY = scanner.nextInt();
                int endX = scanner.nextInt();
                int endY = scanner.nextInt();
                try{
                this.doTurn(startX, startY, endX, endY);
                }
                catch(Exception e){
                    System.out.println("Invalid move logic" + e.getMessage());
                }
                //  Check for check :)
                try {
                    if (isKingInCheck(currentPlayer, chessTable)) {
                        System.out.println("King in check for player " + currentPlayer);
                        isCheck = true;
                    } else {
                        isCheck = false;
                    }
                }catch (Exception e){
                    System.out.println("Failed @isKingInCheck" + e.getMessage());
                }
            }catch (Exception e){
                System.out.println("Invalid input. Try again.");
                scanner.nextLine();
            }

        }
    }

    private boolean isKingInCheck(String currentPlayer, ChessTable chessTable) {
        System.out.println("checking check for player " + currentPlayer);
        int kingX = -1, kingY = -1;
        char kingChar = (currentPlayer.equals("white")) ? 'K' : 'k';
        //  Find king
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = chessTable.getPiece(x, y);
                if (piece != null && Objects.equals(piece.getColor(), currentPlayer) && piece.toString().charAt(0) == kingChar) {
                    kingX = x;
                    kingY = y;
                    break;
                }
            }
        }
        //  Check for possible attacks on king
        System.out.println("checking possible attacks...");
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Piece piece = chessTable.getPiece(x, y);
                if (piece != null && !piece.getColor().equals(currentPlayer)) {
                    if (piece.isValidMove(chessTable, kingX, kingY)) {
                        System.out.println("found possible attacks");
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void doTurn(int startX, int startY, int endX, int endY){
        Piece piece = chessTable.getPiece(startX, startY);
        if(piece != null && Objects.equals(piece.getColor(), currentPlayer)){
            System.out.println("Current piece selected: " + piece.getColor() + " " + piece.getType());
            try{
                chessTable.doMove(startX, startY, endX, endY);
                switchTurn();
                this.chessTable.showTable();
            }catch(IllegalArgumentException e){
                System.out.println("Invalid move - wrong coordinates!");
            }
        } else{
            System.out.println("INVALID MOVE - null piece or wrong color selected");
        }
    }

    public void switchTurn(){
        System.out.println("Move made by: " + currentPlayer);
        currentPlayer = currentPlayer.equals("white") ? "black" : "white";
        System.out.println("Next player: " + currentPlayer);
    }

    public boolean isInCheck(){
        return isCheck;
    }

    public ChessTable getChessTable(){
        return chessTable;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }
}
