package LinkedList;

public class SinglyLinkedList 
{
	static LinkedListNode head;
	
	//Insertion
	
	public void InsertAtTheBegining(int data) 
	{
		LinkedListNode newnode = new LinkedListNode(data);
		if(head == null) {
			System.out.println("list is empty");
			head = newnode;
			return;
		}
		
		newnode.next= head;
		head = newnode;
	}

	public void InsertAtTheLast(int data) 
	{
		LinkedListNode newnode = new LinkedListNode(data);
		LinkedListNode temp = head;
		
		while(temp.next != null) {
			temp =temp.next;
		}
	  
		temp.next= newnode;
		return;	
	}
	
	public void InsertInBetweenList(int data,int value)
	{
		LinkedListNode newnode = new LinkedListNode(data);
		LinkedListNode temp = head;
		
		if(head == null) {
			System.out.println("list is empty");
			head = newnode;
			return;
		}
		
		while(temp.next!=null && temp.data!= value)
		{
			temp = temp.next;
		}
		
		newnode.next = temp.next;
		temp.next = newnode;
		return;	
	}
	
	//Deletion
	
}


class LinkedListNode
{
	int data;
	LinkedListNode next;
	
	public LinkedListNode(int data)
	{
		super();
		this.data = data;
		next = null;
	}
}