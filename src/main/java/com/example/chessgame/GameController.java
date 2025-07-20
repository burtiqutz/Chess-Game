package com.example.chessgame;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class GameController {
    @FXML
    private GridPane board;

    private Game game;
    private int[] selected = null;
    @FXML
    private Label topLabel;
    @FXML
    private Label bottomLabel;

    @FXML
    public void initialize() {
        game = new Game();
        VBox.setVgrow(board, Priority.NEVER);
        board.setMaxSize(400, 400);
        drawBoard();
    }

    private void drawBoard() {
        board.getChildren().clear();
        updateTurnText(game.getCurrentPlayer());
        if(game.isInCheck()){
            updateStatusText(game.getCurrentPlayer() + "is in check");
        }
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                Button cell = new Button();
                cell.setPrefSize(60, 60);

                Piece p = game.getChessTable().getPiece(x, y);
                if (p != null) {
                    cell.setText(p.toString());
                } else {
                    cell.setText("");
                }

                int finalX = x;
                int finalY = y;
                cell.setOnAction(e -> handleCellClick(finalX, finalY));

                if ((x + y) % 2 == 0) {
                    cell.setStyle("-fx-background-color: #e5e5ce;");
                } else {
                    cell.setStyle("-fx-background-color: #b47355;");
                }

                board.add(cell, y, x);  // y = col, x = row
            }
        }
    }

    private void handleCellClick(int x, int y) {

        if (selected == null) {
            selected = new int[]{x, y};
            System.out.println("Current player: " + game.getCurrentPlayer());
            System.out.println("Selected: " + x + "," + y);
        } else {
            game.doTurn(selected[0], selected[1], x, y);
            selected = null;
            drawBoard();
        }
    }

    public void updateTurnText(String currentPlayer) {
        topLabel.setText("Current turn: " + currentPlayer);
    }

    public void updateStatusText(String message) {
        bottomLabel.setText(message);
    }
}
