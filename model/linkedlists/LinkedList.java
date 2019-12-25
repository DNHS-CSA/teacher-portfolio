package model.linkedlists;
/**
 *  Implementation of a node with forward and backward links to previous and next Nodes respectively.
 *
 */

public class LinkedList
{
   Object value;
   LinkedList prevNode;
   LinkedList nextNode;

  /**
   *  Constructs a new element with object objValue,
   *  followed by object address
   *
   * @param  valueObj  Value of Object
   * @param  objAddr   Reference to previous Object in list
   */
  public LinkedList()
  {
	value = null;
	prevNode = null;
	nextNode = null;
  }

  /**
   *  Returns value associated with this element
   *
   * @return    The value associated with this element
   */
  public Object getValue()
  {
    return value;
  }

  /**
   *  Returns reference to previous object in list
   *
   * @return    The pointer is to the previous object in the list
   */
  public LinkedList getPrevious()
  {
    return prevNode;
  }
  
  /**
   *  Returns reference to next object in list
   *
   * @return    The pointer is to the next object in the list
   */
  public LinkedList getNexts()
  {
    return nextNode;
  }
}
