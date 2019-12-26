package model_linkedlists;
/**
 *  Implementation of a node with forward and backward links to previous and next Nodes respectively.
 *
 */

public class LinkedList
{
   private Object value;
   private LinkedList prevNode;
   private LinkedList nextNode;

  /**
   *  Constructs a new element with object objValue,
   *  followed by object address
   *
   * @param  valueObj  Value of Object
   * @param  objAddr   Reference to previous Object in list
   */
  public LinkedList(Object value, LinkedList node)
  {
	setValue(value);
	setPrevNode(node);
	setNextNode(null);
  }

  /**
   *  Setter for value in LinkedList object
   *
   * @node    Set value of current LinkedList object
   */
  public void setValue(Object value)
  {
    this.value = value;
  }
  
  /**
   *  Setter for prevNode in LinkedList object
   *
   * @node    A LinkedList object that is prevNode to current Object
   */
  public void setPrevNode(LinkedList node)
  {
    this.prevNode = node;
  }
  
  /**
   *  Setter for nextNode in LinkedList object
   *
   * @node    A LinkedList object that is nextNode to current Object
   */
  public void setNextNode(LinkedList node)
  {
    this.nextNode = node;
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
  public LinkedList getNext()
  {
    return nextNode;
  }
}
