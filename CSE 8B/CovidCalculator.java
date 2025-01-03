// TODO: Add the appropriate file header comment

// TODO: Add the appropriate class header comment
class CovidCalculator {
    private DataPoint[] points;  // The data points to use in the calculations

    // TODO: add comment and implement method.
    public CovidCalculator(DataPoint[] input)
    {
        // TODO: Remove the line below and implement this method so that
        // it makes a new array for points and copies the entries from input
        // into points.
        points = new DataPoint[input.length];
        for(int i=0; i<input.length-1; ++i){
            points[i]=input[i];
        }
        //this.points = input;  // This is WRONG.
    }

    // TODO: Add comment and implement method.
    public double findAverageCases(String date)
    {
        // TODO: Remove line below and implement method.
        double tempTotalCases=0;
        int countDates=0;
        double avgCases=0;
        for(int i=0; i<points.length-1;++i){
            if(points[i].getDate().equals(date)){
                tempTotalCases=tempTotalCases+points[i].getTotalCases();
                countDates++;
            }
        }
        if(countDates!=0){
            avgCases = tempTotalCases/countDates;
        }
        return avgCases;
    }

    // TODO: Add comment and implement method.
    public String findRaceWithHighestCases(String date, String state)
    {
        // TODO: Remove line below and implement method.
        DataPoint tempDataPoint = null;
        for(int i=0; i<points.length-1;++i){
            if(date.equals(points[i].getDate()) && state.equals(points[i].getState())){
                tempDataPoint = points[i];
            }
        }
        int mostCasesinRace = -1;
        String racewithMostCases = null;
        for(int i=0; i<7; i++){
            if(tempDataPoint.getCasesByRace(i)>mostCasesinRace){
                mostCasesinRace = tempDataPoint.getCasesByRace(i);
                racewithMostCases = tempDataPoint.getRaceName(i);
            }
        }
        return racewithMostCases;
    }

    // TODO: Add method myStat here (with comments)
    // myStat: finds the largest number of cases within a single race on a given date
    public int myStat(String date, String state){
        DataPoint tempDataPoint = null;
        for(int i=0; i<points.length-1;++i){
            if(date.equals(points[i].getDate()) && state.equals(points[i].getState())){
                tempDataPoint = points[i];
            }
        }
        int mostCasesinRace = -1;
        for(int i=0; i<7; i++){
            if(tempDataPoint.getCasesByRace(i)>mostCasesinRace){
                mostCasesinRace = tempDataPoint.getCasesByRace(i);
            }
        }
        return mostCasesinRace;
    }


}
