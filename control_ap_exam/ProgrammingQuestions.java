
package control_ap_exam;

import java.util.Random;

import model_questions.Question;
import model_questions.QuestionTF;
import util.ConsoleMethods;

/**
 * Class to support divide and modulo Math questions.
 *
 * @author (John Mortensen)
 * @version (1.0)
 */
public class ProgrammingQuestions extends QuestionTF
{ 
	
    /**
     * Constructor for objects of class MathQuestions
     * 
     * @param  void
     */
    public ProgrammingQuestions()
    {	    	
    	// This outputs constructor being run
        ConsoleMethods.println("ProgLangQuestions Constructor");
    }
    
    /**
     * Sets up a Math question according to instance variables (this...) in Question class
     *
     * @return void
     */
    protected void setupQuestionData()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("ProgLangQuestions setupQuestionData()");
        
        this.question = String.format("A linked list is resides in contiguous memory?" );
        this.answer = "A linked list points to objects in non-continguous memory.";
        this.answerKey = charFalse;
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
    
    /**
     * MainTest supports console execution and receiving write or wrong return message
     * 
     * @param  void
     * @return score / right or wrong
     */
    public static String mainTest()
    {
    	Question q = new ProgrammingQuestions();
        q.askQuestionConsole();
        return q.getCounterMsg();
    }
}
