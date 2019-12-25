package model.linkedlists;

import util.ConsoleMethods;

/**
 *  Demonstrates the use of the SinglyLinkedList class.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class StackDemo
{
  Stack mystack;
  int size = 10;

  public StackDemo()
  {
	  mystack = new Stack();
  }

  /**
   *  Creates a Linked List of int nodes
   */
  public void createStack()
  {
    for (int i = 1; i <= size; i++)
    {
    	mystack.addLIFO(i);
		ConsoleMethods.println(mystack);
    }
  }
  
  /**
   *  Invert the creation, by removing entries
   */
  public void killStack()
  {
	  for (int i = 1; i <= size; i++)
	  {
		  ConsoleMethods.println(mystack);
		  mystack.deleteLIFO();
	  }
  }

  /**
   *  Display the first element of the list
   */
  public void displayStack()
  {
    ConsoleMethods.println("LIFO Element: " + mystack.getLIFO());
    ConsoleMethods.println("Full Stack: " + mystack);
  }


  /**
   *  Demonstrates the use of the SinglyLinkedList class.
   *  Creates and prints a list of 5 consecutive Integer objects.
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
