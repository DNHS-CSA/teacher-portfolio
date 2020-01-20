package control_ap_exam;

import model_linkedlists.CircleQueue;
import model_questions.Question;
import util.ConsoleMethods;;

/**
 *  Establish  a set of random questions.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class APexam {

  private CircleQueue exam;
  private int size = 4;	// size of test
  private int questionTypes = 4;	// randomization
  private boolean init = true;

  /**
   *  APexam with default amount of questions
   */ 
  public APexam()
  {
	  init();
  }

  /**
   *  APexam with custom amount of questions
   */
  public APexam(int size)
  {
	  this.size = size;
	  init();
  }
  
  /**
   *  Constructor helper
   */
  private void init()
  {
	  exam = new CircleQueue();
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
	  		switch((i)%questionTypes) {
	  			case 0:
	  				q = new control_ap_exam.MathQuestions();
	  				break;
	  			case 1:
	  				q = new control_ap_exam.DataTypeQuestions();
	  				break;
	  			case 2:
	  				q = new control_ap_exam.BinaryMathQuestions();
	  				break;
  				default:
  					q = new control_ap_exam.ProgrammingQuestions();
	  		}
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
    ConsoleMethods.println("First Element: " + exam.getFirstObject() );
    ConsoleMethods.println("Last Element: " + exam.getLastObject() );
    ConsoleMethods.println("Full Queue: " + exam);
  }
  
  /**
   *  Get current test question and advance pointer
   */
  public Question getQuestionFwd()
  {
	  Question q;	// put object back into Question type

	  if (init) {
		  q = (Question)exam.getFirstObject();
		  init = false;
	  } else {
		  exam.setNext();
		  q = (Question)exam.getObject();
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
		  q = (Question)exam.getLastObject();
		  init = false;
	  } else {
		  exam.setPrevious();
		  q = (Question)exam.getObject();
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
	// Initialize and show elements
	ConsoleMethods.println("Initialize exam");
    APexam exam = new APexam();
    exam.displayTest();
    
    // Empty queue and show elements
	ConsoleMethods.println("Empty exam");
    exam.emptyTest();
    exam.displayTest();
  }
}

