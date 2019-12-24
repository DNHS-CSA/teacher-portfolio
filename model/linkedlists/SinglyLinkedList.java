package model.linkedlists;

import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     G. Peck
 * @created    April 27, 2002
 */
public class SinglyLinkedList
{
  private ListNode lifo;  // last in first out element

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public SinglyLinkedList()
  {
    lifo = null;
  }

  /**
   *  Returns the lifo element in this list.
   *
   * @return  the lifo element in the linked list.
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
    lifo = new ListNode(value, lifo);
  }

  /**
   *  Print the contents of the entire linked list
   */
  public void printList()
  {
    ListNode temp = lifo;		// start from the lifo node
    while (temp != null)
    {
      System.out.print(temp.getValue() + " ");
      temp = temp.getNext();	// go to next node
    }
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

    ListNode temp = lifo;  	// start from the lifo node
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
  
  public void killList()
  {
	  while (lifo != null) {
		  lifo = lifo.getNext();	// move in an element 'till noting
		  printList();
		  System.out.println();
	  }
  }
  
}
