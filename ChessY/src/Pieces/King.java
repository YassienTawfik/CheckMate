/**
 * The King class represents a king chess piece.
 * It extends the Piece class and inherits its attributes and methods.
 */

package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;


public class King extends Piece {
    /**
     * Constructor for the King class
     *
     * @param board   The Board on which the King will be placed
     * @param column  The column index of the King's position on the board
     * @param row     The row index of the King's position on the board
     * @param isWhite A boolean representing whether the King is white or black
     */
    public King(Board board, int column, int row, boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.xPos = column * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "King";

        // get the sprite for the king piece from the sheet and scale it to fit the tile size
        this.sprite = sheet.getSubimage(0, isWhite ? 0 : pieceHeight, pieceWidth, pieceHeight).getScaledInstance(board.tileSize - 1, board.tileSize - 1, BufferedImage.SCALE_SMOOTH);
    }
}
