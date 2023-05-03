package Pieces;

import Main.Board;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

// Piece class definition
public class Piece {

    public int column, row;
    public int xPos, yPos;
    public boolean isWhite;
    public String name;
    public int value;

    BufferedImage sheet;
    // Initialize the sprite sheet of the pieces
    Image sprite;
    Board board;

    {
        try {
            sheet = ImageIO.read(ClassLoader.getSystemResourceAsStream("pieces1.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Dimensions of each piece on the sprite sheet
    protected int pieceWidth = sheet.getWidth() / 6;
    protected int pieceHeight = sheet.getHeight() / 2;

    // Constructor to initialize the board object
    public Piece(Board board) {
        this.board = board;
    }


    // Method to draw the piece on the board
    public void paint(Graphics2D g2d) {
        g2d.drawImage(sprite, xPos, yPos, null);
    }

    public boolean isValidMovement(int column, int row) {
        return true;
    }

    public boolean moveHitsPiece(int column, int row) {
        return false;
    }
}
