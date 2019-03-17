package kane.game.map;

/**
 * This class represents any block that would be in a snake game.
 */
public class Block {
    private int row;
    private int col;

    /**
     * Initializes the {@code row} and {@code col} of the block.
     * @param row row index of the block
     * @param col column index of the block
     */
    public Block(int row, int col){
        this.row = row;
        this.col = col;
    }

    /**
     * Returns the {@code row} index of the block.
     * @return Returns the {@code row} index of the block.
     */
    public int getRow(){
        return row;
    }

    /**
     * Sets the {@code row} index of the block.
     * @param row {@code row} index.
     */
    public void setRow(int row){
        this.row = row;
    }
    /**
     * Returns the {@code col} index of the block.
     * @return Returns the {@code col} index of the block.
     */
    public int getCol(){
        return col;
    }
    /**
     * Sets the {@code col} index of the block.
     * @param col {@code col} index.
     */
    public void setCol(int col){
        this.col = col;
    }
}
