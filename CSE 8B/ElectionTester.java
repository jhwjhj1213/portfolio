import java.util.Scanner;

public class ElectionTester{
    public static void main(String[] args) {
        Candidate can1 = new Candidate("Patrick Gelsinger", "Intel");
        Candidate can2 = new Candidate("Lisa Su", "AMD");

        System.out.println(can1.getName() + " of " + can1.getParty()+ " has " + can1.getVotes() + " votes.");
        System.out.println(can2.getName() + " of " + can2.getParty()+ " has " + can2.getVotes() + " votes.");

        can1.setParty("Some shitty CPU manufacturer");
        can1.incrementVotes();
        can1.incrementVotes();

        System.out.println(can1.getName() + " of " + can1.getParty()+ " has " + can1.getVotes() + " votes.");

        Election elec1 = new Election();
        Scanner userinput = new Scanner(System.in);
        elec1.runElection(userinput); 
        Election elec2 = new Election();
        elec2.runElection(userinput);
        userinput.close();
    }     
}