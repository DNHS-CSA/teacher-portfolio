package model.linkedlists;

import java.util.*;

/**
 *  Implementation of lists, using singly linked elements.
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class Queue
{
   LinkedList headNode;
   LinkedList tailNode;
   LinkedList currentNode;

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public Queue()
  {
    headNode = null;
    tailNode = null;
    currentNode = null;
  }

  /**
   *  Returns the current (FIFO) objects value.
   *
   * @return  the current objects value in Stack.
   */
  public Object getFirstValue()
  {
    if (headNode == null)
    {
      throw new NoSuchElementException();
    }
    else
      return headNode.getValue();
  }

  /**
   *  Returns the current (FIFO) objects value.
   *
   * @return  the current objects value in Stack.
   */
  public Object getLastValue()
  {
    if (tailNode == null)
    {
      throw new NoSuchElementException();
    }
    else
      return tailNode.getValue();
  }
  
  /**
   *  Returns the current (FIFO) objects value.
   *
   * @return  the current objects value in Stack.
   */
  public Object getValue()
  {
    if (currentNode == null)
    {
      throw new NoSuchElementException();
    }
    else
      return currentNode.getValue();
  }
  
  /**
   *  Inserts a new object at the top of this Stack,
   *
   * @param  value  is the data to be inserted at the top of the Stack.
   */
  public void add(Object value)
  {
	  tailNode = new LinkedList();
	  tailNode.value = value;
	  tailNode.prevNode = currentNode;
	  if (currentNode != null)
		  currentNode.nextNode = tailNode;
	  currentNode = tailNode;

	  if (headNode == null) {
		  headNode = tailNode;
	  }
  }
  
  /**
   *  Returns a string representation of this Stack,
   *  polymorphic nature of toString overrides of standard System.out.print behavior
   *
   * @return    string representation of this list
   */
  public String toString()
  {
    String queueToString = "[";

    LinkedList node = headNode;  	// start from the fifo node
    while (node != null)
    {
    	queueToString += node.getValue(); 	// append the data to output string
    	node = node.nextNode;    // go to previous node
    	if (node != null)
    		queueToString += ", ";
    }
    queueToString += "]";
    return queueToString;
  }
  
    
}
