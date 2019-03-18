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

    /**
     * Returns the size of the snake.
     * @return size of the snake.
     */
    public int size(){
        int count = 0;
        Body temp = head;
        while(temp!=null){
            temp = temp.getNext();
            count++;
        }
        return count;
    }

    /**
     * Returns the tail of the snake. More formally, it returns the last node of {@code head}.
     * @return The last node of {@code head}.
     */
    public Body getTail(){
        Body temp = head;
        for(int i = 1; i<size(); i++){
            temp = temp.getNext();
        }
        return temp;
    }

    /**
     * Adds a body to the snake.
     */
    public void appendBody(){
        Body tail = getTail();
        //The bodies are added depending on which direction the tail is heading.
        if(tail.getDir()==Direction.UP){
            tail.setNext(new Body(tail.getRow(), tail.getCol()-1));
            tail.getNext().setDir(tail.getDir());
        }
        if(tail.getDir()==Direction.DOWN){
            tail.setNext(new Body(tail.getRow(), tail.getCol()+1));
            tail.getNext().setDir(tail.getDir());
        }
        if(tail.getDir()==Direction.RIGHT){
            tail.setNext(new Body(tail.getRow()+1, tail.getCol()));
            tail.getNext().setDir(tail.getDir());
        }
        if(tail.getDir()==Direction.LEFT){
            tail.setNext(new Body(tail.getRow()-1, tail.getCol()));
            tail.getNext().setDir(tail.getDir());
        }
    }

    /**
     * Returns whether or not the snake collided with itself.
     * @return True if it collided with itself, false otherwise.
     */
    public boolean isCollision(){
        Body temp = head.getNext();
        for(int i = 1; i<size(); i++){
            if(head.getRow()==temp.getRow()&&head.getCol()==temp.getCol()){
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

}
