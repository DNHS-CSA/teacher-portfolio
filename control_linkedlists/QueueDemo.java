package control_linkedlists;

import util.ConsoleMethods;

/**
 *  Demonstrates the use of Stack created from LinkedList class.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class QueueDemo
{
  private Queue myqueue;
  private int size = 26-1;	// alphabet size

  public QueueDemo()
  {
	  myqueue = new Queue();
  }

  /**
   *  Creates a series of user defined objects and populates on Stack,
   *  any type of object can be used,
   *  stack pushes and operations are displayed to console
   */
  public void createQueue()
  {

	  	// pushing data to stack with console output
	  	for (int i = 0; i <= size; i++)
		{
			myqueue.add(
					new String( Character.toString('a' + i)) // push stack (characters, numbers, etc)
					);  
			ConsoleMethods.println("Add:" + myqueue.getValue() + " " + myqueue);
		}
  }
  
  /**
   *  Removes all the user defined objects from Stack,
   *  this is inverse of createStack,
   *  stack pops and values are displayed to console 
   */
  public void emptyQueue()
  {
	  	// popping data off stack with console output
	  	for (int i = 0; i <= size; i++)
	  	{
			 ConsoleMethods.println("Delete:" + myqueue.delete() + " " + myqueue);						
	  	}
  }

  /**
   *  Display the top element of the list and full stack
   */
  public void displayQueue()
  {
    ConsoleMethods.println("First Element: " + myqueue.getFirstValue() );
    ConsoleMethods.println("Last Element: " + myqueue.getLastValue() );
    ConsoleMethods.println("Full Queue: " + myqueue);
  }


  /**
   *  Demonstrates the use of the LinkedList used as Stack.
   *
   * @param  args  The command line arguments (not used)
   */
  public static void main(String[] args)
  {
    QueueDemo queue = new QueueDemo();

    queue.createQueue();
    queue.displayQueue();
    queue.emptyQueue();

  }
}
