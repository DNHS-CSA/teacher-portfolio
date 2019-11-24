package AP_Exam;

/**
 * Question object is intended to ask operator questions and randomize order
 *
 * @author (your name)
 * @version (a version number or a date)
 */
abstract class Question extends Scoring
{
    // instance variables - replace the example below with your own
    String question, choiceA, choiceB, choiceC, choiceD, choiceE;
    String answer;
    
    char answerA='A', answerB='B', answerC='C', answerD='D', answerE='E';
    char answerKey;
    
    public void setupQuestion(int arg1, char operator, int arg2) {
		// TODO Auto-generated method stub
		
	}

	public void setupQuestion(String dataTypeName, double number) {
		// TODO Auto-generated method stub
		
	}
    
	/**
     * Required methods
     *
     */
    public void  askQuestion()
    {
        // getAnswer return true if question is correct
        updateCounters ( getAnswer() );
    }
    
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    private boolean getAnswer()
    {
        char choice;
        
        // Implement this to randomize order
        System.out.println(question);
        System.out.println("A. " + choiceA );
        System.out.println("B. " + choiceB );
        System.out.println("C. " + choiceC );
        System.out.println("D. " + choiceD );
        System.out.println("E. " + choiceE );
        
        // IO logic of getting answer from console
        do {
            choice = Keyinput.inChar("Enter selection (A-E) --> ");
            choice = Character.toUpperCase(choice); // Convert to upper case
            if (choice >= 'A' && choice <= 'E') break;
            System.out.println(" (invalid) ");
        } while ( true );                                               // until valid input
        
        if (choice == answerKey) System.out.print("(correct) ");
        else System.out.print("(missed it!) ");
        System.out.println(answer);
        System.out.println();
        
        /*Boolean ansStatus = (choice == answerKey);
        calcResult(ansStatus)
        return ansStatus;*/
        return (choice == answerKey);
    }

	
  
}
