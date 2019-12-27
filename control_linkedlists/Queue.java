package control_linkedlists;

import java.util.*;

/**
 *  Implementation of Queue, using LinkedList (previous and next).
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class Queue
{
   private LinkedList headNode;			// 1st element in Queue
   private LinkedList tailNode;			// Last element in Queue
   private LinkedList currentNode;		

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
   *  Returns the head objects value.
   *
   * @return  the head objects value in Stack.
   */
  public Object getFirstValue()
  {
  	currentNode = headNode;

    if (headNode == null)
    {
      throw new NoSuchElementException();
    }
    else
      return headNode.getValue();
  }

  /**
   *  Returns the tail objects value.
   *
   * @return  the current objects value in Stack.
   */
  public Object getLastValue()
  {
	currentNode = tailNode;

    if (tailNode == null)
    {
      throw new NoSuchElementException();
    }
    else
      return tailNode.getValue();
  }
  
  /**
   *  Returns the current objects value.
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
   *  Advances the current node.
   *
   */
  public void setNext()
  {
	currentNode = currentNode.getNext();
	
	// never let currentNode be null, hold at tail
	if (currentNode == null)
		currentNode = tailNode;
  }
  
  
  /**
   *  Add a new object at the end of the Queue,
   *
   * @param  value  is the data to be inserted in the Queue object.
   */
  public void add(Object value)
  {
	  // add new object to end of Queue
	  // set value
	  // build previous link of tail (as current)
	  tailNode = new LinkedList(value, currentNode);
	  
	  // build next link of current (as tail)
	  if (currentNode != null)
		  currentNode.setNextNode(tailNode);
	  
	  // after links are established current eq tail
	  currentNode = tailNode;

	  // head eq tail on 1st element only
	  if (headNode == null) {
		  headNode = tailNode;
	  }
  }
  
  /**
   *  Delete an object from the front of the Queue,
   *
   */
  public Object delete()
  {
	  Object value = null;
	  
	  if (headNode != null) {
		  value = headNode.getValue();
		  headNode = headNode.getNext();
		  if (headNode != null)
			  headNode.setPrevNode(null);
	  }
	  return value;
  }
  
  /**
   *  Returns a string representation of this Queue,
   *  polymorphic nature of toString overrides of standard System.out.print behavior
   *
   * @return    string representation of this Queue
   */
  public String toString()
  {
    String queueToString = "[";

    LinkedList node = headNode;  			// start from the head
    while (node != null)
    {
    	queueToString += node.getValue(); 	// append the data to output string
    	node = node.getNext();				// go to next node
    	if (node != null)
    		queueToString += ", ";
    }										// loop 'till queue ends
    queueToString += "]";
    return queueToString;
  }
  
    
}
