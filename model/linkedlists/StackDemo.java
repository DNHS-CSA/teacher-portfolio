package model.linkedlists;

import util.ConsoleMethods;

/**
 *  Demonstrates the use of Stack created from LinkedList class.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class StackDemo
{
  private Stack mystack;
  private int size = 26-1;	// alphabet size

  public StackDemo()
  {
	  mystack = new Stack();
  }

  /**
   *  Creates a series of user defined objects and populates on Stack,
   *  any type of object can be used,
   *  stack pushes and operations are displayed to console
   */
  public void createStack()
  {

	  	// pushing data to stack with console output
	  	for (int i = 0; i <= size; i++)
		{
			mystack.push(
					new String( Character.toString('a' + i)) // push stack (characters, numbers, etc)
					);  
			ConsoleMethods.println("Push:" + mystack.getValue() + " " + mystack);
		}
  }
  
  /**
   *  Removes all the user defined objects from Stack,
   *  this is inverse of createStack,
   *  stack pops and values are displayed to console 
   */
  public void killStack()
  {
	  	// popping data off stack with console output
	  	for (int i = 0; i <= size; i++)
	  	{
			 ConsoleMethods.print("Pop:" + mystack.getValue() + " ");						
			 mystack.pop();		// pop stack
			 ConsoleMethods.println(mystack);
	  	}
  }

  /**
   *  Display the top element of the list and full stack
   */
  public void displayStack()
  {
    ConsoleMethods.println("Top Element: " + mystack.getValue());
    ConsoleMethods.println("Full Stack: " + mystack);
  }


  /**
   *  Demonstrates the use of the LinkedList used as Stack.
   *
   * @param  args  The command line arguments (not used)
   */
  public static void main(String[] args)
  {
    StackDemo stack = new StackDemo();

    stack.createStack();
    stack.displayStack();
    stack.killStack();
  }
}
