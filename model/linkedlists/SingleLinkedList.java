package model.linkedlists;
/**
 *  Implementation of a node with a single link to a previous Node.
 *
 *  Adapted from the College Board's AP Computer Science AB:
 *  Implementation Classes and Interfaces.
 */

public class SingleLinkedList
{
  private Object value;
  private SingleLinkedList prevNode;

  /**
   *  Constructs a new element with object objValue,
   *  followed by object address
   *
   * @param  valueObj  Value of Object
   * @param  objAddr   Reference to previous Object in list
   */
  public SingleLinkedList(Object valueObj, SingleLinkedList prevObj)
  {
	value = valueObj;
	prevNode = prevObj;
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
  public SingleLinkedList getPrevious()
  {
    return prevNode;
  }
}
