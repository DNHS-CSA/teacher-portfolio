package AP_Exam;

import java.util.Random;

/**
 * Write a description of class MathOps here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class DataTypeQuestions extends Question
{
	private String[] datatype = {"int", "float", "char"};
	private int[] multiplier = {10, 100, 1000};

	/**
     * Constructor for objects of class MathQuestions
     */
    public DataTypeQuestions()
    {
    	Random rand = new Random();
    	double value = rand.nextDouble() * multiplier[rand.nextInt(multiplier.length)];
    	Integer index = rand.nextInt(datatype.length);
    	setupQuestion(datatype[index], value);
    }
    
    public static String mainTest ()
    {
    	Question q = new DataTypeQuestions();
        q.askQuestion();
        return q.getCounterMsg();
    }
     
    /**
     * askDataTypeConversion 
     *
     * @param  datatype     datatype of reference
     * @param  number       number in conversion
     * @return    error code
     */
	@Override
    public void setupQuestion(String dataTypeName, double number)
    {        
        float test1 = (float)number;
        int test2 =  (int)number;
        char test3 =  Double.toString(number).charAt(0);
        double test4 = (double)number;
        
        // format question
        this.question = String.format(
            "Which represents double " +
            number +
            " conversion to a " +
            dataTypeName +
            " datatype?");
                    
        // format question choices
        this.choiceA = String.format
            ("(float)%f",
            number);
        this.choiceB = String.format
            ("(int)%f",
            number);
        this.choiceC = String.format
            ("Double.toString(%f).charAt(0)",
            number);
        this.choiceD = String.format
            ("(double)%f",
            number);
        this.choiceE = "All of the above";
        
        // real time calc answer based off args AND operator
        String strEquation, strResult;
        if (dataTypeName == "float")
        {
            strEquation = this.choiceA;
            strResult = String.format("%f",test1);
            this.answerKey = this.answerA;
        } else if ( dataTypeName == "int" ) {
            strEquation = this.choiceB;
            strResult = String.format("%d",test2);
            this.answerKey = this.answerB;
        } else if ( dataTypeName == "char" ) {
            strEquation = this.choiceC;
            strResult = String.format("%c",test3);
            this.answerKey = this.answerC;
        } else if ( dataTypeName == "double" ) {
            strEquation = this.choiceD;
            strResult = String.format("%f",test4);
            this.answerKey = this.answerD;
        } else {
            strEquation = this.choiceD;
            strResult = "None";
            this.answerKey = this.answerE;
        }
            
        
        // format question answer based off of operation calculation
        this.answer =  String.format
            (strEquation +
            " equals " +
            "("+dataTypeName+")" +
            strResult);          // answer
        
    }
}