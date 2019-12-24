package ap_exam;

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
        q.askQuestionConsole();
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
            String.format
             ("%.8f",
              number) +
            " conversion to a " +
            dataTypeName +
            "?");
                    
        // format question choices and calc answer
        this.choiceA = String.format
            ("(float)%.8f equals %f",
            number, (float)number);
        this.choiceB = String.format
            ("(int)%.8f equals %d",
            number, (int)number);
        this.choiceC = String.format
            ("Double.toString(%f).charAt(0) equals %c",
            number, Double.toString(number).charAt(0));
        this.choiceD = String.format
            ("(double)%.8f equals %.8f",
            number, number);
        this.choiceE = "All of the above";
        
        if (dataTypeName == "float")
        {
            answer = this.choiceA;
            this.answerKey = this.answerA;
        } else if ( dataTypeName == "int" ) {
            answer = this.choiceB;
            this.answerKey = this.answerB;
        } else if ( dataTypeName == "char" ) {
            answer = this.choiceC;
            this.answerKey = this.answerC;
        } else if ( dataTypeName == "double" ) {
            answer = this.choiceD;
            this.answerKey = this.answerD;
        } else {
            answer = this.choiceE;
            this.answerKey = this.answerE;
        }
        
    }
}