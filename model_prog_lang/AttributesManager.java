package model_prog_lang;

import control_ap_exam.APexam;
import model_linkedlists.CircleQueue;
import util.ConsoleMethods;;

/**
 *  Establish  a set of random questions.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class AttributesManager {

  private CircleQueue progLangs;
  private int size = 5;
  private boolean init = true;


  /**
   *  APprogLang with default amount of questions
   */ 
  public AttributesManager()
  {
	  init();
  }

  
  /**
   *  Constructor helper
   */
  private void init()
  {
	  progLangs = new CircleQueue();
	  createProgLang();
  }
  
  /**
   *  Creates a series of user defined objects and populates on Stack,
   *  any type of object can be used,
   *  stack pushes and operations are displayed to console
   */
  public void createProgLang()
  {	
	  	Attributes a;

	  	// pushing data to stack with console output
	  	for (int i = 0; i <= size-1; i++)
		{
	  		switch(i) {
	  			case 0:
	  				a = new CSharp();
	  				break;
	  			case 1:
	  				a = new Java();
	  				break;
	  			case 2:
	  				a = new Python();
	  			case 3:
	  				a = new Ruby();
	  			case 4:
	  			default:
	  				a = new Swift();
	  		}
	  		a.setID(i+1);
  			progLangs.add(a);
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
	  		progLangs.delete();
	  	}
  }

  /**
   *  Display the top element of the list and full stack
   */
  public void displayTest()
  {
    ConsoleMethods.println("First Element: " + progLangs.getFirstObject() );
    ConsoleMethods.println("Last Element: " + progLangs.getLastObject() );
    ConsoleMethods.println("Full Queue: " + progLangs);
  }
  
  /**
   *  Get current test question and advance pointer
   */
  public Attributes getAttributesFwd()
  {
	  Attributes q;	// put object back into Attributes type

	  if (init) {
		  q = (Attributes)progLangs.getFirstObject();
		  init = false;
	  } else {
		  progLangs.setNext();
		  q = (Attributes)progLangs.getObject();
	  }
	  
	  return q;	
  }
  
  /**
   *  Get current test question and advance pointer
   */
  public Attributes getAttributesRev()
  {
	  Attributes q;	// put object back into Attributes type

	  if (init) {
		  q = (Attributes)progLangs.getLastObject();
		  init = false;
	  } else {
		  progLangs.setPrevious();
		  q = (Attributes)progLangs.getObject();
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
	ConsoleMethods.println("Initialize progLang");
	AttributesManager progLang = new AttributesManager();
    progLang.displayTest();
    
    // Empty queue and show elements
	ConsoleMethods.println("Empty progLang");
    progLang.emptyTest();
    progLang.displayTest();
  }
}


