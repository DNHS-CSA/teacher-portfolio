package model_linkedlists;

import java.util.*;

/**
 *  Implementation of Queue, using LinkedList (previous and next).
 *
 * @author     John Mortensen
 * @created    December 24, 2019
 */
public class CircleQueue
{
   private LinkedList headNode;			// 1st element in Queue
   private LinkedList tailNode;			// Last element in Queue
   private LinkedList currentNode;		

  /**
   *  Constructor for the SinglyLinkedList object
   *  Generates an empty list.
   */
  public CircleQueue()
  {
    headNode = null;
    tailNode = null;
    currentNode = null;
  }
  
  /**
   *  Returns the head opaqueObject.
   *
   * @return  the head opaqueObject in Stack.
   */
  public Object getFirstObject()
  {
  	currentNode = headNode;

    if (headNode == null)
    	return null;
    else
    	return headNode.getObject();
  }

  /**
   *  Returns the tail opaqueObjects.
   *
   * @return  the current opaqueObject in Stack.
   */
  public Object getLastObject()
  {
	currentNode = tailNode;

    if (tailNode == null)
    	return null;
    else
    	return tailNode.getObject();
  }
  
  /**
   *  Returns the current Object
   *
   * @return  the current Object in Stack.
   */
  public Object getObject()
  {
    if (currentNode == null)
  	  return null;
    else
      return currentNode.getObject();
  }
  
  /**
   *  Advances the current node.
   *
   */
  public void setNext()
  {
	currentNode = currentNode.getNext();
	
	// never let currentNode be null, wrap to head
	if (currentNode == null)
		currentNode = headNode;
  }
  
  /**
   *  Reverses the current node.
   *
   */
  public void setPrevious()
  {
	currentNode = currentNode.getPrevious();
	
	// never let currentNode be null, wrap to head
	if (currentNode == null)
		currentNode = tailNode;
  }
  
  
  /**
   *  Add a new object at the end of the Queue,
   *
   * @param  opaqueObject  is the data to be inserted in the Queue object.
   */
  public void add(Object opaqueObject)
  {
	  // add new object to end of Queue
	  // set opaqueObject
	  // build previous link of tail (as current)
	  tailNode = new LinkedList(opaqueObject, currentNode);
	  
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
	  Object opaqueObject = null;
	  	  
	  if (headNode != null) {
		  opaqueObject = headNode.getObject();
		  headNode = headNode.getNext();
		  if (headNode == null)
			  tailNode = headNode;
		  else
			  headNode.setPrevNode(null);
	  }
	  		
	  return opaqueObject;
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
    	queueToString += node.getObject(); 	// append the data to output string
    	node = node.getNext();				// go to next node
    	if (node != null)
    		queueToString += ", ";
    }										// loop 'till queue ends
    queueToString += "]";
    return queueToString;
  }
  
  /**
   * 
   */
  public void sort() {	
	
	//two nodes needed to sort
    LinkedList node1 = headNode;
    LinkedList node2 = (node1 == null) ? null : node1.getNext();
       
    while (node1 != null && node2 != null) {	
    	LinkedList slot1 = node1;
    	LinkedList slot2 = node2;
    		
		String text1 = node1.getObject().toString();
		String text2 = node2.getObject().toString();
		
		if ( text1.compareTo(text2) > 0 ) {
			
			LinkedList key = new LinkedList(node2);
			String keyText = node2.getObject().toString();
			System.out.println(keyText);

			while ( text1.compareTo(keyText) > 0 ) {
		    	
	    		slot2.setObject(slot1.getObject());

				// move pointers
				slot1 = slot1.getPrevious();
				slot2 = slot2.getPrevious();
				if (slot1 == null)
					break;
				text1 = slot1.getObject().toString();
				
	    	}
			
	    	slot2.setObject(key.getObject());

		}
    	
    	node1 = node1.getNext();
    	node2 = node2.getNext();
    } 	
  } 
  
}

