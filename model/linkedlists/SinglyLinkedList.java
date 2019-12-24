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
  private ListNode first;  // first element

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public SinglyLinkedList()
  {
    first = null;
  }

  /**
   *  Returns the first element in this list.
   *
   * @return  the first element in the linked list.
   */
  public Object getFirst()
  {
    if (first == null)
    {
      throw new NoSuchElementException();
    }
    else
      return first.getValue();
  }

  /**
   *  Inserts the given element at the beginning of this list.
   *
   * @param  value  the element to be inserted at the beginning of this list.
   */
  public void addFirst(Object value)
  {
    // note the order that things happen:
    // head is parameter, then assigned
    first = new ListNode(value, first);
  }

  /**
   *  Print the contents of the entire linked list
   */
  public void printList()
  {
    ListNode temp = first;// start from the first node
    while (temp != null)
    {
      System.out.print(temp.getValue() + " ");
      temp = temp.getNext();// go to next node
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

    ListNode temp = first;  // start from the first node
    while (temp != null)
    {
      s += temp.getValue(); // append the data
      temp = temp.getNext();      // go to next node
      if (temp != null)
        s += ", ";
    }
    s += "]";
    return s;
  }
}
