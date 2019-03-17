package kane.game.controls;

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
        if(head.getDir()== Direction.UP){
            head.setCol(head.getCol()-1);
            map.updateMap();
        }
        if(head.getDir()== Direction.DOWN){
            head.setCol(head.getCol()+1);
            map.updateMap();
        }
        if(head.getDir()== Direction.RIGHT){
            head.setRow(head.getRow()+1);
            map.updateMap();
        }
        if(head.getDir()== Direction.LEFT){
            head.setRow(head.getRow()-1);
            map.updateMap();
        }
    }
}
