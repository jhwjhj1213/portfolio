import javax.swing.plaf.nimbus.NimbusLookAndFeel;


/**
 * RedditDataPoint class
 * @author: Your Name
 * Date: 
 */

public class RedditDataPoint {

    private String name = "";
    private String text = "";
    private double lex_liwc_i = 0.0;
    private double lex_liwc_we = 0.0;
    private double lex_liwc_shehe = 0.0;
    
    /*
     * Constructor for a Reddit Datapoint object
     */
    public RedditDataPoint(String name, String text, double lex_liwc_i, double lex_liwc_we, double lex_liwc_shehe) {
        this.name=name;
        this.text=text;
        this.lex_liwc_i=lex_liwc_i;
        this.lex_liwc_we=lex_liwc_we;
        this.lex_liwc_shehe=lex_liwc_shehe;
    }

    /*
     * Return name
     */
    public String getName(){
        return this.name; // Change this value to return the correct value
    }

    /*
     * Return text
     */
    public String getText(){
        return this.text; // Change this value to return the correct value
    }

    /*
     * Return number of Is
     */
    public double getLexLiwcI() {
        return this.lex_liwc_i; // Change this value to return the correct value
    }

    /*
     * Return number of wes
     */
    public double getLexLiwcWe() {
        return this.lex_liwc_we; // Change this value to return the correct value
    }

    /*
     * Return number of he/shes
     */
    public double getLexLiwcShehe() {
        return this.lex_liwc_shehe; // Change this value to return the correct values
    }
}