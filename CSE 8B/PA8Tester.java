///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:              PA8Tester.java
// Files:              (list of source files)
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
// Main Class File:    Assignment8.java
// File:               Item.java
// Quarter:            CSE 8B Winter 2022
//
//
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * Tests written to check if other classes work as intended
 *
 * Bugs: None known
 *
 */
public class PA8Tester {
	public static void main(String[] args) {
		System.out.println("\n-------------------------------------------\n");

		/* PART 1 */

		Pokeball pokeball = new Pokeball("Great Ball", 10);
		System.out.println(pokeball.getName() + "," + pokeball.getPerformance());

		Pokeball pokeball1 = new Pokeball("Ultra Ball", 30);
		System.out.println(pokeball1.getName() + "," + "PokeBall" + "," + pokeball1.getPerformance());

		System.out.println("\n-------------------------------------------\n");

		/* PART 2 */

		Berry razzBerry = new Berry("Razz Berry", 10, 0);
		System.out.println(razzBerry.getName() + "," + "Berry" + "," + razzBerry.getPatienceIncrement() + ","
				+ razzBerry.getSpeedDecrement());

		Berry nanapBerry = new Berry("Nanap Berry", 0, 10);
		System.out.println(nanapBerry.getName() + "," + "Berry" + "," + nanapBerry.getPatienceIncrement() + ","
				+ nanapBerry.getSpeedDecrement());

		System.out.println("\n-------------------------------------------\n");

		/* PART 3 */

		PalPokemon palPokemon = new PalPokemon("Pikachu", "pikapika", "electric", "UltraBall");
		palPokemon.comesOutFromBall();

		PalPokemon palPokemon1 = new PalPokemon("Bulbasaur", "bulb", "grass", "GreatBall");
		palPokemon1.comesOutFromBall();

		System.out.println("\n-------------------------------------------\n");

		/* PART 4 */
		WildPokemon wildPokemon = new WildPokemon("Charmander", "char", "fire", 50, 20);
		System.out.println(wildPokemon.getName() + "," + wildPokemon.getSound() + "," + wildPokemon.getType() + "," + wildPokemon.getPatience() + wildPokemon.getSpeed() + wildPokemon.getTimesEscapedFromBall());
		wildPokemon.appear();
		wildPokemon.disappear();

		WildPokemon wildPokemon2 = new WildPokemon("Mew", "mew", "psychic", 15, 50);
		System.out.println(wildPokemon2.getName() + "," + wildPokemon2.getSound() + "," + wildPokemon2.getType() + "," + wildPokemon2.getPatience() + wildPokemon2.getSpeed() + wildPokemon2.getTimesEscapedFromBall());
		wildPokemon2.appear();
		wildPokemon2.disappear();

		System.out.println("\n-------------------------------------------\n");

		/* PART 5 */

		Backpack backpack = new Backpack();
		backpack.display();

		backpack.add(pokeball);
		backpack.add(pokeball1);
		backpack.display();

		backpack.add(razzBerry);
		backpack.add(nanapBerry);
		backpack.display();

		Pokedex pokedex = new Pokedex();
		pokedex.display();

		pokedex.add(palPokemon);
		pokedex.add(palPokemon1);
		pokedex.display();

		pokedex.add(wildPokemon);
		pokedex.add(wildPokemon2);
		pokedex.display();
	}
}
