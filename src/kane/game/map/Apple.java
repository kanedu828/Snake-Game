package kane.game.map;

import java.util.Random;

/**
 * This class represents a block that represents an apple.
 */
public class Apple extends Block {
    /**
     * Initializes the apple at the specified location.
     * @param row Row index of where apple will be placed.
     * @param col Col index of where apple will be placed.
     */
    public Apple(int row, int col) {
        super(row, col);
    }

    /**
     * Randomly places the apple at an index.
     * @param height Height of the map.
     * @param width Width of the map.
     */
    public void placeApple(int height, int width){
        Random rand = new Random();
        int appleRow = rand.nextInt(height);
        int appleCol = rand.nextInt(width);
        setRow(appleRow);
        setCol(appleCol);
    }
}
