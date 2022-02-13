/**
 * This class is for creating nodes for doubly linked lists
 */
public class doubleNode 
{
	//variable declaration
	public Numerology num;
	public doubleNode next;
	public doubleNode prev;
	
	//constructor
	public doubleNode (Numerology numer) 
	{
		num = numer;
		next = null;
		prev = null;
	}//end constructor
}//end double node
