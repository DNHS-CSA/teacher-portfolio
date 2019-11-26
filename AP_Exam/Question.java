package AP_Exam;

import Util.ConsoleMethods;

/**
 * Question object is intended to ask operator questions and randomize order
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Question extends Scoring
{
    // instance variables - replace the example below with your own
    String question, choiceA, choiceB, choiceC, choiceD, choiceE;
    String answer;
    
    char answerA='A', answerB='B', answerC='C', answerD='D', answerE='E';
    char answerKey;
    
    /**
     * setupQuestion arg1, operator, arg2
     */
    public void setupQuestion(int arg1, char operator, int arg2) {
		// TODO Auto-generated method stub
		
	}
    
    /**
     * setupQuestion dataType and number
     */
	public void setupQuestion(String dataTypeName, double number) {
		// TODO Auto-generated method stub
		
	}
	
	public String getQuestion() {
		return question;
	}
	
	public String getChoices() {
		return String.format(
	            "A. "+ choiceA + "\n"  + 
	    	    "B. "+ choiceB + "\n"  + 
	    	    "C. "+ choiceC + "\n"  + 
	    	    "D. "+ choiceD + "\n"  + 
	    	    "E. "+ choiceE + "\n" 
	            );     
	}
	
	public String getAnswer() {
		return answerKey + ": " + answer;
	}
    
	/**
     * Console Display methods
     *
     */
    public void  askQuestionConsole()
    {
        // getAnswer return true if question is correct
        updateCounters ( getAnswerConsole() );
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
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
            if (choice >= 'A' && choice <= 'E') break;
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
  
}
