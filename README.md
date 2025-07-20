# Java Chess Game

A simple chess game implemented in Java with both console and GUI interfaces. It supports basic chess rules including piece movements, turn-taking, and check detection.
It is meant as a simple fun project for me to practice. Feel free to use as you please.

## Features
- Standard chessboard with all pieces (Pawn, Rook, Knight, Bishop, Queen, King)
- Validates moves according to chess rules for each piece
- Alternates turns between white and black players
- Detects when a king is in check
- Console-based mode for quick testing
- GUI mode built with JavaFX for interactive play

## Modes
- GUI: Run the JavaFX application via the `GameController` class and corresponding FXML file.
- Console: Run the `ConsoleTest` class which starts the game in console mode.

## Project structure
- `Piece` (abstract class): Base class for all pieces
- Specific pieces: `Pawn`, `Rook`, `Knight`, `Bishop`, `Queen`, `King`
- `ChessTable`: Represents the 8x8 board and piece positions
- `Game`: Manages game logic, turn order, and check detection
- `GameController`: JavaFX controller for GUI interactions
- `ConsoleTest`: Entry point for console version

## Limitations
- Special moves like castling, en passant, and pawn promotion not implemented
- Checkmate and stalemate detection missing
- Improved GUI design and input validation
- I also am not good at chess nor play it on the regular :)
