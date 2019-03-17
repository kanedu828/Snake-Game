package kane.game.map;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import kane.game.snake.Snake;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Random;

/**
 * The class represents the game map of snake. The map includes properties such as {@code width}, {@code height},
 * {@code user}, and {@code apple}. It also holds the visual aspects of the game.
 */
public class Map {
    private ImageView[][] map;
    private int width;
    private int height;
    private Snake user;
    private Apple apple;
    private static Image whiteblock;
    private static Image snakeblock;
    private static Image appleblock;

    /**
     * This constructor initializes the map with a certain width and height. It take's in a GridPane argument, and
     * each index of this GridPane is set to be a background block ({@code whiteblock}). Additionally, the head of a
     * snake block is placed at the center, and an {@code apple} block is randomly placed on the map.
     * @param root
     * @param width
     * @param height
     */
    public Map(GridPane root, int width, int height){
        //Initializing whiteblock to a simple white square, snakeblock to be a simple red square,
        //and appleblock to be a red square.
        try {
            whiteblock = new Image(new FileInputStream("resources/whitesquare.jpg"));
            snakeblock = new Image(new FileInputStream("resources/blacksquare.png"));
            appleblock = new Image(new FileInputStream("resources/redsquare.jpg"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        user = new Snake(width, height);
        //Apple placed at a random index.
        apple = new Apple(0,0);
        apple.placeApple(width,height);

        this.width = width;
        this.height = height;

        map = new ImageView[width][height];
        //Sets each GirdPane block to the corresponding 2d ImageView Array, map.
        for(int row = 0; row<width; row++){
            for(int col = 0; col<height; col++){
                //Initializes a new ImageView for each index.
                map[row][col] = new ImageView(whiteblock);
                //Sets the apple block on the GridPane. Overrides the background block.
                if(row==apple.getRow()&&col==apple.getCol()){
                    map[row][col].setImage(appleblock);
                }
                //Sets the head of the snake on the GridPane. Overrides the background block.
                if(row==user.getHead().getRow()&&col==user.getHead().getCol()){
                    map[row][col].setImage(snakeblock);
                }
                //Makes sure the dimensions of each index in GridPane is reasonable. 50x50 pixels
                map[row][col].setFitHeight(50);
                map[row][col].setFitWidth(50);
                //Adds each ImageView to the GridPane
                root.add(map[row][col], row, col);
            }
        }
    }

    /**
     * Returns the user snake.
     * @return {@code user}. The Snake object for this class.
     */
    public Snake getUser(){
        return user;
    }

    /**
     * Returns {@code apple}
     * @return The Apple object for this class.
     */
    public Apple getApple(){
        return apple;
    }

    /**
     * Returns the {@code width} of the map.
     * @return  {@code width} of the map.
     */
    public int getWidth(){
        return width;
    }
    /**
     * Returns the {@code height} of the map.
     * @return  {@code height} of the map.
     */
    public int getHeight(){
        return height;
    }

    /**
     * Updates the map by resetting each ImageView index in the array {@code map}. Updates visuals. This method should
     * be used after any change to a block.
     */
    public void updateMap(){
        for(int row = 0; row<width; row++){
            for(int col = 0; col<height; col++){
                //setImage instead of initializing is used for better memory usage.
                map[row][col].setImage(whiteblock);
                //Sets the apple block on the GridPane. Overrides the background block.
                if(row==apple.getRow()&&col==apple.getCol()){
                    map[row][col].setImage(appleblock);
                }
                //Sets the head of the snake on the GridPane. Overrides the background block.
                if(row==user.getHead().getRow()&&col==user.getHead().getCol()){
                    map[row][col].setImage(snakeblock);
                }
                //Makes sure the dimensions of each index in GridPane is reasonable. 50x50 pixels
                map[row][col].setFitHeight(50);
                map[row][col].setFitWidth(50);
                //Adds each ImageView to the GridPane
            }
        }
    }
}
