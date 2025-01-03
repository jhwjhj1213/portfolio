public class Candidate{
    private String name;
    private String party;
    private int voteCount;

    public Candidate(String candidateName, String candidateParty) {
        this.name = candidateName;
        this.party = candidateParty; 
        this.voteCount = 0;
    }

    public String getName() {
        return name;
    }
    public String getParty() {
        return party;
    }
    public int getVotes() {
        return voteCount;
    }

    public void setParty(String newParty) {
        this.party = newParty;
    }
    public void incrementVotes() {
        voteCount += 1;
    }

    public void resetVotes() {
        voteCount = 0;
    }

    /*
    public void printData() {
        System.out.println(name + " of " + party + " has " + voteCount + " votes.");
    } */
}