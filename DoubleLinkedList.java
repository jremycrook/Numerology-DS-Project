/**
 * This class is for making double linked lists
 */
public class DoubleLinkedList 
{
	//declarations
	private doubleNode header = null;
	private doubleNode trailer = null;
	
	//constructor
	public DoubleLinkedList() {};
	
	//method for returning the header
	public doubleNode first() 
	{
		return header;
	}//end first()
	
	//method for returning tailing value
	public doubleNode last() 
	{
		return trailer;
	}//end last()
	
	//Adds numerology objects to the DLL
	public void addDouble(Numerology num)
	{
		doubleNode newNode = new doubleNode(num);
		if (header == null) 
		{
			header = trailer= newNode;
		}//end if
		else
		{
			newNode.prev = trailer;
			trailer.next = newNode;
			trailer = newNode;
		}//end else
	}//end addDouble()
}//end doubleLinked class
