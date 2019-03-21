package kane.game.snake;

import kane.game.map.Block;

/**
 * This class is a linked list of the bodies of a snake. The body index should be right before the previous node,
 * depending on the direction.
 */
public class Body extends Block {
    private Direction dir;
    /**
     * Initializes the body at the following index.
     * @param row Row index of the body.
     * @param col Col index of the body.
     */
    public Body(int row, int col){
        super(row, col);
    }

    /**
     * Returns the direction the snake is heading.
     * @return the direction the snake is heading.
     */
    public Direction getDir(){
        return dir;
    }

    /**
     * Sets the direction the snake is heading.
     * @param dir the direction the snake is heading.
     */
    public void setDir(Direction dir){
        this.dir = dir;
    }

}
