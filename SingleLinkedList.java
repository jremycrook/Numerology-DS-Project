/**
 * This class is for creating Singly linked Lists
 */
public class SingleLinkedList 
{
	//variable declaration
	private singleNode head;
	private singleNode tail;
	
	//constructor
	public SingleLinkedList() {};
	
	//method for returning the head function
	public singleNode head() {return head;}
	
	//Adds numerology objects to the SLL
	public void addFirst(Numerology num) 
	{
		singleNode newNode = new singleNode(num);
		if (head == null)
		{
			head =tail = newNode;
		}//end if
		else 
		{
			tail.next = newNode;
			tail = newNode;
		}//end else
	}//end addFirst()
}//end SingleLinkedList
