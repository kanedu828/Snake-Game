package kane.game.snake;

/**
 * This class represents the snake. Snake contains the head of the snake that the user controls.
 */
public class Snake {
    private Body head;

    /**
     * Initializes the snake with a head, which the starting index is at the center of the map.
     * @param width
     * @param height
     */
    public Snake(int width, int height){
        head = new Body(height/2, width/2);
    }

    /**
     * Returns the {@code head} of the snake.
     * @return the {@code head} of the snake.
     */
    public Body getHead(){
        return head;
    }
}
