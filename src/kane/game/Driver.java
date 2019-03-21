package kane.game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
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
    private static final int SNAKE_SPEED = 100;

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

        VBox root = new VBox();
        Label score = new Label("hello");


        //The layout that will be compared to an ImageView array.
        GridPane grid = new GridPane();

        //Initializing map for snake.
        Map map = new Map(grid, 21, 21);

        root.getChildren().addAll(score,grid);
        root.setVgrow(grid, Priority.ALWAYS);

        UserInput userInput = new UserInput(map, map.getUser().getHead());

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
