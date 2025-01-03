///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Backpack.java
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
// Main Class File:    Assignment8.java
// File:               Backpack.java
// Quarter:            CSE 8B Winter 2022
//
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;

/**
 * This is Backpack class that you can add items which are berries and
 * pokeballs. You can display your backpack with display() method
 *
 * Bugs: None known
 * 
 * @author : Haewon Jung
 *
 */

public class Backpack {

	// ArrayList for items (berries, pokeballs)
	private ArrayList<Item> myItems;

	/**
	 * Creates a resizable-array ArrayLists of Items
	 * 
	 */
	public Backpack() {
		myItems = new ArrayList<Item>();

	}

	/**
	 * Adds the item to myItems
	 * 
	 */
	public void add(Item item) {

		myItems.add(item);

	}

	/**
	 * Displays the elements in the myItems ArrayList
	 * 
	 */
	public void display() {
		System.out.println("Items in the backpack:");
		for (Item item : myItems) {

			System.out.println(item.getClass().getCanonicalName());
			// System.out.println(item);
		}

		if (myItems.size() == 0)
			System.out.println("None");

	}
}
