package model_questions;

import util.ConsoleMethods;

/**
 * Question class is intended to support asking question on test
 *
 * @author (John Mortensen)
 * @version (1.0)
 */
public abstract class Question
{
	// question id or number
	private int ID;
	protected String question, answer;
	protected char answerKey;
	private static int totalCorrect = 0;  // class variables
    private static int totalQuestions = 0;
    
    private int correct;        // correct answers
    private int questions;      // questions attempted
    
    /**
     * Constructor for objects of class Question
     * 
     * @param  void
     */
    public Question()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class constructor");

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
            Question.totalCorrect++;
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
        return new String("Totals:  " + Question.totalCorrect + " of " + Question.totalQuestions);
    }
	     
    /**
     * setup question choices and answer
     * 
     * @param  void
     */
     protected abstract void setupQuestion();

 
     /**
      * setup question data default, expectation is this will changed through polymorphism
      *
      * @param  void
      */
    protected abstract void setupQuestionData();
        
    	
    /**
     * Question ID setter
     *
     * @param  id
     * @return void
     */
	public void setID(int id) {
		this.ID = id;
	}
	
	/**
     * Question ID getter
     *
     * @param  void
     * @return ID
     */
	public int getID() {
		return ID;
	}
	
	/**
     * Question getter
     *
     * @param  void
     * @return String	contents of question
     */
	public String getQuestion() {
		return question;
	}
	
	/**
     * Choices getter for Multiple Choice
     *
     * @param  void
     * @return String 	content of choices with ABCDEF formatting
     */
	public abstract String getChoices();
	
	/**
     * Answer getter with formatting to correspond to getChoices
     *
     * @param  void
     * @return String 	correct answer with letter prefex of right answer (A or B or C...)
     */
	public String getAnswer() {	
		
		// This outputs randomization of letters
    	ConsoleMethods.println("Answer:" + answerKey);
		
		return answerKey + ": " + answer;
	}
    
	/**
     * Console support wrapper for asking question, getting result, and calculating results
     *
     * @param  void
     * @return void
     */
    public abstract void askQuestionConsole();
    

    /**
     * Sensible output
     *
     */
    public abstract String toString();

  
}
