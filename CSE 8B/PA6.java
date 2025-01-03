import java.util.Scanner;
import java.io.*;
import java.util.*;
import java.io.BufferedReader;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA6
// Files:              (list of source files)
// Quarter:            (course) Spring 2020
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

public class PA6 {
    // PROVIDED CONSTANT
    private static final String DELIMITER = ",";        // CSV file delimiter 
    private static final int NAME_INDEX = 0;            //A
    private static final int TEXT_INDEX = 114;          //DK
    private static final int LEX_LIWC_I_INDEX = 19;     //T
    private static final int LEX_LIWC_WE_INDEX = 20;    //U
    private static final int LEX_LIWC_SHEHE_INDEX = 22; //W

    /*
     * When a PA6 object calls this method, this opens the specified file and returns it in an ArrayList.
     */
    public static ArrayList<RedditDataPoint> readData(String fileName, ArrayList<String> categories) throws IOException{

        FileInputStream data = new FileInputStream(fileName);
        ArrayList<RedditDataPoint> points = new ArrayList<RedditDataPoint>();
        try {
            Scanner dataScanner = new Scanner(data);
            dataScanner.nextLine();
            while(dataScanner.hasNextLine()){               
                String line = dataScanner.nextLine(); //error                
                String[] lineData = line.split(DELIMITER);                
                String name = lineData[NAME_INDEX];                
                String text = lineData[TEXT_INDEX];
    //            System.out.println(text);
                Double lex_liwc_i = Double.parseDouble(lineData[LEX_LIWC_I_INDEX]);                
                Double lex_liwc_we = Double.parseDouble(lineData[LEX_LIWC_WE_INDEX]);               
                Double lex_liwc_shehe = Double.parseDouble(lineData[LEX_LIWC_SHEHE_INDEX]);                
                points.add(new RedditDataPoint(name, text, lex_liwc_i, lex_liwc_we, lex_liwc_shehe));               

                if(!categories.contains(name)) {
                    categories.add(name);
                }
                
            }
            dataScanner.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    //    printRedditDataPoint(points);
        return points;       
    }

    /*
     * prints the total number of posts under a certain subreddit
     */
    public static void printTotalPosts(ArrayList<RedditDataPoint> data, ArrayList<String> categories) {

        int[] numOfPosts = new int[categories.size()];
        for(int i=0; i<data.size(); i++) {
            for(int catIndex=0; catIndex<categories.size(); catIndex++){
                if(data.get(i).getName().equals(categories.get(catIndex))){
                    numOfPosts[catIndex]++;
                }
            }
        }
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            System.out.println("r/"+categories.get(catIndex)+" total posts: "+numOfPosts[catIndex]);
        }
        System.out.println();
    }

    /*
     * prints the total number of i's that appear under a certain subreddit
     */
    public static void printTotalLexLiwcI(ArrayList<RedditDataPoint> data, ArrayList<String> categories) {
        int[] numOfI = new int[categories.size()];
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            for(int i=0; i<data.size(); i++) {
                if(data.get(i).getName().equals(categories.get(catIndex))&&data.get(i).getLexLiwcI()!=0){
                    numOfI[catIndex] ++;
                }
            }
        }
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            System.out.println("r/"+categories.get(catIndex)+" total lex_liwc_i: "+numOfI[catIndex]);
        }
        System.out.println();
    }

    /*                 
     * prints the total number of we's that appear under a certain subreddit
     */
    public static void printTotalLexLiwcWe(ArrayList<RedditDataPoint> data, ArrayList<String> categories) {
        int[] numOfWe = new int[categories.size()];
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            for(int i=0; i<data.size(); i++) {
                if(data.get(i).getName().equals(categories.get(catIndex))&&data.get(i).getLexLiwcWe()!=0){
                    numOfWe[catIndex] ++;
                }
            }
        }
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            System.out.println("r/"+categories.get(catIndex)+" total lex_liwc_we: "+numOfWe[catIndex]);
        }
        System.out.println();
    }

    /*
     * prints the total number of she's or he's that appear under a certain subreddit
     */
    public static void printTotalLexLiwcShehe(ArrayList<RedditDataPoint> data, ArrayList<String> categories) {
        int[] numOfShehe = new int[categories.size()];
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            for(int i=0; i<data.size(); i++) {
                if(data.get(i).getName().equals(categories.get(catIndex))&&data.get(i).getLexLiwcShehe()!=0){
                    numOfShehe[catIndex] ++;
                }
            }
        }
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            System.out.println("r/"+categories.get(catIndex)+" total lex_liwc_shehe: "+numOfShehe[catIndex]);
        }       
        System.out.println();
    }

    /*
     * Starpoint OPTIONAL
     */
    public static void printStarPointAverage(ArrayList<RedditDataPoint> data, ArrayList<String> categories) {
       
    }

    
// The below are just some methods that I used while testing

    public static void printRedditDataPoint(ArrayList<RedditDataPoint> data){
        for(int i = 0; i < data.size(); i ++){
            System.out.println(data.get(i).getName()+data.get(i).getLexLiwcI()+data.get(i).getText());
        }
    }

    public static void printStringList(ArrayList<String> data){
        for(int i = 0; i < data.size(); i ++){
            System.out.println(data.get(i));
        }
    }

    public static void printDoubleArray(double[] data){
        for(int i = 0; i < data.length; i ++){
            System.out.println(data[i]);
        }
    }
    
    /*
     * 
     */
    public static void main(String args[]) throws IOException{

        ArrayList<String> categories = new ArrayList<>();
        ArrayList<RedditDataPoint> redDat = readData("Reddit_Data.CSV", categories);
        printTotalPosts(redDat, categories);
        printTotalLexLiwcI(redDat, categories);
        printTotalLexLiwcWe(redDat, categories);
        printTotalLexLiwcShehe(redDat, categories);
    }

}







/** Backup Junk
        int fileLines = 0;
        // count file lines
        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            while (reader.readLine() != null){
                fileLines++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("File not found.");
        }

        File data = new File(fileName);

        // find number of lines in file
        int numCSVRows = fileLines - 1;
        RedditDataPoint [] points = new RedditDataPoint[numCSVRows];
 */


 /**double[] numOfWe = new double[categories.size()];
        for(int i=0; i<data.size(); i++) {
            for(int catIndex=0; catIndex<categories.size(); catIndex++){
                if(data.get(i).getName().equals(categories.get(catIndex))){
                    numOfWe[catIndex]=numOfWe[catIndex] + data.get(i).getLexLiwcWe();
                }     
            }
        }
        
        for(int catIndex=0; catIndex<categories.size(); catIndex++){
            System.out.println("r/"+categories.get(catIndex)+" total lex_liwc_we: "+numOfWe[catIndex]);
        }
        System.out.println();
 */