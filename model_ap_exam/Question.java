package model_ap_exam;

import util.ConsoleMethods;

/**
 * Question class is intended to support asking question on test
 *
 * @author (John Mortensen)
 * @version (1.0)
 */
public class Question extends Scoring
{
	// question setup values
	protected String question, choiceA, choiceB, choiceC, choiceD, choiceE, answer;
	protected char answerKey;
    
    // internal control values, these are never change
    protected final char charA = 'A', charB = 'B', charC = 'C', charD = 'D', charE = 'E'; 	// Multiple choice default letters
	protected final char[] answers = {charA, charB, charC, charD, charE};					// Multiple choice default order
   	protected int aOffset = 0, bOffset = 1, cOffset = 2, dOffset = 3, eOffset = 4;			// Multiple choice index value
    
    // defaults for choice
   	protected int choiceOffset = 0;						// choiceOffset is used when scrambled to move answers around
    protected boolean choiceEfixed = true;				// used to keep choice E fixed versus randomization
	protected String[] choices = {"", "", "", "", ""};

    
    /**
     * Constructor for objects of class Question
     * 
     * @param  void
     */
    public Question()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class constructor");
        
        // turn scrambled off for backward compatibility
        choiceOffset = 0;
        choiceEfixed = true;  
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
    	choices[aOffset] = choiceA;
    	choices[bOffset] = choiceB;
    	choices[cOffset] = choiceC;
    	choices[dOffset] = choiceD;
    	choices[eOffset] = choiceE;   	
    }
 
     /**
      * setup question data default, expectation is this will changed through polymorphism
      *
      * @param  void
      */
    protected void setupQuestionData() {
    	// This outputs constructor being run
        ConsoleMethods.println("Question class setupQuestionData method");
        
    	question = "What type of programming language is Java?";
		choiceA = "Data-oriented";
		choiceB = "Iterative";
		choiceC = "Object-oriented";
		choiceD = "Imperative";
		answer = choiceC;
		answerKey = charC;
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
	public String getChoices() {
		return String.format(
            charA + ": " + choices[0] + "\n"  + 
    	    charB + ": " + choices[1] + "\n"  + 
    	    charC + ": " + choices[2] + "\n"  + 
    	    charD + ": " + choices[3] + "\n"  + 
    	    charE + ": " + choices[4] + "\n"
            );    
	}
	
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
    protected void  askQuestionConsole()
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
            if (choice >= charA && choice <= charE) break;
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
    	String s = getQuestion() + "\n" + getChoices() + "\nAnswer: " + getAnswer() + "\n\n";
    	return s;
    }
  
}
