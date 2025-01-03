///////////////////////////////////////////////////////////////////////////////
// Main Class File:    EasterEggTester.java
// File:               EasterEgg.java
// Quarter:            CSE 8B Winter 2022
//
// Author:             Haewon Jung
// Email:              h7jung@ucsd.edu
// Instructor's Name:  Gregory Miranda
//////////////////////////// 80 columns wide //////////////////////////////////

import java.util.*;

/**
 * A class that helps strategize 
 * for the EasterEgg race.
 *
 * Bugs: Something is weird about `recursiveSum`...
 *
 * @author Haewon Jung
 */
public class EasterEgg {
	
    /**
     * Generates an array of scores based 
     * on the elements in the eggs ArrayList
     * 
     * @param eggs - an ArrayList of Strings that denote the type of egg
     */
	public int[] calculateScores(ArrayList<String> eggs) throws Exception {

		int scores[] = new int[eggs.size()];
        // TODO: Implement this method!
		int i = 0;
        for(String egg : eggs)
        {
        	if(egg.equals("Chocolate"))
        	{
        		scores[i]= (i+1) * 10;
        	}else if(egg.equals("Golden"))
        	{
        		scores[i]= (i+1) * 10 * 2;
        	}else
        	{
        		throw new Exception("Invalid Easter Egg");
        	}
        	i++;
        }
        return scores; // Remove this line after you finished your implementation.

	}
    
    /**
     * Recursively calculates the highest score possible
     * 
     * @param scores[] - integer array of all the scores of each egg
     * @param idx - index of first or index of last element of scores
     *  (depending on your implementation.)
     */
    public int maxScore(int scores[], int idx) {
    	int sum = 0;
    	if(idx < scores.length)
    	{  	
    		if(idx+3 < scores.length)
    		{
    			if(scores[idx+3] > scores[idx+2])
    			{
    				sum = scores[idx] + maxScore(scores, idx+3); 
    				return sum;
    			}else
    			{
    				sum = scores[idx] + maxScore(scores, idx+2);  
    	    		return sum;
    			}
    		}
    		sum = scores[idx] + maxScore(scores, idx+2);  
    		return sum;
    	}
    	System.out.println(sum);
        return sum; // Remove this line after you finished your implementation.
    }	

    /**
     * Recursively calculates the sum of numbers from 1 to the 
     * parameter `num`, but there is an error...
     * 
     * @param num - number up to which the sum is calculated 
     */
    public int recursiveSum(int num){

		// TODO: Fix this method to resolve the infinite loop!
    	int sum = 0;
    	if(num > 0)
    		return sum = num + recursiveSum(num - 1);
    	else
    		return  sum;
    }	
}
