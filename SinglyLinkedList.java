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
	
	public void DeleteFirstNode() 
	{
		if(head==null) {
			System.out.println("list is empty");
			return;
		}
		
		LinkedListNode temp = head;
		head = head.next;
		temp = null;	
	}
	
	public void DeleteLastNode() 
	{
		if(head==null) {
			System.out.println("list is empty");
			return;
		}
		
		if(head.next==null) {
			head = null;
		}
		
		LinkedListNode temp = head;
		LinkedListNode prev = head;
		
		 while(temp.next!=null)
		 {
			 prev = temp;
			 temp = temp.next;
		 }
		
		 prev.next=null;
		 return;
		
	}
	
	public void DeleteIntermediateNode(int value)
	{
		if(head==null) {
			System.out.println("list is empty");
		}
		
		if(head.next==null) {
			head =null;
			return;
		}
		
		LinkedListNode temp = head;
		LinkedListNode prev = head;
		
		while(temp.next!=null && temp.data==value) 
		{
			prev = temp;
			temp = temp.next;
			
		}
		
		prev.next = temp.next;
		temp = null;
		return;
		
	}
	
	// linear search
	
	public int SearchValue(int value) 
	{
		LinkedListNode temp = head;
		
		while(temp.next!=null)
		{
			if(temp.data==value)
			{
				System.out.println("Value" + temp.data + " found in the list");
			}
			temp = temp.next;	
		}
		
		return -1;
	}
	
	// bubble sorting
	
	public void sortList() 
	{
		LinkedListNode Lastunsorted= null;
		boolean swap;
		do 
		{
			LinkedListNode temp = head;
			
		    swap = false;
			
			while(temp.next!=Lastunsorted)
			{
				if(temp.data > temp.next.data) 
				{
					int var = temp.data;
					temp.data = temp.next.data;
					temp.next.data = var;
					swap = true;	
				}
				temp = temp.next;
			}
		
			Lastunsorted = temp;
			
		}while(swap);	
	}
	
	// linked list reversal
	
	public LinkedListNode ReverseList() 
	{
		LinkedListNode prev =null;
		LinkedListNode next;
		LinkedListNode temp =head;
		
		while(temp.next != null) 
		{
			next = temp.next; // store next
			temp.next = prev; // reverse the pointer
			prev = temp;
			temp = next;	
		}
		
		return prev;   // returning the head of the reversed list
	}
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