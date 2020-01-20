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
	private int ID;		// Used to store question number (unique ID)
	
	// ever question should have these elements
	protected String question, answer;	// Question and Answer
	protected char answerKey;			// Answer to question
	
	// scoring for questions
	private static int totalCorrect = 0;  	// class variable for total correct answers
    private static int totalQuestions = 0;	// class variable for toal questions attempted
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
     * Question ID setter, used for question number on and exam
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
     * setup question requirement (should be generalized for MC or TF)
     * 
     * @param  void
     */
     protected abstract void setupQuestion();

 
     /**
      * setup question data requirement (specific to question type: Math, DataTypes, etc)
      *
      * @param  void
      */
    protected abstract void setupQuestionData();
        
	
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
     * Answer getter with formatting to provide answerKey
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
     * Console support for asking question, getting result, and calculating results
     *     
     * @param  void
     */
    public abstract void askQuestionConsole();
    
    
    /**
     * Sensible output
     *
     * @param  void
     */
    public abstract String toString();
    
    
    /**
     * An example of a method - replace this comment with your own
     *
      * @param  void
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
     * @param  void
     */
    public void printCounters()
    {
        System.out.println(this.getCounterMsg());
    }
 
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  void
     */
    public String getCounterMsg()
    {
        return new String("Results: " + this.correct + " of " + this.questions);
    }

    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  void
     */
    public static String getCounterTotalMsg()
    {
        return new String("Totals:  " + Question.totalCorrect + " of " + Question.totalQuestions);
    }

}
