///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               PalPokemon.java
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

class PalPokemon extends Pokemon {

	private String pokeballName;

	public PalPokemon() {
		super();
		this.name = "undefined";
	}

	public PalPokemon(String pokemonName, String pokemonSound, String pokemonType, String pokeballName) {
		super();
		this.name = pokemonName;
		this.sound = pokemonSound;
		this.type = pokemonType;
		this.pokeballName = pokeballName;

	}

	public String getPokeballName() {
		return this.pokeballName;
	}

	public void comesOutFromBall() {
		System.out.println(this.name + " in " + this.pokeballName + ", " + this.type + " type pokemon.");
		super.speak();
	}

	@Override
	public String toString() {
		return name + ", PalPokemon" + "\n" + "pokeballName: " + pokeballName + "\n" + "type: " + type + "\n" ;
	}

}
