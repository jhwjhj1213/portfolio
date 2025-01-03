///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:    PA8Tester.java
// File:               Pokeball.java
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

class Pokeball extends Item {

    private int performance;

    public Pokeball () {
        super();
        performance = 0;
    }

    public Pokeball(String pokeballName, int performanceIn){
        super();
        this.name = pokeballName;
        this.performance = performanceIn;
    }

    public int getPerformance(){
        return this.performance;
    }

    @Override
    public String toString(){

    	return name+"\n"+"performance: "+performance + "\n";
    }

}
