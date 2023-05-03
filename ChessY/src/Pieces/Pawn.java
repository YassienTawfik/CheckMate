/*
The Pawn class represents a pawn piece in a game of chess.
It extends the Piece class and inherits its properties and methods.
*/
package Pieces;

import Main.Board;

import java.awt.image.BufferedImage;

public class Pawn extends Piece {
    /**
     * Constructor for the Pawn class
     *
     * @param board   The Board on which the Pawn will be placed
     * @param column  The column index of the Pawn's position on the board
     * @param row     The row index of the Pawn's position on the board
     * @param isWhite A boolean representing whether the Pawn is white or black
     */
    public Pawn(Board board, int column, int row, boolean isWhite) {
        super(board);
        this.column = column;
        this.row = row;
        this.xPos = column * board.tileSize;
        this.yPos = row * board.tileSize;
        this.isWhite = isWhite;
        this.name = "Pawn";

        // The sprite for the pawn piece is retrieved from a larger image file
        // and scaled down to the size of a single tile on the board.
        this.sprite = sheet.getSubimage(pieceWidth * 5, isWhite ? 0 : pieceHeight, pieceWidth, pieceHeight).getScaledInstance(board.tileSize, board.tileSize, BufferedImage.SCALE_SMOOTH);
    }


    public boolean moveHitsPiece(int column, int row) {
        return board.getPiece(column, row) != null;
    }

    public boolean isValidMovement(int column, int row) {
        boolean pawnFront, pawnRightDiagonal, pawnLeftDiagonal;
        int columnMove, rowMove;
        if (isWhite) {
            columnMove = this.column - column;
            rowMove = this.row - row;
            pawnFront = moveHitsPiece(this.column, this.row - 1);
            pawnRightDiagonal = moveHitsPiece(this.column + 1, this.row - 1);
            pawnLeftDiagonal = moveHitsPiece(this.column - 1, this.row - 1);
            if (this.row == 6) {
                if (pawnFront && pawnRightDiagonal && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1 || columnMove == -1);
                } else if (pawnFront && pawnRightDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == -1);
                } else if (pawnFront && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1);
                } else if (pawnFront) {
                    return (rowMove == 1) && (columnMove == 0);
                } else if (pawnRightDiagonal && pawnLeftDiagonal) {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1))) || (rowMove == 1 && (columnMove == 1 || columnMove == -1));
                } else if (pawnRightDiagonal) {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1))) || (rowMove == 1 && (columnMove == -1));
                } else if (pawnLeftDiagonal) {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1))) || (rowMove == 1 && (columnMove == +1));
                } else {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1)));
                }
            } else {
                if (pawnFront && pawnRightDiagonal && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1 || columnMove == -1);
                } else if (pawnFront && pawnRightDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == -1);
                } else if (pawnFront && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1);
                } else if (pawnFront) {
                    return (rowMove == 1) && (columnMove == 0);
                } else if (pawnRightDiagonal && pawnLeftDiagonal) {
                    return (columnMove == 0 && rowMove == 1) || (rowMove == 1 && (columnMove == 1 || columnMove == -1));
                } else if (pawnRightDiagonal) {
                    return (columnMove == 0 && rowMove == 1) || (rowMove == 1 && (columnMove == -1));
                } else if (pawnLeftDiagonal) {
                    return (columnMove == 0 && rowMove == 1) || (rowMove == 1 && (columnMove == 1));
                } else {
                    return (columnMove == 0 && rowMove == 1);
                }
            }

        } else {
            columnMove = column - this.column;
            rowMove = row - this.row;
            pawnFront = moveHitsPiece(this.column, this.row + 1);
            pawnRightDiagonal = moveHitsPiece(this.column - 1, this.row + 1);
            pawnLeftDiagonal = moveHitsPiece(this.column + 1, this.row + 1);
            if (this.row == 1) {
                if (pawnFront && pawnRightDiagonal && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1 || columnMove == -1);
                } else if (pawnFront && pawnRightDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == -1);
                } else if (pawnFront && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1);
                } else if (pawnFront) {
                    return (rowMove == 1) && (columnMove == 0);
                } else if (pawnRightDiagonal && pawnLeftDiagonal) {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1))) || (rowMove == 1 && (columnMove == 1 || columnMove == -1));
                } else if (pawnRightDiagonal) {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1))) || (rowMove == 1 && (columnMove == -1));
                } else if (pawnLeftDiagonal) {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1))) || (rowMove == 1 && (columnMove == +1));
                } else {
                    return (columnMove == 0 && ((rowMove == 2) || (rowMove == 1)));
                }
            } else {
                if (pawnFront && pawnRightDiagonal && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1 || columnMove == -1);
                } else if (pawnFront && pawnRightDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == -1);
                } else if (pawnFront && pawnLeftDiagonal) {
                    return (rowMove == 1) && (columnMove == 0 || columnMove == 1);
                } else if (pawnFront) {
                    return (rowMove == 1) && (columnMove == 0);
                } else if (pawnRightDiagonal && pawnLeftDiagonal) {
                    return (columnMove == 0 && rowMove == 1) || (rowMove == 1 && (columnMove == 1 || columnMove == -1));
                } else if (pawnRightDiagonal) {
                    return (columnMove == 0 && rowMove == 1) || (rowMove == 1 && (columnMove == -1));
                } else if (pawnLeftDiagonal) {
                    return (columnMove == 0 && rowMove == 1) || (rowMove == 1 && (columnMove == 1));
                } else {
                    return (columnMove == 0 && rowMove == 1);
                }
            }
        }
    }
}
