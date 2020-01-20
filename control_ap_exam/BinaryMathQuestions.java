package control_ap_exam;

import java.util.Random;

import model_questions.Question;
import model_questions.QuestionMC;
import util.ConsoleMethods;

/**
 * Class to support Binary Math operations
 * 
 * @author (John Mortensen)
 * @version (1.0)
 */
public class BinaryMathQuestions extends QuestionMC
{

	/**
     * Constructor for objects of class BinaryMathQuestions
     * 
     * @param  void
     */
    public BinaryMathQuestions()
    {   
    	// This outputs constructor being run
        ConsoleMethods.println("BinaryMathQuestions Constructor");
    }
    
    /**
     * Sets up a Binary Math questions according to instance variables (this...) in Question class
     *
     * @return    void
     */
    @Override
    protected void setupQuestionData()
    {
    	// This outputs constructor being run
        ConsoleMethods.println("BinaryMathQuestions setupQuestionData()");
        
    	char[] operators = {'&', '|', '+', '-'};

    	// Logic to setup data for Binary Math questions
    	Random rand = new Random();
    	Integer arg1 = rand.nextInt(16)+1;
    	Integer arg2 = rand.nextInt(8)+1;
    	Integer opIndex = rand.nextInt(operators.length);
    	char operator = operators[opIndex];
    	
        // maximum binary number for testing is 15, we need to be reasonable
        int binaryLength = 7;       
        //if (arg1 > 15 || arg2 > 15) return;       // exit if number above 15
        
        // Turn math arguments (numbers) to binary strings
        String carg1 = zeroPadInt2BinaryString(arg1,binaryLength);
        String carg2 = zeroPadInt2BinaryString(arg2,binaryLength);
        
        // format question
        this.question = String.format("Calculate binary result of: " + carg1 + " " + "%s" + " " + carg2, operator );
        
        // format question choices
        this.choiceA = zeroPadInt2BinaryString(arg1 & arg2,binaryLength);
        this.choiceB = zeroPadInt2BinaryString(arg1 | arg2,binaryLength);
        this.choiceC = zeroPadInt2BinaryString(arg1 + arg2,binaryLength);
        this.choiceD = zeroPadInt2BinaryString(arg1 - arg2,binaryLength);
        this.choiceE = "Null";
        
        // real time calc answer based off args AND operator
        int answerCalc;
        switch(operator)
        {
            case '&':
                answerCalc = arg1 & arg2;
                this.answerKey = this.charA;
                break;
            case '|':
                answerCalc = arg1 | arg2;
                this.answerKey = this.charB;
                break;
             case '+':
                answerCalc = arg1 + arg2;
                if (answerCalc > 15) binaryLength++;
                this.answerKey = this.charC;
                break; 
             case '-':
                answerCalc = arg1 - arg2;
                this.answerKey = this.charD;
                break;
            default:
                return;
        }
        
        // format question answer based off of operation calculation
        String answerString = zeroPadInt2BinaryString(answerCalc,binaryLength);
        this.answer =  String.format(
            carg1 +         // arg1
            " " +
            "%s" +          // operator
            " " +
            carg2 +         // arg2
            " = " + 
            answerString    // answer
            ,operator);     // operator parameter, % requires it (may be hidden feature :)
    }
    
    /**
     * Zero pad binary number to supplied binary length 
     *
     * @param  arg1             number to convert to binary
     * @param  binaryLength     number of bits for number (ie 4 bits)
     * @return    the binary String with leading 0s
     */
    private String zeroPadInt2BinaryString(int arg, int binaryLength)
    {
        return Integer.toBinaryString( (1 << binaryLength) | arg ).substring(1);
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
    public static String mainTest ()
    {
    	Question q = new BinaryMathQuestions();
        q.askQuestionConsole();
        return q.getCounterMsg();
    }
    
    
}