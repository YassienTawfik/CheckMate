/*
The Board class defines the chess board with a set number of rows and columns.
The class extends JPanel and overrides the paintComponent method to draw the board and the pieces on it.
It also contains methods to add and remove pieces, capture opponent pieces, check the validity of a move and get a piece object at a given location on the board.
 */
package Main;

// import Main.Input;
// import Main.Move;
import Pieces.*;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

// Board class definition
public class Board extends JPanel {
    public int tileSize = 80; // size of each tile in pixels
    public Piece selectedPiece; // Piece selected by the mouse
    int rows = 8; // number of rows on the chess board
    int columns = 8; // number of columns on the chess board
    int circleGreenRadius = 30;
    ArrayList<Piece> pieceList = new ArrayList<>(); // Declare Resizeable array to hold all the pieces present on the
                                                    // board.

    // Define two colors (Dark & Light) for the tiles
    Color color1 = new Color(86, 86, 86, 255);
    Color color2 = new Color(225, 225, 225, 255);

    Input input = new Input(this);// Define object from Class Input

    // Board constructor
    public Board() {
        // Set the size of the board panel
        this.setPreferredSize(new Dimension(columns * tileSize, rows * tileSize));

        // Adds the specified mouse events for the game
        this.addMouseListener(input);
        this.addMouseMotionListener(input);

        addPiece();// Call the method for adding pieces on the board
    }

    public Piece getPiece(int column, int row) {
        // Method to return a piece held in a specific tile

        for (Piece piece : pieceList) {
            if ((piece.column == column) && (piece.row == row)) {
                return piece;
            }
        }
        return null;
    }

    public void makeMove(Move move) {
        // Method to move a piece
        if (move.piece != null) {
            move.piece.column = move.newColumn;
            move.piece.row = move.newRow;
            move.piece.xPos = move.newColumn * tileSize;
            move.piece.yPos = move.newRow * tileSize;

            capture(move);// eat the piece placed in selected tile
        }
    }

    public void capture(Move move) {
        // Method to remove the eaten piece from the game (remove the piece from the
        // resizeable array)
        pieceList.remove(move.capture);
    }

    public boolean isValidMove(Move move) {
        // Method to check the validity of move of a piece
        if (sameTeam(move.piece, move.capture)) {
            return false;
        } else
            return move.piece.isValidMovement(move.newColumn, move.newRow);
    }

    public boolean sameTeam(Piece p1, Piece p2) {
        // Method to check if two pieces are on same team or not
        if (p1 == null || p2 == null) {
            // Make sure there is a piece on the specified tile
            return false;
        }
        return p1.isWhite == p2.isWhite;
    }

    // Adding Pieces to the Resizeable array
    public void addPiece() {
        // Black Pawns
        for (int c = 0; c < columns; c++) {
            pieceList.add(new Pawn(this, c, 1, false));
        }
        // White Pawns
        for (int c = 0; c < columns; c++) {
            pieceList.add(new Pawn(this, c, 6, true));
        }
        // Black King
        pieceList.add(new King(this, 4, 0, false));
        // White King
        pieceList.add(new King(this, 4, 7, true));
        // Black Queen
        pieceList.add(new Queen(this, 3, 0, false));
        // White Queen
        pieceList.add(new Queen(this, 3, 7, true));
        // Black Bishop
        pieceList.add(new Bishop(this, 5, 0, false));
        pieceList.add(new Bishop(this, 2, 0, false));
        // White Bishop
        pieceList.add(new Bishop(this, 5, 7, true));
        pieceList.add(new Bishop(this, 2, 7, true));
        // Black Knights
        pieceList.add(new Knight(this, 1, 0, false));
        pieceList.add(new Knight(this, 6, 0, false));
        // White Knights
        pieceList.add(new Knight(this, 1, 7, true));
        pieceList.add(new Knight(this, 6, 7, true));
        // Black Rook
        pieceList.add(new Rook(this, 0, 0, false));
        pieceList.add(new Rook(this, 7, 0, false));
        // White Rook
        pieceList.add(new Rook(this, 0, 7, true));
        pieceList.add(new Rook(this, 7, 7, true));

    }

    // Override the paintComponent method to draw the game
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                // Set the color of the current square based on its position on the board
                g2d.setColor((c + r) % 2 == 0 ? color2 : color1);
                // Fill the current square with the selected color
                g2d.fillRect(c * tileSize, r * tileSize, tileSize, tileSize);
            }
        }

        // Color tiles of valid moves of a selected piece with green
        if (this.selectedPiece != null)
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < columns; c++)
                    if (isValidMove(new Move(this, selectedPiece, c, r))) {
                        if (getPiece(c, r) == null) {
                            // Set the fill color to green and fill the round rectangle
                            g2d.setColor(new Color(20, 150, 0, 255));
                            g2d.fillRoundRect(c * tileSize + 25, r * tileSize + 25, circleGreenRadius,
                                    circleGreenRadius, circleGreenRadius, circleGreenRadius);

                            // Set the stroke color to black and draw the round rectangle with a border
                            g2d.setStroke(new BasicStroke(1));
                            g2d.setColor(Color.BLACK);
                            g2d.drawRoundRect(c * tileSize + 25, r * tileSize + 25, circleGreenRadius,
                                    circleGreenRadius, circleGreenRadius, circleGreenRadius);
                        } else {
                            g2d.setColor(Color.BLACK);
                            g2d.setStroke(new BasicStroke(5));
                            g2d.drawRect(c * tileSize, r * tileSize, tileSize, tileSize);
                            g2d.setColor(new Color(126, 0, 0));
                            g2d.fillRect(c * tileSize + 2, r * tileSize + 2, tileSize - 4, tileSize - 4);

                        }
                    }

        // Draw each piece on the Board
        for (Piece piece : pieceList) {
            piece.paint(g2d);
        }
    }
}
