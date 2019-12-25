package model.linkedlists;
/**
 *  Implementation of a node of a singly linked list.
 *
 *  Adapted from the College Board's AP Computer Science AB:
 *  Implementation Classes and Interfaces.
 */

public class LinkedList
{
  private LinkedList pointer;
  private Object value;

  /**
   *  Constructs a new element with object objValue,
   *  followed by object address
   *
   * @param  objValue  Value of Object
   * @param  objAddr   Reference to Object of element
   */
  public LinkedList(Object objValue, LinkedList objAddr)
  {
	value = objValue;
	pointer = objAddr;
  }

  /**
   *  Constructs a new tail of a list with object objValue
   *
   * @param  objValue  New element object
   */
  public LinkedList(Object objValue)
  {
    this(objValue, null);
  }

  /**
   *  Sets the value attribute of the LinkedList object
   *
   * @param  newValue  value attribute of the LinkedList object
   */
  public void setValue(Object newValue)
  {
    value = newValue;
  }

  /**
   *  Sets reference to next object in the list
   *
   * @param  nextObj  The new object
   */
  public void setNext(LinkedList nextObj)
  {
    pointer = nextObj;
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
   *  Returns reference to next object in list
   *
   * @return    The pointer to next object in the list
   */
  public LinkedList getNext()
  {
    return pointer;
  }
}
