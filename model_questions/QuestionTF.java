package model_questions;

import util.ConsoleMethods;

public class QuestionTF extends Question {
  
    // internal control values, these are never change
    protected final char charTrue = 'T', charFalse = 'F'; 			// True False default letters
	protected final char[] answers = {charTrue, charFalse};		// Multiple choice default order
    
    // defaults for choice
	protected String[] choices = {"", ""};

    
    /**
     * Constructor for objects of class Question
     * 
     * @param  void
     */
    public QuestionTF()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("Question TF class constructor"); 
        
        setupQuestion();
    }
    
      
    /**
     * setup question choices and answer
     * 
     * @param  void
     */
    @Override
    protected void setupQuestion() {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class setupQuestion method");
        
    	setupQuestionData();	
    }
	
     /**
      * Sets up a  question according to instance variables in class
      *
      * @return void
      */
     @Override
     protected void setupQuestionData()
     {
     	// This outputs constructor being run
         ConsoleMethods.println("ProgLangQuestions setupQuestionData()");
         
         this.question = String.format("A linked list is resides in contiguous memory?" );
         this.answer = "A linked list points to objects in non-continguous memory.";
         this.answerKey = charFalse;
     }
	
	/**
     * Choices getter for True False
     *
     * @param  void
     * @return String 	content of choices with TF formatting
     */
    @Override
 	public String getChoices() {
    	 return String.format(
            charTrue + ": " + true + "\n"  + 
    	    charFalse + ": " + false + "\n"
            );    
	}
    
    /**
     * Sensible output
     *
     * @param  void
     */
    @Override
    public String toString()
    {
    	String s = getID() + ". " + getQuestion() + "\n" + getChoices() + "\nAnswer: " + getAnswer() + "\n\n";
    	return s;
    }
    
	/**
     * Console support wrapper for asking question, getting result, and calculating results
     *
     * @param  void
     * @return void
     */
    public void  askQuestionConsole()
    {
        // getAnswer return true if question is correct
        updateCounters ( getAnswerConsole() );
    }
    
    /**
     * Console support for asking question and getting result
     *
     * @param  void
     * @return void
     */
    private boolean getAnswerConsole()
    {
        char choice;
        
        // Implement this to randomize order
        ConsoleMethods.println(getQuestion());
        ConsoleMethods.println(getChoices());
        
        // IO logic of getting answer from console
        do {
            choice = ConsoleMethods.inputChar("Enter selection (" + charTrue + " or " + charFalse + ") --> ");
            choice = Character.toUpperCase(choice); // Convert to upper case
            if (choice == charTrue || choice == charFalse) break;
            ConsoleMethods.println(" (invalid) ");
        } while ( true );                                               // until valid input
        
        if (choice == answerKey) ConsoleMethods.print("(correct) ");
        else ConsoleMethods.print("(missed it!) ");
        ConsoleMethods.println(answer);
        ConsoleMethods.println();
        
        /*Boolean ansStatus = (choice == answerKey);
        calcResult(ansStatus)
        return ansStatus;*/
        return (choice == answerKey);
    }
    
    /**
     * MainTest supports console execution and receiving write or wrong return message
     * 
     * @param  void
     * @return score / right or wrong
     */
    public static String mainTest()
    {
    	Question q = new QuestionTF();
        q.askQuestionConsole();
        return q.getCounterMsg();
    }
 
    
    /**
     * Main test method to support console execution
     * 
     * @param  args		// satisfies default for Java
     * @return void
     */
    public static void main(String[] args)
    {
    	ConsoleMethods.println(mainTest());
    }

  
}
