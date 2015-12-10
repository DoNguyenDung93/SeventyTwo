package seventytwo.seventytwo.Logic;

/**
 * Created by dongu on 10/12/2015.
 * This class will handle the creation and manipulation of the game board, which consists of 72 cells.
 * Each cell will fit one token.
 */
public class Board {

    private static Board singleBoard = new Board();

    // Attributes
    private int[] row = {1, 2, 3, 4, 5, 6};
    private int[] column = {1, 2, 3, 4, 5, 6};

    // Constructor
    public Board() {
    }

    // Accessor
    public static Board getInstance() {
        if (singleBoard == null) {
            singleBoard = new Board();
        }
        return singleBoard;
    }
}
