
package control_ap_exam;

import java.util.Random;

import model_questions.Question;
import model_questions.QuestionMC;
import util.ConsoleMethods;

/**
 * Class to support divide and modulo Math questions.
 *
 * @author (John Mortensen)
 * @version (1.0)
 */
public class MathQuestions extends QuestionMC
{ 
	
    /**
     * Constructor for objects of class MathQuestions
     * 
     * @param  void
     */
    public MathQuestions()
    {	    	
    	// This outputs constructor being run
        ConsoleMethods.println("MathQuestions Constructor");
    }
    
    /**
     * Sets up a Math question according to instance variables (this...) in Question class
     *
     * @return void
     */
    @Override
    protected void setupQuestionData()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("MathQuestions setupQuestionData()");
        
    	char[] operators = {'/', '%'};	// operators supported
        
    	// Logic to setup data for Math questions
    	Random rand = new Random();
    	Integer arg1 = rand.nextInt(50)+1;
    	Integer arg2 = (int)Math.sqrt((double)arg1);
    	Integer opIndex = rand.nextInt(operators.length);
    	char operator = operators[opIndex];
        // format question
        this.question = String.format("What is (int)" + arg1 + " " + "%s" + " (int)" + arg2, operator );
        
        // format question choices
        this.choiceA = String.format("%f",(float)arg1/(float)arg2);
        this.choiceB = String.format("%x",arg1/arg2);
        this.choiceC = String.format("%f",(float)arg1*(float)arg2);
        this.choiceD = String.format("%x",arg1%arg2);
        this.choiceE = "None of the above";
        
        // real time calc answer based off args AND operator
        int answerCalc;
        switch(operator)
        {
            case '/':
                answerCalc = arg1 / arg2;
                this.answerKey = this.charB;
                break;
            case '%':
                answerCalc = arg1 % arg2;
                this.answerKey = this.charD;
                break;
            default: // not supported
                return;
        }
        
        // format question answer based off of operation calculation
        this.answer =  String.format(
            "(int)"+arg1 +          // arg1
            " "+
            "%s"+                   // operator
            " " +        
            "(int)"+ arg2 +         // arg2
            " = " + 
            answerCalc              // answer
            ,operator);             // operator parameter % 
                                    // requires var (may be hidden feature :)        
        
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
    	Question q = new MathQuestions();
        q.askQuestionConsole();
        return q.getCounterMsg();
    }
}
