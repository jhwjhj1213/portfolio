///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              BarChartRacer.java
// Files:              BarChartRacer.java
// Quarter:            Winter 2022
//
// Author:             Haewon Jung
// Email:              h7jung@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
//                  CHECK ASSIGNMENT PAGE TO see IF PAIR-PROGRAMMING IS ALLOWED
//                  If pair programming is allowed:
//                  1. Read PAIR-PROGRAMMING policy
//                  2. Choose a partner wisely
//                  3. Complete this section for each program file
//
// Pair Partner:        (name of your pair programming partner)
// Email:               (email address of your programming partner)
// Instructors's Name:  (name of your partner's instructor)
// Lab Section:         (your partner's lab section number)
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

///////////////////////////////////////////////////////////////////////////////
// Main Class File:    BarChartRacer.java
// File:               BarChartRacer.java
// Quarter:            CSE 8B Winter 2022
//
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Driver to create a video/multiple BarCharts successively and display
 * them to the user.
 * Run command: java BarChartRacer <input_file> <num entries per chart>
 * For example: java BarChartRacer cities-usa.txt 10
 *
 * Bugs: None known
 *
 * @author Haewon Jung
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.*;
import java.io.*;

public class BarChartRacer {
  // a tracker for the year/date of the current chunk
  private static String caption;
  private static final int PAUSE_TIME = 5;
  private static final HashMap<String, Integer> map = new HashMap<>();
  private static int COLOR_INDEX = 0;

  /**
   * Read bar chunks from scanner
   * @param in Scanner object to read data from.
   * @return `ArrayList<Bar>` containing the data read from scanner.
   */
  private static ArrayList<Bar> getBars(Scanner in) {
    ArrayList<Bar> bars = new ArrayList<>();
    int n = Integer.parseInt(in.nextLine().trim());
    for (int i = 0; i < n; i++) {
      String line = in.nextLine().trim();
      String[] columns = line.split(",");
      // [caption, name, name, value, category]
      caption = columns[0];
      String name = columns[1] + "," + columns[2];
      if (!map.containsKey(name)) {
        map.put(name, COLOR_INDEX++);
      }
      int value = Integer.parseInt(columns[3]);
      String category = columns[4];
      bars.add(new Bar(name, value, category));
    }
    return bars;
  }

  /**
   * Adds all data points from the chunk of bars to the chart object.
   * @param chart BarChart object to display the data
   * @param bars chunk of bars, to be presented
   * @param numEntries no. of entries to show
   */
  private static void createChart(BarChart chart, ArrayList<Bar> bars, int numEntries) {
    if (numEntries > bars.size()) {
      System.out.println("numEntries is greater than bars' length");
      System.exit(1);
    }
    bars.sort(Comparator.reverseOrder());
    chart.setCaption(caption);
    for (int i = 0; i < numEntries; i++) {
      Bar bar = bars.get(i);
      chart.add(bar.getName(), bar.getValue(), map.get(bar.getName()));
    }
  }

  /**
   * Starting point of the program
   * @param args command line arguments passed by user
   */
  public static void main(String[] args) throws FileNotFoundException {
    // do not modify these two lines
    StdDraw.setCanvasSize(1000, 700);
    StdDraw.enableDoubleBuffering();

    int numEntries = 5;
    String fileName;
    System.out.println(Arrays.toString(args));
    if (args.length < 2) {
      fileName = "cities.txt";
    } else {
      fileName = args[0];
      numEntries = Integer.parseInt(args[1]);
    }

    final Scanner sc = new Scanner(new FileInputStream(fileName));

    String title = sc.nextLine();
    String xAxisLabel = sc.nextLine();
    String source = sc.nextLine();

    sc.nextLine(); // Skip a line

    BarChart chart = new BarChart(title, xAxisLabel, source);


    while (true) {
      ArrayList<Bar> bars = getBars(sc);
      createChart(chart, bars, numEntries);
      chart.draw();
      StdDraw.show();
      StdDraw.pause(PAUSE_TIME);;
      chart.reset();
      if (!sc.hasNextLine()) break;
      sc.nextLine();
    }
    sc.close();
  }
}
