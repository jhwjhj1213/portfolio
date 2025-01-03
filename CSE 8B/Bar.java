///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    BarChartRacer.java
// File:               Bar.java
// Quarter:            Winter 2022
//
// Author:             h7jung@ucsd.edu
// Instructor's Name:  Gregory Miranda
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
// Pair Partner:       (name of your pair programming partner)
// Email:              (email address of your programming partner)
// Instructor's Name:  (name of your partner's instructor)
//
//////////////////// STUDENTS WHO GET HELP FROM OTHER THAN THEIR PARTNER //////
//                   fully acknowledge and credit all sources of help,
//                   other than Instructors and TAs.
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
// File:               Bar.java
// Quarter:            CSE 8B Winter 2022
//
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Implementation to create a single Bar in a BarChart
 *
 * Bugs: None known
 *
 * @author Haewon Jung
 */
public class Bar implements Comparable<Bar> {
  private String name;
  private int value;
  private String category;

  public Bar(String name, int value, String category) {
    this.name = name;
    this.value = value;
    this.category = category;
  }

  /**
   * @return the name variable
   */
  public String getName() {
    return name;
  }

  /**
   * @return bar value
   */
  public int getValue() {
    return value;
  }

  /**
   * @return bar category
   */
  public String getCategory() {
    return category;
  }

  /**
   * Compares two Bar objects
   * @param o other bar object to compare with this
   * @return 0 if both have equal values, -1 of this.value is less
   *    than other value, and 1 of this.value is greater
   */
  @Override
  public int compareTo(Bar o) {
    return Integer.compare(this.value, o.value);
  }
}
