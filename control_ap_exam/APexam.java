package control_ap_exam;

import model_ap_exam.Question;
import model_linkedlists.Queue;
import util.ConsoleMethods;;

/**
 *  Establish  a set of random questions.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class APexam {

  private Queue exam;
  private int size = 20;	// size of test
  private boolean init = true;

  public APexam()
  {
	  exam = new Queue();
	  createTest();
  }

  /**
   *  Creates a series of user defined objects and populates on Stack,
   *  any type of object can be used,
   *  stack pushes and operations are displayed to console
   */
  public void createTest()
  {	
	  	Question q;

	  	// pushing data to stack with console output
	  	for (int i = 0; i <= size-1; i++)
		{
	  		if ((double)i < (double)(size / 3))
	  			q = new control_ap_exam.MathQuestions();
	  		else if ((double)i < (double)(2 * (size / 3) ))
	  			q = new control_ap_exam.DataTypeQuestions();
	  		else
	  			q = new control_ap_exam.BinaryMathQuestions();
	  		
	  		q.setID(i+1);
  			exam.add(q);
		}
	  	
  }
  
  /**
   *  Removes all the user defined objects from Stack,
   *  this is inverse of createStack,
   *  stack pops and values are displayed to console 
   */
  public void emptyTest()
  {
	  	// popping data off stack with console output
	  	for (int i = 0; i <= size; i++)
	  	{
	  		exam.delete();
	  	}
  }

  /**
   *  Display the top element of the list and full stack
   */
  public void displayTest()
  {
    ConsoleMethods.println("First Element: " + exam.getFirstValue() );
    ConsoleMethods.println("Last Element: " + exam.getLastValue() );
    ConsoleMethods.println("Full Queue: " + exam);
  }
  
  /**
   *  Get current test question and advance pointer
   */
  public Question getQuestionFwd()
  {
	  Question q;	// put object back into Question type

	  if (init) {
		  q = (Question)exam.getFirstValue();
		  init = false;
	  } else {
		  exam.setNext();
		  q = (Question)exam.getValue();
	  }
	  
	  return q;	
  }
  
  /**
   *  Get current test question and advance pointer
   */
  public Question getQuestionRev()
  {
	  Question q;	// put object back into Question type

	  if (init) {
		  q = (Question)exam.getLastValue();
		  init = false;
	  } else {
		  exam.setPrevious();
		  q = (Question)exam.getValue();
	  }
	  
	  return q;	
  }


  /**
   *  Demonstrates the use of the LinkedList used as storing questions.
   *
   * @param  args  The command line arguments (not used)
   */
  public static void main(String[] args)
  {
    APexam exam = new APexam();

    exam.displayTest();
    exam.emptyTest();
  }
}

