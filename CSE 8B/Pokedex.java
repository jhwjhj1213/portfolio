///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Pokedex.java
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
// File:               Pokedex.java
// Quarter:            CSE 8B Winter 2022
//
//
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.ArrayList;

/**
 * This is Pokedex class that you can add pokemons which can be wild or pal
 * pokemons. You can display your pokedex with display() method
 *
 * Bugs: None known
 *
 * @author
 */

public class Pokedex {

	// ArrayList for pokemons (WildPokemons, PalPokemons)
	ArrayList<Pokemon> myPokedex;

	/**
	 * Creates a resizable-array ArrayLists of Pokemons
	 * 
	 */
	public Pokedex() {
		myPokedex = new ArrayList<>();
	}

	/**
	 * Adds the pokemon to myPokedex
	 * 
	 */
	public void add(Pokemon pokemon) {
		myPokedex.add(pokemon);
	}

	public ArrayList<Pokemon> getMyPokedex() {
		return myPokedex;
	}

	/**
	 * Displays the elements in the myPokedex ArrayList
	 * 
	 */
	public void display() {
		System.out.println("Items in the pokedex:");
		for (Pokemon pokemon : myPokedex) {

			System.out.println(pokemon.getClass().getName());
			// System.out.println(item);
		}

		if (myPokedex.size() == 0)
			System.out.println("None");

	}
}
