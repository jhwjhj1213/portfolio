///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               WildPokemon.java
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

class WildPokemon extends Pokemon {
	private int patience;
	private int speed;
	private int timesEscapedFromBall;

	public WildPokemon() {
		super();
		patience = 100;
		speed = 0;
		timesEscapedFromBall = 0;
	}

	public WildPokemon(String pokemonName, String pokemonSound, String pokemonType, int patienceIn, int speedIn) {
		this.name = pokemonName;
		this.sound = pokemonSound;
		this.type = pokemonType;
		this.patience = patienceIn;
		this.speed = speedIn;
		this.timesEscapedFromBall = 0;

	}

	public int getPatience() {
		return patience;
	}

	public int getSpeed() {
		return this.speed;
	}

	public int getTimesEscapedFromBall() {
		return this.timesEscapedFromBall;
	}

	public void setPatience(int newPatience) {
		this.patience = newPatience;
	}

	public void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}

	public void incrementTimeEscapedFromBall() {
		this.timesEscapedFromBall += 1;

	}

	public void appear() {
		System.out.println("You encounter a wild " + this.name + "!");
		super.speak();
	}

	public boolean disappear() {
		if (this.patience <= 0 && this.timesEscapedFromBall > 3) {
			System.out.println(name + " disappears...");
			return true;
		} else
			return false;

	}

	public boolean isCaught(Berry berry, Pokeball pokeball) {
		return true;
	}

	@Override
	public String toString() {

		return name + ", WildPokemon" + "\n" + "type: " + type + "\n" + "patience: " + patience + "\n" + "speed: " + speed
				+ "\n" + "timeEscapedFromBall: " + timesEscapedFromBall + "\n" ;
	}

}