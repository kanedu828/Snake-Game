package kane.game.snake;

import java.util.ArrayList;

/**
 * This class represents the snake. Snake contains the head of the snake that the user controls.
 */
public class Snake {
    private ArrayList<Body> snake;

    /**
     * Initializes the snake with a head, which the starting index is at the center of the map.
     * @param width
     * @param height
     */
    public Snake(int width, int height){
        snake = new ArrayList<>();
        snake.add(new Body(height/2, width/2));
    }

    /**
     * Returns the first index of {@code snake}.
     * @return the {@code head} of {@code snake}.
     */
    public Body getHead(){
        return snake.get(0);
    }

    /**
     * Returns the {@code snake}
     * @return the {@code snake}
     */
    public ArrayList<Body> getSnake(){
        return snake;
    }
    /**
     * Returns the size of the snake.
     * @return size of the snake.
     */
    public int size(){
        return snake.size();
    }

    /**
     * Returns the tail of the snake.
     * @return The last index of {@code snake}.
     */
    public Body getTail(){
        return snake.get(snake.size()-1);
    }

    /**
     * Adds a body to the snake.
     */
    public void appendBody(){
        Body tail = getTail();
        //The bodies are added depending on which direction the tail is heading.
        if(tail.getDir()==Direction.UP){
            snake.add(new Body(tail.getRow(), tail.getCol()-1));
            getTail().setDir(tail.getDir());
        }
        if(tail.getDir()==Direction.DOWN){
            snake.add(new Body(tail.getRow(), tail.getCol()+1));
            getTail().setDir(tail.getDir());
        }
        if(tail.getDir()==Direction.RIGHT){
            snake.add(new Body(tail.getRow()+1, tail.getCol()));
            getTail().setDir(tail.getDir());
        }
        if(tail.getDir()==Direction.LEFT){
            snake.add(new Body(tail.getRow()-1, tail.getCol()));
            getTail().setDir(tail.getDir());
        }
    }

    /**
     * Returns whether or not the snake collided with itself.
     * @return True if it collided with itself, false otherwise.
     *
     */
    public boolean isCollision(){
        for(Body b: snake){
            if(getHead().getRow()==b.getRow()&&getHead().getCol()==b.getCol()&&b!=getHead()){
                return true;
            }
        }
        return false;
    }

    /**
     * Moves the snake along.
     */
    public void passIndex(){
        for(int i = size()-1; i>0; i--){
            snake.get(i).setRow(snake.get(i-1).getRow());
            snake.get(i).setCol(snake.get(i-1).getCol());
        }
    }

}
