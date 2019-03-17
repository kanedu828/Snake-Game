package kane.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import kane.game.controls.Movement;
import kane.game.controls.UserInput;
import kane.game.map.Map;

import java.util.Timer;

/**
 * This is the driver class for a game of snake.
 *
 * Author: Kane Du
 * Last Edited: 3/17/19
 */
public class Driver extends Application {
    private static final int SNAKE_SPEED = 200;

    /**
     * Launches a JavaFX application.
     * @param args Command line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Creates the snake game window.
     * @param primaryStage the stage
     */
    @Override
    public void start(Stage primaryStage) {
        Stage window = primaryStage;
        window.setTitle("Snake");

        //The layout that will be compared to an ImageView array.
        GridPane root = new GridPane();

        //Initializing map for snake.
        Map map = new Map(root, 21, 21);

        UserInput userInput = new UserInput(map.getUser().getHead());

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(userInput);

        //Timer allows the snake to continue to move without a key press.
        Timer timer = new Timer();
        Movement movement = new Movement(map);
        timer.schedule(movement, 0, SNAKE_SPEED);

        window.setScene(scene);
        window.show();

    }
}
