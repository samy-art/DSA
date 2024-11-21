package LinkedList;

public class DoublyLinkedList
{
	static DLinkedListNode head;
	
	public void InsertAtTheBegining(int data) 
	{
		DLinkedListNode newnode = new DLinkedListNode(data);
		
		if(head == null)
		{
			System.out.println("list is empty");
			head = newnode;
			return;
		}
			
		newnode.next = head;
		head.prev = newnode;
		head = newnode;	
	}
	
	public void InsertAtTheLast(int data) 
	{
		DLinkedListNode newnode = new DLinkedListNode(data);
		
		if(head == null)
		{
			System.out.println("list is empty");
			head = newnode;
			return;
		}else {
		
		DLinkedListNode temp = head;
		
		while(temp.next != null) 
		{
			temp = temp.next;
		}
		
		temp.next = newnode;
		newnode.prev = temp;
		newnode.next = null;
		
		}
	}
	
	public void InsertInBetween(int data, int value) 
	{
		DLinkedListNode newnode = new DLinkedListNode(data);
		DLinkedListNode temp = head;
		
		if(head == null) 
		{
			System.out.println("List is empty!");
			head = newnode;
			return;
		}
		
		while(temp.next != null && temp.data != value) 
		{
			newnode.prev = temp;
			newnode.next = temp.next;
			temp.next = newnode;				
		}
	}
	
	// deletion 
	
	public void deleteFirstNode()
	{
		DLinkedListNode temp = head;
		if(head == null) {
			System.out.println("List is empty...nothing to delete ");
			return;
		}
		
		head = head.next;
		head.prev = null;
	}
	
	public void deleteAtLast()
	{
		DLinkedListNode temp = head;
		
		if(head == null) {
			System.out.println("List is empty...nothing to delete ");
			return;
		}
		
		if(head.next==null) {
			head = null;
		}
		
		while(temp.next != null) 
		{
			temp.prev.next = null;
			temp = null;	
		}
	}
	
	public void deleteInBetweenList(int value) 
	{
		if(head==null) {
			System.out.println("list is empty");
		}
		
		if(head.next==null) {
			head =null;
			return;
		}
		
		DLinkedListNode temp = head;
		
		while(temp.next != null && temp.data != value) 
		{
			temp = temp.next;	
		}
		temp.prev.next = temp.next;
		temp.next.prev = temp.prev;
		temp = null;
	}
	
	public boolean search(int value) 
	{
	    DLinkedListNode temp = head;
	    while (temp != null) 
	    {
	        if (temp.data == value) 
	        {
	            System.out.println("Value " + value + " found in the list.");
	            return true;
	        }
	        temp = temp.next;
	    }
	    System.out.println("Value " + value + " not found in the list.");
	    return false;
	}

	public void sortList() 
	{
	    if (head == null) 
	    {
	        System.out.println("List is empty, nothing to sort.");
	        return;
	    }

	    boolean swapped;
	    do {
	        swapped = false;
	        DLinkedListNode temp = head;

	        while (temp.next != null)
	        {
	            if (temp.data > temp.next.data) 
	            {
	                
	                int var = temp.data;
	                temp.data = temp.next.data;
	                temp.next.data = var;
	                swapped = true;
	            }
	            temp = temp.next;
	        }
	    } while (swapped);
	}

	public void reverseList() 
	{
	    if (head == null)
	    {
	        System.out.println("List is empty, nothing to reverse.");
	        return;
	    }

	    DLinkedListNode previous = null;
	    DLinkedListNode current = head;

	    // Swap the next and prev pointers of all nodes
	    while (current != null) 
	    {
	        previous = current.prev;   // Store current's previous node
	        current.prev = current.next; // Reverse the previous pointer
	        current.next = previous;    // Reverse the next pointer
	        current = current.prev;     // Move to the next node (which was originally the previous node)
	    }

	    // Adjust the head of the reversed list
	    if (previous != null)
	    {
	        head = previous.prev;  // After the loop, previous points to the new head's previous node
	    }
	}
	
	public void displayList()
	{
	    DLinkedListNode temp = head;
	    if (head == null) {
	        System.out.println("List is empty.");
	        return;
	    }
	    while (temp != null) {
	        System.out.print(temp.data + " ");
	        temp = temp.next;
	    }
	    System.out.println();
	}

	public static void main(String[] args) {
	    DoublyLinkedList list = new DoublyLinkedList();

	    // Insertion operations
	    list.InsertAtTheBegining(30);
	    list.InsertAtTheBegining(20);
	    list.InsertAtTheBegining(10);
	    list.InsertAtTheLast(40);
	    list.InsertAtTheLast(50);

	    System.out.println("Original List:");
	    list.displayList();

	    // Search operation
	    System.out.println("Searching for 20:");
	    list.search(20);

	    System.out.println("Searching for 60:");
	    list.search(60);

	    // Sort operation
	    System.out.println("Sorting the list:");
	    list.sortList();
	    list.displayList();

	    // Reverse operation
	    System.out.println("Reversing the list:");
	    list.reverseList();
	    list.displayList();
	}


	
}

class DLinkedListNode
{
	int data;
	DLinkedListNode next;
	DLinkedListNode prev;
	
	public DLinkedListNode(int data)
	{
		super();
		this.data = data;
		prev = next = null;
	}
}