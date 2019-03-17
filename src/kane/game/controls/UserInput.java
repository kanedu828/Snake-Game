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

    /**
     * Passes in the head to reference for the direction.
     * @param head Head object to use to get the direction.
     */
    public UserInput(Body head){
        this.head = head;
    }

    /**
     * Controls of the game. Up, down, right, and left arrow keys are used for movement.
     * @param event the event that is being listened.
     */
    @Override
    public void handle(KeyEvent event) {
        if(event.getCode()==UP){
            head.setDir(Direction.UP);
        }
        if(event.getCode()==DOWN){
            head.setDir(Direction.DOWN);
        }
        if(event.getCode()==RIGHT){
            head.setDir(Direction.RIGHT);
        }
        if(event.getCode()==LEFT){
            head.setDir(Direction.LEFT);
        }
    }
}
