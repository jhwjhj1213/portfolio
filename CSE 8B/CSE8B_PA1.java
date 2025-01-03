///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              CSE8B_PA1
// Files:              java
// Quarter:            Winter 2022
//
// Author:             Haewon Jung
// Email:              h7jung@ucsd.edu
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

public class CSE8B_PA1 {
    public static void main(String[] args) {
        System.out.println("Welcome to the CSE 8B trivia quiz.  I have three questions for you about Dorothy Vaughan.”);
        String str1 = "NASA"
        String str2 = "FORTRAN"
        String str3 = "Scout Launch Vehicle Program"
        String input1 = null;
        String input2 = null;
        String input3 = null;

        System.out.println(“Where did she become the first black women programming supervisor?”);
        input1 = sc.nextLine();

        if (input1.equals(str1)) {
                 System.out.println(“That’s right!”);
        }else { 
                 System.out.println(“That’s incorrect. The correct answer is NASA.”);
        }


        System.out.println(“What programming language does Dorothy Vaughan learn?”);
        input2 = sc.nextLine();
        if (input2.equals(str2)) {
                 System.out.println(“That’s right!”);
        }else { 
                 System.out.println(“That’s incorrect. The correct answer is FORTRAN.”);
        }

        System.out.println(“What program did she contribute?”);
        input3 = sc.nextLine();
        if (input3.equals(str3)) {
                 System.out.println(“That’s right!”);
        }else { 
                 System.out.println(“That’s incorrect. The correct answer is Scout Launch Vehicle Program.”);
        }
    }
}
