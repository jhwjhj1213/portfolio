import java.util.Scanner;

public class Election{
    private Candidate canA;
    private Candidate canB;
    private Candidate canC;
    
    
    public Election() {
        canA = new Candidate("Steve Jobs", "Apple");
        canB = new Candidate("Mark Zuckerberg", "Meta");
        canC = new Candidate("Bill Gates", "Microsoft");
    }

    public void runElection(Scanner scan) {
        Candidate[] canList = new Candidate[3];
        canList[0] = canA;
        canList[1] = canB;
        canList[2] = canC;
        System.out.println("Welcome to the election. We have 3 candidates:");
        System.out.println("1. "+canA.getName()+" from the "+canA.getParty()+" party.");
        System.out.println("2. "+canB.getName()+" from the "+canB.getParty()+" party.");
        System.out.println("3. "+canC.getName()+" from the "+canC.getParty()+" party.");

        System.out.println("Enter a vote (by candidate number). Enter -1 if there are no more votes.");
        int input = scan.nextInt();

        int totalVotes = 0; // a variable that save the total amount of votes

        while(input!=-1) {
            ++totalVotes;
            if(input==1) {
                canA.incrementVotes();
                System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                input = scan.nextInt();
            }
            else if(input==2) {
                canB.incrementVotes();
                System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                input = scan.nextInt();
            }
            else if(input==3) {
                canC.incrementVotes();
                System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                input = scan.nextInt();
            }
            else {
                System.out.println("That candidate does not exist. Please enter a different number.");
                input = scan.nextInt();
            }
        }











        Candidate firstPlace = canList[0];
        Candidate lastPlace = canList[0];
        Candidate secondPlace = canList[0];
        for(int i=0; i<canList.length; ++i){
            if(canList[i].getVotes() >= firstPlace.getVotes()){
                secondPlace = firstPlace;
                firstPlace = canList[i];
            }
            if(canList[i].getVotes() < lastPlace.getVotes()){
                lastPlace = canList[i];
            }
        }
        // stores Candidates in order of votes


        int awinsOver = 0;
        int bwinsOver = 0;
        int cwinsOver = 0;
        for(Candidate currCan : canList){
            if(currCan.getVotes()<canA.getVotes()){
                ++awinsOver;
            }
            if(currCan.getVotes()<canB.getVotes()){
                ++bwinsOver;
            }
            if(currCan.getVotes()<canC.getVotes()){
                ++cwinsOver;
            }
        }
        /* through this mechanism, we are able to tell if there is a draw, and if so who the candidates drawed are.  */
        













    /*Results and Runoff*/

        /*winner exists*/

        if(firstPlace.getVotes() > totalVotes/2){
            System.out.println(firstPlace.getName()+" of the "+firstPlace.getParty()+" party wins the vote!"); // Vote ends
        }

        /*need runoff vote*/


        else if(awinsOver==1||bwinsOver==1||cwinsOver==1){
            System.out.println("We need a runoff vote between the top two candidates!"); // Runoff between top 2
            firstPlace.resetVotes();
            secondPlace.resetVotes();
            System.out.println("Welcome to the runoff vote between "+firstPlace.getName()+" and "+secondPlace.getName()+"!");
            System.out.println("1. "+firstPlace.getName()+" from the "+firstPlace.getParty()+" party.");
            System.out.println("2. "+secondPlace.getName()+" from the "+secondPlace.getParty()+" party.");
            System.out.println("Enter a vote (by candidate number). Enter -1 if there are no more votes.");
            input = scan.nextInt();
            while(input!=-1) {
                if(input==1) {
                    firstPlace.incrementVotes();
                    System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                    input = scan.nextInt();
                }
                else if(input==2) {
                    secondPlace.incrementVotes();
                    System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                    input = scan.nextInt();
                }
                else {
                    System.out.println("That candidate does not exist. Please enter a different number.");
                    input = scan.nextInt();
                }
            }
            if(firstPlace.getVotes() > secondPlace.getVotes()){
                System.out.println(firstPlace.getName()+" wins the vote!");
            }
            else if(firstPlace.getVotes() < secondPlace.getVotes()){
                System.out.println(secondPlace.getName()+" wins the vote!");
            }
            else{
                System.out.println("The result is a tie between "+firstPlace.getName()+" and "+secondPlace.getName());
            }
        }


        else{
            System.out.println("We need a runoff vote between all 3 candidates!"); // Runoff between all 3
            canA.resetVotes();
            canB.resetVotes();
            canC.resetVotes();
            System.out.println("Welcome to the runoff election. We have 3 candidates:");
            System.out.println("1. "+canA.getName()+" from the "+canA.getParty()+" party.");
            System.out.println("2. "+canB.getName()+" from the "+canB.getParty()+" party.");
            System.out.println("3. "+canC.getName()+" from the "+canC.getParty()+" party.");
            System.out.println("Enter a vote (by candidate number). Enter -1 if there are no more votes.");
            input = scan.nextInt();
            while(input!=-1) {
                if(input==1) {
                canA.incrementVotes();
                System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                input = scan.nextInt();
                }
                else if(input==2) {
                canB.incrementVotes();
                System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                input = scan.nextInt();
                }
                else if(input==3) {
                canC.incrementVotes();
                System.out.println("Enter the next vote (by candidate number). Enter -1 if there are no more votes.");
                input = scan.nextInt();
                }
                else {
                System.out.println("That candidate does not exist. Please enter a different number.");
                input = scan.nextInt();
                }
            }

            Candidate[] runoffList = new Candidate[3];
            runoffList[0] = canA;
            runoffList[1] = canB;
            runoffList[2] = canC;
            firstPlace = canList[0];
            lastPlace = canList[0];
            secondPlace = canList[0];
            for(int i=0; i<canList.length; ++i){
                if(canList[i].getVotes() > firstPlace.getVotes()){
                    firstPlace = canList[i];
                }
                if(canList[i].getVotes() <= lastPlace.getVotes()){
                    secondPlace = lastPlace;
                    lastPlace = canList[i];
                }
            }

            if(firstPlace.getVotes() > secondPlace.getVotes()){
                System.out.println(firstPlace.getName()+" wins the vote!");
            }
            else if(firstPlace.getVotes() == lastPlace.getVotes()){
                System.out.println("The result is a tie between all three candidates!");
            }
            else{
                System.out.println("The result is a tie between "+firstPlace.getName()+" and "+secondPlace.getName());
            }
        }
    }
}