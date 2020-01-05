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
   *  Constructor for Programming Language list
   */ 
  public ProgLangManager()
  {
	  progLangs = new CircleQueue();
	  createProgLang();
  }
  
  /**
   *  Filtered constructor for Programming Language list
   */ 
  public ProgLangManager(ProgLangManager oProgLangs, String searchTerm)
  {
	  size = 0;
	  progLangs = new CircleQueue();
	  ProgLangAttributes pLang;
		
	  // Loop to search text within each language within List of Programming Languages
	  for (int i = 0, j = 0; i == j; j = oProgLangs.incrementPositon(i++)) {
		pLang = oProgLangs.getProgLangByIndex(i);
		if ( pLang.toString().indexOf( searchTerm ) > 0 ) {
			progLangs.add(pLang);
			size++;
		}
	    ConsoleMethods.println("Growing List: " + progLangs);
	  }
  }
  
  /**
   *  Creates a series of user defined objects and populates on Stack,
   *  any type of object can be used,
   *  stack pushes and operations are displayed to console
   */
  public void createProgLang()
  {	
	  	ProgLangAttributes am;

	  	// pushing data to stack with console output
	  	for (int i = 0; i <= size-1; i++)
		{
	  		switch(i) {
	  			case 0:
	  				am = new CSharp();
	  				break;
	  			case 1:
	  				am = new Java();
	  				break;
	  			case 2:
	  				am = new Python();
	  				break;
	  			case 3:
	  				am = new Ruby();
	  				break;
	  			case 4:
	  			default:
	  				am = new Swift();
	  		}
	  		am.setID(i+1);
  			progLangs.add(am);
		}	  	
  }
  
  /**
   * Getter to inform list size, real import for small conditions
   * 
   * @return size of circle list
   */
  public int getSize()
  {
	  return size;
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
  public ProgLangAttributes getProgLangByIndex(int position)
  {	  
	  	// loop until you find object by position
		progLangs.getFirstObject();
		for (int i = 0; i < position; i++)
			progLangs.setNext();
		return (ProgLangAttributes)progLangs.getObject();
  }
  
  /**
   *  Search term for matching programming language attributes
   */
  public String searchProgLangs(String searchTerm)
  {
  	String Answer="";
	ProgLangAttributes pLang;
	
	// Loop to search text within each language within List of Programming Languages
	for (int i = 0, j = 0; i == j; j = incrementPositon(i++)) {
		pLang = getProgLangByIndex(i);
		if ( pLang.toString().indexOf( searchTerm ) > 0 ) {
			Answer = Answer + " " + pLang.getKey();
		}
	}
	return (Answer);
  }
 
  
  /* ************************* Console or Test methods below this point ************************* */
 
  /**
   *  Removes all the user defined objects from circle list,
   *  this is inverse of createProgLang,
   *  deletes references from circle list
   */
  public void emptyTest()
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
  public void displayTest()
  {
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
	ProgLangManager pLs = new ProgLangManager();
	pLs.displayTest();
    
    // Empty queue and show elements
	ConsoleMethods.println("Empty progLang");
	pLs.emptyTest();
	pLs.displayTest();
  }
}


