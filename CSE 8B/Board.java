///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              2048
// Files:              
// Quarter:            (course) Winter 2022
//
// Author:             Minkyung Jun
// Email:              m2jun@ucsd.edu
// Instructor's Name:  Greg Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                  If pair programming is allowed:
//                  1. Read PAIR-PROGRAMMING policy
//                  2. Choose a partner wisely
//                  3. Complete this section for each program file
//
// Pair Partner:        Haewon Jung
// Email:               h7jung
// Instructors's Name:  greg miranda
// Lab Section:         
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   must fully acknowledge and credit those sources of help.
//                   Instructors and TAs do not have to be credited here,
//                   but roommates, relatives, strangers, etc do.
//
// Persons:          Identify persons by name, relationship to you, and email.
//                   Describe in detail the the ideas and help they provided.
//
// Online sources:   Avoid web searches to solve your problems, but if you do
//                   search, be sure to include Web URLs and description of
//                   of any information you find.
//////////////////////////// 80 columns wide //////////////////////////////////
/**
 * Sample Board
 * <p/>
 *     0   1   2   3
 * 0   -   -   -   -
 * 1   -   -   -   -
 * 2   -   -   -   -
 * 3   -   -   -   -
 * <p/>
 * The sample board shows the index values for the columns and rows
 * Remember that you access a 2D array by first specifying the row
 * and then the column: grid[row][column]
 */

import java.util.*;
import java.io.*;



public class Board {
   /* Number of tiles showing when the game starts */
   public final int NUM_START_TILES = 2;

   /* The probability (times 100) that a randomly generated tile will be a 2 (vs a 4) */
   public final int TWO_PROBABILITY = 90;

   /* The size of the grid */
   public final int GRID_SIZE;

   /* A reference to the Random object, passed in as a parameter in Board's constructors */
   private final Random random;

   /* The grid of tile values, its size being boardSize * boardSize */
   private int[][] grid;

   /* Current game score, incremented as the tiles merge */
   private int score;

   /* Direction strings */
   public final String LEFT = "LEFT";
   public final String RIGHT = "RIGHT";
   public final String UP = "UP";
   public final String DOWN = "DOWN";

   /**
    * The purpose of this method is to create or construct a fresh
    * board for the user with two random tiles places within the board. This
    * board will have a particular boardSize that the user sets, as well as a
    * random
    *
    * @param boardSize size of the 2048 game board to be used.
    * @param random    Random random represents the random number which
    *                  be used to specific where (after every move) a
    *                  new tile should be added to the board when playing.
    */
   public Board(Random random, int boardSize) {
      if (boardSize < 2) boardSize = 4;

      // initialize member variables
      this.random = random;
      this.GRID_SIZE = boardSize;
      this.grid = new int[this.GRID_SIZE][this.GRID_SIZE];
      this.score = 0;

      // loop through and add two initial tiles to the board randomly
      for (int index = 0; index < this.NUM_START_TILES; index++) {
         addRandomTile();
      }
   }

   /**
    * Constructs a board using an input file
    *
    * @param Random random - the random generator for tile values
    * @param String inputBoard - the String type of the name of the file
    *                            that will be loaded
    */
    public Board(Random random, String inputBoard) throws IOException {
        this.random = random;

        File boardFile = new File(inputBoard);
        Scanner input = new Scanner(boardFile);
        int boardSize = 0;
        while ( input.hasNext() ) {
            boardSize = input.nextInt();
            this.score = input.nextInt();
            this.grid = new int[boardSize][boardSize];
            //after loading the first two tokens as the boardSize and score,
            //iterate through the grid and update the values with the rest of the
            //tokens
            for (int row = 0; row <this.grid.length; row++) {
                for (int column = 0; column < this.grid[row].length; column++) {
                    int tileValue = input.nextInt();
                    this.grid[row][column] = tileValue;
                }
            }
        }
       this.GRID_SIZE = boardSize;
    }

    /**
     * Constructor used to load boards for grading/testing
     *
     * @param random
     * @param inputBoard
     */
    public Board(Random random, int[][] inputBoard) {
        this.random = random;
        this.GRID_SIZE = inputBoard.length;
        this.grid = new int[this.GRID_SIZE][this.GRID_SIZE];
        for (int r = 0; r < this.GRID_SIZE; r++) {
            for (int c = 0; c < this.GRID_SIZE; c++) {
                this.grid[r][c] = inputBoard[r][c];
            }
        }
    }

    /**
     * Print the current board as a 2D grid.
     * You should call this method from PA5Tester
     * or whenever you debug your code
     *
     * Use this format to print the board
     * int number = 16;
     * System.out.printf("%5d", number);
     */
    public void printBoard() {

        int number;
        for(int r=0; r<this.GRID_SIZE; r++){
            for(int c=0; c<this.GRID_SIZE; c++){
                number = this.getTileValue(r,c);
                System.out.printf("%5d", number);
            }
            System.out.println();
        }
    }

    /**
     * Print the current board as a 2D grid.
     * You should call this method from PA5Tester
     * or whenever you debug your code
     *
     * Use this format to print the board
     * int number = 16;
     * System.out.printf("%5d", number);
     *
     * @param String direction the tiles will move
     */
    public void printBoard(String direction) {

        int[][] backupGrid = this.getGrid();
        this.move(direction);
        printBoard();
        this.setGrid(backupGrid);
    }


    /**
     * The purpose of this method is to check to see if the movement of
     * the tiles in any direction can actually take place. It does not move the
     * tiles, but at every index of the grid, checks to see if there is a tile
     * above, below, to the left or right that has the same value. If this is
     * the case, then that tile can be moved. It also checks if there is an
     * empty (0) tile at a specified index, as this also indicates that movement
     * can be possible. This method is called within move() so that that method
     * can determine whether or not tiles should be moved.
     *
     * @param String direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean canMove(String direction){
        // utilize helper methods to check if movement in a particular
        // direction is possible

        if (direction.equals(this.UP)) {
            return this.canMoveUp();
        }
        else if (direction.equals(this.RIGHT)) {
            return this.canMoveRight();
        }
        else if (direction.equals(this.DOWN)) {
            return this.canMoveDown();
        }
        else if (direction.equals(this.LEFT)) {
            return this.canMoveLeft();
        }
        else {
            return false;
        }
    }

    /**
     * determines if a move upwards is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveUp() {

        for(int r=1; r<this.GRID_SIZE; r++){
            for(int c=0; c<this.GRID_SIZE; c++){
                if(this.getTileValue(r, c)!=0){
                    if(this.grid[r-1][c]==0){
                        return true;
                    }
                    else if(this.grid[r-1][c]==this.grid[r][c]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * determines if a move downwards is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveDown() {
 
        for(int r=0; r<this.GRID_SIZE-1; r++){
            for(int c=0; c<this.GRID_SIZE; c++){
                if(this.getTileValue(r, c)!=0){
                    if(this.grid[r+1][c]==0){
                        return true;
                    }
                    else if(this.grid[r+1][c]==this.grid[r][c]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * determines if a move rightward is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveRight() {

        for(int r=0; r<this.GRID_SIZE; r++){
            for(int c=0; c<this.GRID_SIZE-1; c++){
                if(this.getTileValue(r, c)!=0){
                    if(this.grid[r][c+1]==0){
                        return true;
                    }
                    else if(this.grid[r][c+1]==this.grid[r][c]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * determines if a move leftwards is possible
     *
     * @return true if such a move is possible, false if no such move is
     */
    private boolean canMoveLeft() {

        for(int r=0; r<this.GRID_SIZE; r++){
            for(int c=1; c<this.GRID_SIZE; c++){
                if(this.getTileValue(r, c)!=0){
                    if(this.grid[r][c-1]==0){
                        return true;
                    }
                    else if(this.grid[r][c-1]==this.grid[r][c]){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * The purpose of this method is to move the tiles in the game
     * board by a specified direction passed in as a parameter. If the movement
     * cannot be done, the method returns false. If the movement can be done, it
     * moves the tiles and returns true. This method relies on the help of four
     * other helper methods to perform the game play.
     *
     * @param String direction the tiles will move (if possible)
     * @return true if the movement can be done and false if it cannot
     */
    public boolean move(String direction) {
        /* if canMove is false, exit and don't move tiles */
        if (!this.canMove(direction)) return false;

        /* move in relationship to the direction passed in */
        if (direction.equals(this.UP)) {
            this.moveUp();
        }
        else if (direction.equals(this.RIGHT)) {
            this.moveRight();
        }
        else if (direction.equals(this.DOWN)) {
            this.moveDown();
        }
        else if (direction.equals(this.LEFT)) {
            this.moveLeft();
        }
        else {
            return false;
        }

        return true;
    }

    /**
     * performs a move upward
     *
     * Precondition: an upward move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveUp() {

        for (int c=0; c<this.GRID_SIZE; c++){
            for (int r=0; r<this.GRID_SIZE-1; r++){
                if (this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while (this.grid[pointerR+1][pointerC]==0 || this.grid[pointerR+1][pointerC]==this.grid[r][c]){
                        if (this.grid[pointerR+1][pointerC]==0){
                            if(pointerR<this.GRID_SIZE-2){
                                pointerR ++;
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            this.grid[r][c] *=2;
                            this.grid[pointerR+1][pointerC] = 0;
                            break;
                        }
                    }
                }
            }
        }
        for(int c=0; c<this.GRID_SIZE; c++){
            for(int r=1; r<this.GRID_SIZE; r++){
                if(this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while(pointerR!=0&&this.grid[pointerR-1][pointerC]==0){
                        this.grid[pointerR-1][pointerC]=this.grid[pointerR][pointerC];
                        this.grid[pointerR][pointerC]=0;
                        pointerR --;
                    }
                }
            }
        }

    }

    /**
     * performs a move downward
     * Precondition: a downward move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveDown() {

        for (int c=0; c<this.GRID_SIZE; c++){
            for (int r=this.GRID_SIZE-1; r>0; r--){
                if (this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while (this.grid[pointerR-1][pointerC]==0 || this.grid[pointerR-1][pointerC]==this.grid[r][c]){
                        if (this.grid[pointerR-1][pointerC]==0){
                            if(pointerR>1){
                                pointerR --;
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            this.grid[r][c] *=2;
                            this.grid[pointerR-1][pointerC] = 0;
                            break;
                        }
                    }
                }
            }
        }        
        for(int c=0; c<this.GRID_SIZE; c++){
            for(int r=this.GRID_SIZE-2; r>=0; r--){
                if(this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while(pointerR!=this.GRID_SIZE-1&&this.grid[pointerR+1][pointerC]==0){
                        this.grid[pointerR+1][pointerC]=this.grid[pointerR][pointerC];
                        this.grid[pointerR][pointerC]=0;
                        pointerR ++;
                    }
                }
            }
        }
    }

    /**
     * performs a move left
     * Precondition: a left move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveLeft() {

        // First, see if there are values we can combine and combine them
        for (int r=0; r<this.GRID_SIZE; r++){
            for (int c=0; c<this.GRID_SIZE-1; c++){
                if (this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while (this.grid[pointerR][pointerC+1]==0 || this.grid[pointerR][pointerC+1]==this.grid[r][c]){
                        if (this.grid[pointerR][pointerC+1]==0){
                            if(pointerC<this.GRID_SIZE-2){
                                pointerC ++;
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            this.grid[r][c] *=2;
                            this.grid[pointerR][pointerC+1] = 0;
                            break;
                        }
                    }
                }
            }
        }
        // Second, move everything to the left
        for(int r=0; r<this.GRID_SIZE; r++){
            for(int c=1; c<this.GRID_SIZE; c++){
                if(this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while(pointerC!=0&&this.grid[pointerR][pointerC-1]==0){
                        this.grid[pointerR][pointerC-1]=this.grid[pointerR][pointerC];
                        this.grid[pointerR][pointerC]=0;
                        pointerC --;
                    }
                }
            }
        }
    }

    /**
     * performs a move right
     * Precondition: a right move is possible.
     * Postcondition: The board is modified to reflect the move
     */
    private void moveRight() {

        for (int r=0; r<this.GRID_SIZE; r++){
            for (int c=this.GRID_SIZE-1; c>0; c--){
                if (this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while (this.grid[pointerR][pointerC-1]==0 || this.grid[pointerR][pointerC-1]==this.grid[r][c]){
                        if (this.grid[pointerR][pointerC-1]==0){
                            if(pointerC>1){
                                pointerC --;
                            }
                            else {
                                break;
                            }
                        }
                        else {
                            this.grid[r][c] *=2;
                            this.grid[pointerR][pointerC-1] = 0;
                            break;
                        }
                    }
                }
            }
        }        
        for(int r=0; r<this.GRID_SIZE; r++){
            for(int c=this.GRID_SIZE-2; c>=0; c--){
                if(this.grid[r][c]!=0){
                    int pointerR = r;
                    int pointerC = c;
                    while(pointerC!=this.GRID_SIZE-1&&this.grid[pointerR][pointerC+1]==0){
                        this.grid[pointerR][pointerC+1]=this.grid[pointerR][pointerC];
                        this.grid[pointerR][pointerC]=0;
                        pointerC ++;
                    }
                }
            }
        }
    }


    /**
     * saves the current board to a file
     *
     * @param String outputBoard - the string of the name of the file that
     *                              will be created
     */
    public void saveBoard(String outputBoard) throws IOException {
        File boardFile = new File( outputBoard );
        PrintWriter output = new PrintWriter( boardFile );
        output.println(this.GRID_SIZE);
        output.println(this.score);
        //iterate through the grid and print it, new line for every row
        for (int row = 0; row < this.grid.length; row++) {
            int count = 0;
            for (int column = 0; column < this.grid[row].length; column++) {
                output.print(this.grid[row][column] + " ");
                count += 1;
                if ( count == this.GRID_SIZE) {
                    output.println();
                    count = 0;
                }
            }
        }
        output.close();
    }

    /**
     * gets the count of empty spaces in a grid
     *
     * @return int count - the number of empty spaces
     */
    public int getCount() {
        int count = 0;
        for (int row = 0; row < this.grid.length; row++) {
            for (int column = 0; column < this.grid[row].length; column++) {
                int tileValue = this.grid[row][column];
                if ( tileValue == 0 ) {
                    count += 1;
                }
            }
        }
        return count;
    }

    /**
     * The purpose of this method is to add a random tile of either
     * value 2 or 4 to a random empty space on the 2048
     * board. The place where this tile is added is dependent on the random
     * value associated with each board object. If no tiles are empty, it
     * returns without changing the board.
     */
    public void addRandomTile() {
        int count = this.getCount();
        if (count == 0) {
            System.out.println("There are no empty spaces!");
            return;
        }

        int location = this.random.nextInt(count);
        int value = this.random.nextInt(100);
        int emptySpaces = -1;
        //iterate through the 2D array
        for (int row = 0; row < this.grid.length; row++) {
            for (int column = 0; column < this.grid[row].length; column++) {
                int tileValue = this.grid[row][column];
                if (tileValue == 0)
                    emptySpaces += 1;

                //when the number of the empty space equals the random location,
                //add either a 2 or 4 to that location
                if (emptySpaces == location) {
                    if ( value < this.TWO_PROBABILITY ) {
                        this.grid[row][column] = 2;
                        return;
                    }
                    else {
                        this.grid[row][column] = 4;
                        return;
                    }
                }
            }
        }
    }

    /**
     * The purpose of this method is to check whether or not the game
     * in play is over. The game is officially over once there are no longer any
     * valid moves that can be made in any direction. If the game is over, this
     * method will return true and print the words: "Game Over!" This method
     * will be checked before any movement is ever made.
     *
     * @return true if the game is over, and false if the game isn't over
     */
    public boolean isGameOver() {
        return (!canMoveLeft() && !canMoveRight() && !canMoveUp()
                && !canMoveDown());
    }

    /**
     * get a copy of the grid
     *
     * @return A copy of the grid
     */
    public int[][] getGrid() {
        int[][] gridCopy = new int[this.GRID_SIZE][this.GRID_SIZE];
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
                gridCopy[r][c] = this.grid[r][c];
            }
        }
        return gridCopy;
    }

    /**
     * get a copy of the grid
     *
     * @param newGrid the grid that you want to set to
     */
    public void setGrid(int[][] newGrid) {
        for (int r = 0; r < this.grid.length; r++) {
            for (int c = 0; c < this.grid[r].length; c++) {
                this.grid[r][c] = newGrid[r][c];
            }
        }
    }

    /**
     * return the tile value in a particular cell in the grid.
     *
     * @param row The row
     * @param col The column
     * @return The value of the tile at (row, col)
     */
    public int getTileValue(int row, int col) {
        return this.grid[row][col];
    }

    /**
     * Get the current score
     *
     * @return the current score of the game
     */
    public int getScore() {
        return this.score;
    }

    @Override
    public String toString() {
        StringBuilder outputString = new StringBuilder();
        outputString.append(String.format("Score: %d\n", this.score));
        for (int row = 0; row < this.GRID_SIZE; row++) {
            for (int column = 0; column < this.GRID_SIZE; column++)
                outputString.append(this.grid[row][column] == 0 ? "    -" :
                        String.format("%5d", this.grid[row][column]));

            outputString.append("\n");
        }
        return outputString.toString();
    }
}
