// TODO: Add the appropriate file header comment here.


// TODO: Add the appropriate class header comment here.
public class DataPoint {
    // The number and races represented in this data point.  DO NOT CHANGE.
    public int numRaces = 8;
    private String[] races = {"White", "Black", "LatinX", "Asian", "AIAN",
                              "NHPI", "Multiracial", "Other"};
    
    //todo              
    private String date;
    private String state;
    private int totalCases;
    private int[] casesByRace;

    // TODO: Add comment and implement
    public DataPoint(String dateIn, String stateIn, int totalCasesIn,
                     int[] casesByRaceIn)
    {
        this.date = dateIn;
        this.state = stateIn;
        this.totalCases = totalCasesIn;
        this.casesByRace = casesByRaceIn;
        // TODO
     }

    // TODO: Add comment and implement.
    public String getDate() {
        // TODO: change the line below
        return date;
    }

    // TODO: Add comment and implement.
    public String getState() {
        // TODO: change the line below
        return state;
    }

    // TODO: Add comment and implement.
    public int getCasesByRace(int raceIndex) {
        // TODO: Change the line below and add more code.
        return casesByRace[raceIndex];                              // wouldn't this work?
    }

    // TODO: Add comment and implement.
    public int getTotalCases() {
        // TODO: Change the line below
        return totalCases;
    }

    /**
    * Return the race name associated with the given index in this data point.
    * Preconditions: index is between 0 (inclusive) and numRaces (8) (exclusive)
    *
    * DO NOT CHANGE.
    *
    * @param index The index of the race.
    * @return The name of the race (e.g. "White" or "LatinX")
    */
    public String getRaceName(int index)
    {
        return this.races[index];
    }
}
