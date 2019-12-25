package model.linkedlists;

import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class Stack
{
  private LinkedList lifo;  // last in first out Object of stack

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public Stack()
  {
    lifo = null;
  }

  /**
   *  Returns the current (LIFO) objects value.
   *
   * @return  the current objects value in Stack.
   */
  public Object getValue()
  {
    if (lifo == null)
    {
      throw new NoSuchElementException();
    }
    else
      return lifo.getValue();
  }

  /**
   *  Inserts the given element at the top of this Stack.
   *
   * @param  value  the value to be inserted at the top of the Stack.
   */
  public void push(Object value)
  {
    // note the order that things happen:
    // head is parameter, then assigned
    lifo = new LinkedList(value, lifo);
  }
  
  /**
   *  Removes the top element in the Stack.  Garbage collection should destroy this element when needed.
   *
   */
  public void pop()
  {
	  if (lifo != null)
	    lifo = lifo.getNext();
  }

  /**
   *  Returns a string representation of this Stack,
   *  polymorphic nature of toString overrides of standard System.out.print behavior
   *
   * @return    string representation of this list
   */
  public String toString()
  {
    String stackToString = "[";

    LinkedList node = lifo;  	// start from the lifo node
    while (node != null)
    {
    	stackToString += node.getValue(); 	// append the data to output string
    	node = node.getNext();    // go to next node
    	if (node != null)
    	  stackToString += ", ";
    }
    stackToString += "]";
    return stackToString;
  }
  
    
}
