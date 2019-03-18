package kane.game.controls;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;
import kane.game.map.Map;
import kane.game.snake.Body;
import kane.game.snake.Direction;
import kane.game.snake.Snake;

import java.util.Timer;
import java.util.TimerTask;

import static javafx.scene.input.KeyCode.*;

/**
 * This class represents the controls for a game of snake.
 */
public class UserInput implements EventHandler<KeyEvent> {
    private Body head;
    private Map map;

    /**
     * Passes in the head to reference for the direction.
     * @param head Head object to use to get the direction.
     */
    public UserInput(Map map, Body head){
        this.head = head;
        this.map = map;
    }

    /**
     * Controls of the game. Up, down, right, and left arrow keys are used for movement.
     * @param event the event that is being listened.
     */
    @Override
    public void handle(KeyEvent event) {
        //Each input is checked if it inputs the direct opposite direction. For example, if going up, you can not
        //switch direction to down. (Unless size of snake is 1).
        if(event.getCode()==UP){
            if(map.getUser().size()>1&&head.getDir()==Direction.DOWN){

            }else {
                head.setDir(Direction.UP);
            }
            }
        if(event.getCode()==DOWN){
            if(map.getUser().size()>1&&head.getDir()==Direction.UP){

            }else {
                head.setDir(Direction.DOWN);
            }
        }
        if(event.getCode()==RIGHT){
            if(map.getUser().size()>1&&head.getDir()==Direction.LEFT){

            }else {
                head.setDir(Direction.RIGHT);
            }
        }
        if(event.getCode()==LEFT){
            if(map.getUser().size()>1&&head.getDir()==Direction.RIGHT){

            }else {
                head.setDir(Direction.LEFT);
            }
        }
    }
}
