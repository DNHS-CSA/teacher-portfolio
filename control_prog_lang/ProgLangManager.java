package control_prog_lang;

import model_linkedlists.CircleQueue;
import util.ConsoleMethods;;

/**
 *  Establish  a set of random questions.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class ProgLangManager {

  private CircleQueue progLangs;
  private int size = 5;

  /**
   *  APprogLang with default amount of questions
   */ 
  public ProgLangManager()
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
	  	AttributeModel a;

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
	  				break;
	  			case 3:
	  				a = new Ruby();
	  				break;
	  			case 4:
	  			default:
	  				a = new Swift();
	  		}
	  		a.setID(i+1);
  			progLangs.add(a);
		}
	  	
  }
  
  /**
   *  Increase logical position
   */
  public int decrementPositon(int position)
  {  
	  if (position <= 0)
		  position = size-1;
	  else
		  position--;

	  return position;
	  
  }
  
  /**
   *  Increase logical position
   */
  public int incrementPositon(int position)
  {  
	  if (position >= size-1)
		  position = 0;
	  else
		  position++;

	  return position;
	  
  }
  
  /**
   *  Locate object by position (optimization would be necessary if large)
   */
  public AttributeModel getAttributesbyIndex(int position)
  {	  
	  	// loop until you find object by position
		progLangs.getFirstObject();
		for (int i = 0; i < position; i++)
			progLangs.setNext();
		return (AttributeModel)progLangs.getObject();
  }
 
  public String searchAttributes(String searchTerm)
  {
  	String Answer="";
	AttributeModel pLang;
	
	// Loop to search text within each language within List of Programming Languages
	for (int i = 0, j = 0; i == j; j = incrementPositon(i++)) {
		pLang = getAttributesbyIndex(i);
		if ( pLang.toString().indexOf( searchTerm ) > 0 ) {
			Answer = Answer + " " + pLang.getKey();
		}
	}
	return (Answer);
  }
  
  public String toString()
  {
	  String Answer="";
	  AttributeModel pLang;
		
	  // Loop to search text within each language within List of Programming Languages
	  for (int i = 0, j = 0; i == j; j = incrementPositon(i++)) {
			pLang = getAttributesbyIndex(i);
			Answer = Answer + " " + pLang.toString();
	  }
	  return (Answer);
	}
  
  /* ************************* Test Section below this point ************************* */
 
  /**
   *  Removes all the user defined objects from circle list,
   *  this is inverse of createProgLang,
   *  deletes references from circle list
   */
  private void emptyTest()
  {
	  	// remove data off queue
	  	for (int i = 0; i <= size; i++)
	  	{
	  		progLangs.delete();
	  	}
  }
  
  /**
   *  Displays key elements and the the full list
   */
  private void displayTest()
  {
    ConsoleMethods.println("First Element: " + progLangs.getFirstObject() );
    ConsoleMethods.println("Last Element: " + progLangs.getLastObject() );
    ConsoleMethods.println("Full List: " + progLangs);
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
	ProgLangManager progLang = new ProgLangManager();
    progLang.displayTest();
    
    // Empty queue and show elements
	ConsoleMethods.println("Empty progLang");
    progLang.emptyTest();
    progLang.displayTest();
  }
}


