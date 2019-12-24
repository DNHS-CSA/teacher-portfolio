package model.ap_exam;
/**
 * Keeps score
 *
 * @author (John Mortensen)
 * @version (1.0 Eclipse)
 */
public abstract class Scoring
{
    private static int totalCorrect = 0;  // class variables
    private static int totalQuestions = 0;
    
    private int correct;        // correct answers
    private int questions;      // questions attempted
    /**
     * Constructor for objects of class Counting
     */
    public Scoring()
    {
        // Initialize instance variables
        this.correct = 0;
        this.questions = 0;
    }
    
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void updateCounters(Boolean isCorrect)
    {
        if (isCorrect)
        {
            this.correct++;
            Scoring.totalCorrect++;
        }
        questions++;
        totalQuestions++;
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public void printCounters()
    {
        System.out.println(this.getCounterMsg());
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public String getCounterMsg()
    {
        return new String("Results: " + this.correct + " of " + this.questions);
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public static String getCounterTotalMsg()
    {
        return new String("Totals:  " + Scoring.totalCorrect + " of " + Scoring.totalQuestions);
    }

}
