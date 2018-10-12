package fall2018.csc2017.slidingtiles;

import android.support.annotation.NonNull;

import java.util.Observable;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * The sliding tiles board.
 */

public class Board extends Observable implements Iterable<Tile>, Serializable {

    /**
     * The number of rows.
     */
    final static int NUM_ROWS = 4;

    /**
     * The number of rows.=
     */
    final static int NUM_COLS = 4;

    /**
     * The tiles on the board in row-major order.
     */
    private Tile[][] tiles = new Tile[NUM_ROWS][NUM_COLS];

    /**
     * A new board of tiles in row-major order.
     * Precondition: len(tiles) == NUM_ROWS * NUM_COLS
     *
     * @param tiles the tiles for the board
     */
    Board(List<Tile> tiles) {
        Iterator<Tile> iter = tiles.iterator();

        for (int row = 0; row != Board.NUM_ROWS; row++) {
            for (int col = 0; col != Board.NUM_COLS; col++) {
                this.tiles[row][col] = iter.next();
            }
        }
    }

    /**
     * Return the number of tiles on the board.
     *
     * @return the number of tiles on the board
     */
    int numTiles() {
        if (Board.NUM_ROWS != 0 && Board.NUM_COLS != 0) {
            return Board.NUM_ROWS * Board.NUM_COLS;
        }
        return -1;
    }

    /**
     * Return the tile at (row, col)
     *
     * @param row the tile row
     * @param col the tile column
     * @return the tile at (row, col)
     */
    Tile getTile(int row, int col) {
        return tiles[row][col];
    }

    /**
     * Swap the tiles at (row1, col1) and (row2, col2)
     *
     * @param row1 the first tile row
     * @param col1 the first tile col
     * @param row2 the second tile row
     * @param col2 the second tile col
     */
    void swapTiles(int row1, int col1, int row2, int col2) {
        Tile temp = tiles[row1][col1];
        tiles[row1][col1] = tiles[row2][col2];
        tiles[row2][col2] = temp;
        setChanged();
        notifyObservers();
    }

    @Override
    public String toString() {
        return "Board{" +
                "tiles=" + Arrays.toString(tiles) +
                '}';
    }


    /**
     * Return a new BoardIterator.
     *
     * @return a new BoardIterator
     */
    @NonNull
    @Override
    public Iterator<Tile> iterator() {
        return new BoardIterator();
    }

    /**
     * Iterate over tiles in a range of total number of tiles.
     */
    private class BoardIterator implements Iterator<Tile> {

        /**
         * The row number of the tile.
         */
        private int row;
        /**
         * The column number of the tile.
         */
        private int col;

        @Override
        public boolean hasNext() {
            return row < Board.NUM_ROWS && col < Board.NUM_COLS;
        }

        @Override
        public Tile next() {
            if (hasNext()) {
                if (Board.NUM_COLS - 1 == col) {
                    Tile temp = getTile(row, col);
                    row++;
                    col = 0;
                    return temp;
                }
                return getTile(row, col++);
            }
            throw new NoSuchElementException();
        }
    }
}
