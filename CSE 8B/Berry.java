///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Berry.java
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

public class Berry extends Item {
	private int patienceIncrement;
	private int speedDecrement;

	public Berry() {

		super();
		patienceIncrement = 0;
		speedDecrement = 0;

	}

	public Berry(String berryName, int patienceInc, int speedDec) {
		super();
		this.name = berryName;
		this.patienceIncrement = patienceInc;
		this.speedDecrement = speedDec;
	}

	
	public int getPatienceIncrement() {
		return this.patienceIncrement;

	}

	public int getSpeedDecrement() {
		return this.speedDecrement;
	}

	@Override
	public String toString() {

		return name + "\n" + "patienceIncrement: " + patienceIncrement + "\n" + "speedDecrement: " + speedDecrement + "\n" ;
	}
}