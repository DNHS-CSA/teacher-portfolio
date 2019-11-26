package AP_Exam;

import java.util.Random;

/**
 * Write a description of class MathOps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class BinaryMathQuestions extends Question
{
	private char[] operators = {'&', '|', '+', '-'};

    /**
     * Constructor for objects of class MathQuestions
     */
    public BinaryMathQuestions()
    {
    	Random rand = new Random();
    	Integer arg1 = rand.nextInt(16)+1;
    	Integer arg2 = rand.nextInt(8)+1;
    	Integer opIndex = rand.nextInt(operators.length);
    	setupQuestion(arg1, operators[opIndex], arg2);
    }
    
    public static String mainTest ()
    {
    	Question q = new BinaryMathQuestions();
        q.askQuestionConsole();
        return q.getCounterMsg();
    }
    
    /**
     * askBinaryMath 
     *
     * @param  arg1      1st argument in math expression (6 bits)
     * @param  operator  operator in math expression (&, |, +, or - only)
     * @param  arg2      2st argument in math expression (5 bits)
     * @return    error code
     */
	@Override
    public void setupQuestion(int arg1, char operator, int arg2)
    {
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
                this.answerKey = this.answerA;
                break;
            case '|':
                answerCalc = arg1 | arg2;
                this.answerKey = this.answerB;
                break;
             case '+':
                answerCalc = arg1 + arg2;
                if (answerCalc > 15) binaryLength++;
                this.answerKey = this.answerC;
                break; 
             case '-':
                answerCalc = arg1 - arg2;
                this.answerKey = this.answerD;
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
     * zeroPadInt2BinaryString 
     *
     * @param  arg1             number to convert to binary
     * @param  binaryLength     number of bits for number (ie 4 bits)
     * @return    the binary String with leading 0s
     */
    String zeroPadInt2BinaryString(int arg, int binaryLength)
    {
        return Integer.toBinaryString( (1 << binaryLength) | arg ).substring(1);
    }
    
}