package io.codeforall.bootcamp.filhosdamain;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

import java.util.LinkedList;

public class Player {

    private Rectangle playerImage;
    private int padding = 10;
    private int col;
    private int row;
    private Rectangle[][] arrayGrid;
    private Rectangle paint;
    private int cellSize = 30;


    private final int maxHeight = padding + padding;
    private final int minHeight = padding + (cellSize * cellSize);
    private final int maxWidth = padding + (cellSize * cellSize);
    private final int minWidth = padding + padding;


    public void setArrayGrid(Rectangle[][] arrayGrid) {
        this.arrayGrid = arrayGrid;
    }

    public Player(int col, int row) {
        this.col = col;
        this.row = row;
        this.playerImage = new Rectangle(padding, padding, cellSize, cellSize);
        this.playerImage.setColor(Color.GREEN);
        this.playerImage.fill();
    }

    public void moveRight() {
        if (this.col + this.playerImage.getWidth() < this.maxWidth) {
            this.playerImage.translate(cellSize, 0.0);
            this.col += cellSize;
        }
    }

    public void moveLeft() {
        if (this.col > this.minWidth) {
            this.playerImage.translate(-cellSize, 0.0);
            this.col -= cellSize;
        }
    }

    public void moveUp() {
        if (this.row > this.maxHeight) {
            this.playerImage.translate(0.0, -cellSize);
            this.row -= cellSize;
        }
    }

    public void moveDown() {
        if (this.row + this.playerImage.getHeight() < this.minHeight) {
            this.playerImage.translate(0.0, cellSize);
            this.row += cellSize;
        }
    }


    public void paint() {
        // Create a new Rectangle object for painting
        paint = new Rectangle(playerImage.getX(), playerImage.getY(), cellSize, cellSize);

        for (int row = 0; row < cellSize; row++) {
            for (int col = 0; col < cellSize; col++) {

                if (arrayGrid[col][row].getX() == playerImage.getX() && arrayGrid[col][row].getY() == playerImage.getY()) {
                    paint.setColor(Color.BLACK);

                    if (!arrayGrid[col][row].isFilled()) {
                        paint.fill();
                        arrayGrid[col][row].fill();

                    } else {
                        paint.setColor(Color.WHITE); // Set color to fill color
                        paint.fill();
                        arrayGrid[col][row].fill();

                        paint.setColor(Color.BLACK); // Set color to border color
                        paint.draw();
                    }

                    return;
                }
            }
        }
    }

}









