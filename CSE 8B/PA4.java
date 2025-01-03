///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA4
// Files:              
// Quarter:            Winter 2022
//
// Author:             Minkyung Jun
// Email:              m2jun@gmail.com
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
// Email:               h7jung@ucsd.edu
// Instructors's Name:  Greg Miranda
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

import java.io.IOException;
import java.util.Scanner;
import java.io.File;


// TODO: Add class header comment
public class PA4 {

    /* Reads file and translates it into a 2d array of MazePoint objects.
    * if file does not follow the correct guidelines, it will return null.
    */
    public MazePoint[][] readMaze(String fileToRead) throws IOException
    {
        // TODO: Replace this
        File readThis = new File(fileToRead);
        Scanner scan = new Scanner(readThis);
        if(scan.hasNextInt()){
            int r = scan.nextInt();
            int c = scan.nextInt();
            if(scan.hasNextLine()){
                scan.nextLine();
            }
            MazePoint[][] maze = new MazePoint[r][c];
            for(int row=0; row<r; row++){
                String stringAtRow = scan.nextLine();
                for(int column=0; column<c; column++){
                    if(stringAtRow.charAt(2*column) == 'X'){
                        maze[row][column] = new MazePoint(true);
                    }
                    else if(stringAtRow.charAt(2*column) == '-'){
                        maze[row][column] = new MazePoint(false);
                    }
                    else{
                        System.out.println("input error at readMaze");
                    }
                }
            }
            scan.close();
            return maze;
        }
        else {
            scan.close();
            return null;
        }
    }

    /*
    *Takes in a 2d array of MazePoints and solves it.
    * Outputs error message when maze is null or zero length.
    */
    public void escapeFromMaze(MazePoint [][] maze){
        //TODO
        if(maze == null){
            System.out.println("Maze is null");
            return;
        }
        else if(maze.length<1 || maze[0].length<1){
            System.out.println("The input maze has either 0 rows or 0 columns or both. (Is a zero length 2d array.)");
            return;
        }

        maze[0][0].setToPath();

        int r=0;
        int c=0;
        while(r<maze.length-1 || c<maze[0].length-1) {
            if((r<maze.length-1) && maze[r+1][c].isEmpty()) {
                maze[r+1][c].setToPath();
                r++;
            }
            else if((c<maze[0].length-1) && maze[r][c+1].isEmpty()) {
                maze[r][c+1].setToPath();
                c++;
            }
            else {
                System.out.println("The maze has a dead end");
                break;
            }
        }
    }

    /**
    * Print the maze as a 2D grid.  You should call this method from
    * testRead and testEscape, as well as from main.
    *
    * Precondition: The maze is not null.
    * Postcondition: The maze has been printed and is unmodified.
    *
    * @param maze The maze to be printed.
    */
    private void printMaze(MazePoint[][] maze)
    {
        if(maze == null){
            return;
        }

        MazePoint[][] inputMaze = maze;
        for(int r=0; r<inputMaze.length; r++){
            for(int c=0; c<inputMaze[r].length; c++){
                if(inputMaze[r][c].isWall()){
                    System.out.print("X");
                } 
                else if(inputMaze[r][c].isEmpty()){
                    System.out.print("-");
                }
                else{
                    System.out.print("*");
                }
                System.out.print(" ");       
            }
        System.out.println();
        }
    }

    /**
    * Compare two maze arrays.  Return true if they have .  You should call
    * this method from testRead and testEscape.
    *
    * Precondition: The mazes are not null and have the same size.
    * Postcondition: The mazes are not modified.
    *
    * @param maze1 the first maze to compare.
    * @param maze2 the second maze to compare.
    * @return true if the mazes contain all the same symbols and false otherwise
    */
    private boolean mazeMatch(MazePoint[][] maze1, MazePoint[][] maze2)
    {
        // TODO: Implement this method
        if(maze1==null||maze2==null){
            if(maze1==null&&maze2==null){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            for(int r=0; r<maze1.length; r++){
                for(int c=0; c<maze1[r].length; c++){
                    if(!maze1[r][c].symbolMatch(maze2[r][c])){
                        return false;
                    }          
                }
            }
        return true;
        }
    }

    /** takes in a string of a filename and a expected maze as parameters
     * tests if readmaze method worked correctly on filetoRead 
     * by comparing its output and the expected maze
     */
    public boolean testRead(String fileToRead, MazePoint[][] expected) throws
                            IOException
    {
        MazePoint[][] inputMaze = readMaze(fileToRead);
        MazePoint[][] expMaze = expected;
        System.out.println("Expected Maze:");
        this.printMaze(expMaze);
        System.out.println("Maze read from readMaze:");
        this.printMaze(inputMaze);
        return mazeMatch(inputMaze, expMaze);
    }

    /**
     * Tests if escapeFromMaze works correctly by comparing
     * outputs from using escapeFromMaze method on maze and 
     * the expected solution
     * @param maze maze to run escapeFromMaze on
     * @param expectedSolution Expected solution
     * @return true if the mazes match
     */
    public boolean testEscape(MazePoint[][] maze,
                              MazePoint[][] expectedSolution)
    {
        escapeFromMaze(maze);
        MazePoint[][] solvedMaze = maze;
        MazePoint[][] expSol = expectedSolution;
        if(maze==null){
            return mazeMatch(solvedMaze, expSol);
        }
        else if(maze.length==0||maze[0].length==0){
            return mazeMatch(solvedMaze, expSol);
        }
        else {
            System.out.println("Expected Solution:");
            this.printMaze(expSol);
            System.out.println("Solution obtained from escapeFromMaze:");
            this.printMaze(solvedMaze);
            return mazeMatch(solvedMaze, expSol);
        }
    }

    /**
    * Run unit tests.  You will add to this method.
    * Prints a message indicating whether all tests passed or failed.
    * The method will abort on the first failed test.
    * @return true if all unit tests pass.  false if at least one test fails.
    */
    public boolean unitTests() throws IOException {
        // Manually create the expected maze to match file input1
        MazePoint[][] expected = new MazePoint[3][3];
        expected[0][0] = new MazePoint(false);
        expected[0][1] = new MazePoint(false);
        expected[0][2] = new MazePoint(true);
        expected[1][0] = new MazePoint(true);
        expected[1][1] = new MazePoint(false);
        expected[1][2] = new MazePoint(false);
        expected[2][0] = new MazePoint(true);
        expected[2][1] = new MazePoint(true);
        expected[2][2] = new MazePoint(false);
       
        if (!this.testRead("input1", expected)) {
            System.out.println("Read test 1 failed.");
            return false;
        }
        else {
          System.out.println("Read test 1 passed!");
        }
        //TODO: Add at least two more calls to testRead
        MazePoint[][] expected4 = new MazePoint[3][3];
        expected4[0][0] = new MazePoint(false);
        expected4[0][1] = new MazePoint(true);
        expected4[0][2] = new MazePoint(true);
        expected4[1][0] = new MazePoint(false);
        expected4[1][1] = new MazePoint(false);
        expected4[1][2] = new MazePoint(true);
        expected4[2][0] = new MazePoint(true);
        expected4[2][1] = new MazePoint(false);
        expected4[2][2] = new MazePoint(false);

        if(!this.testRead("input4", expected4)) {
            System.out.println("Read test 2 failed.");
            return false;
        }
        else {
            System.out.println("Read test 2 passed!");
        }

        MazePoint[][] expected3 = new MazePoint[3][4];
        expected3[0][0] = new MazePoint(true);
        expected3[0][1] = new MazePoint(true);
        expected3[0][2] = new MazePoint(true);
        expected3[0][3] = new MazePoint(false);
        expected3[1][0] = new MazePoint(true);
        expected3[1][1] = new MazePoint(false);
        expected3[1][2] = new MazePoint(false);
        expected3[1][3] = new MazePoint(false);
        expected3[2][0] = new MazePoint(true);
        expected3[2][1] = new MazePoint(false);
        expected3[2][2] = new MazePoint(true);
        expected3[2][3] = new MazePoint(true);

        if(!this.testRead("input3", expected3)) {
            System.out.println("Read test 3 failed.");
            return false;
        }
        else {
            System.out.println("Read test 3 passed!");
        }


        // At this point readMaze is working, so we can use it.
        MazePoint[][] maze1 = this.readMaze("input1");

        // Modify the expected maze from above to have the path
        expected[0][0].setToPath();
        expected[0][1].setToPath();
        expected[1][1].setToPath();
        expected[1][2].setToPath();
        expected[2][2].setToPath();

        if (!this.testEscape(maze1, expected)) {
            System.out.println("Escape test 1 failed.");
            return false;
        }
        else {
          System.out.println("Escape test 1 passed!");
        }

        //TODO: Add at least three more calls to testMaze

        // input4 testing

        MazePoint[][] maze4 = this.readMaze("input4");

        expected4[0][0].setToPath();
        expected4[1][0].setToPath();
        expected4[1][1].setToPath();
        expected4[2][1].setToPath();
        expected4[2][2].setToPath();

        if (!this.testEscape(maze4, expected4)) {
            System.out.println("Escape test 2 failed.");
            return false;
        }
        else {
          System.out.println("Escape test 2 passed!");
        }

        // zero array Maze testing

        MazePoint[][] escape4 = this.readMaze("escape4");

        MazePoint[][] zeroArrayMaze = new MazePoint[0][0];

        if (!this.testEscape(escape4, zeroArrayMaze)) {
            System.out.println("Escape test 3 failed.");
            return false;
        }
        else {
          System.out.println("Escape test 3 passed!");
        }

        // Null Maze testing

        MazePoint[][] escape5 = this.readMaze("escape5");

        MazePoint[][] nullMaze = null;

        if (!this.testEscape(escape5, nullMaze)) {
            System.out.println("Escape test 4 failed.");
            return false;
        }
        else {
          System.out.println("Escape test 4 passed!");
        }

        return true;
    }


    public boolean part3(String input) throws IOException {
        if(input == "end"){
            return false;
        }
        else{
            MazePoint[][] maze = readMaze(input);
            System.out.println("Maze read from file is: ");
            printMaze(maze);
            System.out.println("Solved maze: ");
            escapeFromMaze(maze);
            printMaze(maze);
            return true;
        }

    }


    // TODO: Add comments and implement method.
    public static void main(String[] args) throws IOException
    {
        PA4 solver = new PA4();

        // Perform unitTest first
        if(solver.unitTests()) {
            System.out.println("All unit tests passed.\n");
        } 
        else {
            System.out.println("Failed test.\n");
            return;
        }

        Scanner scan = new Scanner(System.in);
        String input;
        while(true) {
            System.out.print("Enter file to read: ");
            input = scan.next();
            if(input.equals("end")){
                break;
            }
            solver.part3(input);
        }
        System.out.print("Program closed.");
        scan.close();

        //TODO: Part 3
    }
}
