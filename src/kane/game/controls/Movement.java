package kane.game.controls;

import javafx.scene.control.Label;
import kane.game.map.Map;
import kane.game.snake.Body;
import kane.game.snake.Direction;

import java.util.TimerTask;

/**
 * This class represents how the snake visually moves.
 */
public class Movement extends TimerTask {
    private Map map;
    private Body head;

    /**
     * Passes in the map to be referenced.
     * @param map map that is to be referenced.
     */
    public Movement(Map map){
        this.map =  map;
        this.head = map.getUser().getHead();
    }

    /**
     * Snake moves based off of the direction it is facing. The direction is changed with {@code UserInput} controls.
     */
    @Override
    public void run() {
        //Checks if the snake is out of bounds of the map. You lose if so.
        if(head.getRow()<0||head.getRow()>=map.getWidth()||head.getCol()<0||head.getCol()>=map.getHeight()){
            System.exit(0);
        }
        //Checks if the snake collides with itself. You lose if so.
        if(map.getUser().isCollision()){
            System.exit(0);
        }
        //When the snake eats an apple. Snake grows in size if so.
        if(map.getApple().getRow()==head.getRow()&&map.getApple().getCol()==head.getCol()) {
            map.getUser().appendBody();
            map.getApple().placeApple(map.getWidth(), map.getHeight());
            map.updateMap();
        }
        //Moves snake up.
        if(head.getDir()== Direction.UP){
            head.setCol(head.getCol()-1);
            map.updateMap();
        }
        //Moves snake down.
        if(head.getDir()== Direction.DOWN){
            head.setCol(head.getCol()+1);
            map.updateMap();
        }
        //Moves snake to the right.
        if(head.getDir()== Direction.RIGHT){
            head.setRow(head.getRow()+1);
            map.updateMap();
        }
        //Moves snake to the left
        if(head.getDir()== Direction.LEFT){
            head.setRow(head.getRow()-1);
            map.updateMap();
        }
        Body temp = head;
        //Adjusts each snake body so it directly follows the preceding body.
        if(map.getUser().size()>1){
            for(int i = 0; i<map.getUser().size(); i++){
                temp.adjustNextIndex();
                temp = temp.getNext();
            }
        }
        //Updates the map after adjusting the index.
        map.updateMap();

    }
}
