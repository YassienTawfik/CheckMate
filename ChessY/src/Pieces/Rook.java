/*
The Rook class represents a pawn piece in a game of chess.
It extends the Piece class and inherits its properties and methods.
*/
package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Rook extends Piece {
    /**
     * Constructor for the Rook class
     *
     * @param board   The Board on which the Rook will be placed
     * @param column  The column index of the Rook's position on the board
     * @param row     The row index of the Rook's position on the board
     * @param isWhite A boolean representing whether the Rook is white or black
     */
    public Rook(Board board, int column, int row, boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.xPos = column * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Rook";

        this.sprite = sheet.getSubimage(pieceWidth * 4, isWhite ? 0 : pieceHeight, pieceWidth, pieceHeight).getScaledInstance(board.tileSize - 1, board.tileSize - 1, BufferedImage.SCALE_SMOOTH);
    }
}
