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
  private LinkedList lifo;  // last in first out element of stack

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public Stack()
  {
    lifo = null;
  }

  /**
   *  Returns the LIFO element in this list.
   *
   * @return  the LIFO element in the linked list.
   */
  public Object getLIFO()
  {
    if (lifo == null)
    {
      throw new NoSuchElementException();
    }
    else
      return lifo.getValue();
  }

  /**
   *  Inserts the given element at the beginning of this list.
   *
   * @param  value  the element to be inserted at the beginning of this list.
   */
  public void addLIFO(Object value)
  {
    // note the order that things happen:
    // head is parameter, then assigned
    lifo = new LinkedList(value, lifo);
  }
  
  /**
   *  Removes the given element to the next in list.  Garbage collection should destroy element when needed.
   *
   */
  public void deleteLIFO()
  {
	  if (lifo != null)
	    lifo = lifo.getNext();
  }

  /**
   *  Returns a string representation of this list. The string
   *  representation consists of the list's elements in order,
   *  enclosed in square brackets ("[]"). Adjacent elements are
   *  separated by the characters ", " (comma and space).
   *
   * @return    string representation of this list
   */
  public String toString()
  {
    String s = "[";

    LinkedList temp = lifo;  	// start from the lifo node
    while (temp != null)
    {
      s += temp.getValue(); 	// append the data
      temp = temp.getNext();    // go to next node
      if (temp != null)
        s += ", ";
    }
    s += "]";
    return s;
  }
  
    
}
