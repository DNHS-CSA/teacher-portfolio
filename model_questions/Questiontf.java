package model_questions;

import util.ConsoleMethods;

public class Questiontf extends Question {

	// question id or number
	private int ID;

	// question setup values
	protected String choiceT, choiceF;
    
    // internal control values, these are never change
    protected final char charT = 'T', charF = 'F'; 			// True False default letters
	protected final char[] answers = {charT, charF};		// Multiple choice default order
    
    // defaults for choice
	protected String[] choices = {"", ""};

    
    /**
     * Constructor for objects of class Question
     * 
     * @param  void
     */
    public Questiontf()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("Question TF class constructor"); 
    }
    
      
    /**
     * setup question choices and answer
     * 
     * @param  void
     */
     protected void setupQuestion() {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class setupQuestion method");
    	setupQuestionData();
        
    	// choice assignment
    	choices[0] = choiceT;
    	choices[1] = choiceF;	
    }
 
     /**
      * setup question data default, expectation is this will changed through polymorphism
      *
      * @param  void
      */
    protected void setupQuestionData() {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class setupQuestionData method");
        
    	question = "A Linked List is a linear data structure?";
		choiceT = "True";
		choiceF = "False";
		
		answer = choiceT;
		answerKey = charT;
    }
	
	
	/**
     * Choices getter for Multiple Choice
     *
     * @param  void
     * @return String 	content of choices with ABCDEF formatting
     */
	public String getChoices() {
		return String.format(
            charT + ": " + choices[0] + "\n"  + 
    	    charF + ": " + choices[1] + "\n"
            );    
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
            choice = ConsoleMethods.inputChar("Enter selection (A-E) --> ");
            choice = Character.toUpperCase(choice); // Convert to upper case
            if (choice == charT || choice == charF) break;
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

    public String toString()
    {
    	String s = getID() + ". " + getQuestion() + "\n" + getChoices() + "\nAnswer: " + getAnswer() + "\n\n";
    	return s;
    }
  
}
