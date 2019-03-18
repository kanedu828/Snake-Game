package kane.game.snake;

import kane.game.map.Block;

/**
 * This class is a linked list of the bodies of a snake. The body index should be right before the previous node,
 * depending on the direction.
 */
public class Body extends Block {
    private Direction dir;
    private Body next;

    /**
     * Initializes the body at the following index.
     * @param row Row index of the body.
     * @param col Col index of the body.
     */
    public Body(int row, int col){
        super(row, col);
    }

    /**
     * Initializes the body at the following index sets the next body.
     * @param row Row index of the body.
     * @param col Col index of the body.
     * @param next Next body node of the snake.
     */
    public Body(int row, int col, Body next){
        this(row, col);
        this.next = next;
    }

    /**
     * Returns the next body node of the snake.
     * @return the next body node of the snake.
     */
    public Body getNext(){
        return next;
    }

    /**
     * Sets the next body node of the snake.
     * @param next the next body node of the snake.
     */
    public void setNext(Body next){
        this.next = next;
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

    /**
     * Adjusts the index of the next body node after movement.
     */
    public void adjustNextIndex(){
        //Prevent null out of bound errors.
        if(next!=null){
            //For each direction, the next node moves based off of that direction. The next node's direction is based
            //on detectVelocity(Body body1, Body body2).
            if(dir==Direction.UP){
                Body temp = new Body(next.getRow(),next.getCol());
                next.setRow(getRow());
                next.setCol(getCol()+1);
                next.setDir(detectVelocity(temp, next));
            }
            if(dir==Direction.DOWN){
                Body temp = new Body(next.getRow(),next.getCol());
                next.setRow(getRow());
                next.setCol(getCol()-1);
                next.setDir(detectVelocity(temp, next));
            }
            if(dir==Direction.RIGHT){
                Body temp = new Body(next.getRow(),next.getCol());
                next.setRow(getRow()-1);
                next.setCol(getCol());
                next.setDir(detectVelocity(temp, next));
            }
            if(dir==Direction.LEFT){
                Body temp = new Body(next.getRow(),next.getCol());
                next.setRow(getRow()+1);
                next.setCol(getCol());
                next.setDir(detectVelocity(temp, next));
            }
        }
    }

    /**
     * Detects the change in distance for a certain body node. This is a helper method for adjustNextIndex().
     * @param body1 Initial index of the node.
     * @param body2 Final index of the node.
     * @return the direction vector of the velocity.
     */
    private Direction detectVelocity(Body body1, Body body2){
        if(body2.getCol()==body1.getCol()-1) {
            return Direction.UP;
        }else if(body2.getCol()==body1.getCol()+1){
            return Direction.DOWN;
        }else if(body2.getRow()==body1.getRow()+1){
            return Direction.RIGHT;
        }else{
            return Direction.LEFT;
        }
    }

}
