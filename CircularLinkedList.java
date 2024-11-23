package LinkedList;

public class CircularLinkedList 
{
	static CSLinkedListNode head;
	static CSLinkedListNode tail;
	
	public void InsertAtTheBegining(int data) 
	{
		CSLinkedListNode newnode = new CSLinkedListNode(data);
		
		if(head == null) 
		{
			System.out.println("list is empty");
			head = newnode;
			tail = newnode;
			newnode.next = newnode;
		}else {
			newnode.next = head;
			tail.next = newnode;
			head = newnode;
		}
	}
	
	public void InsertAtTheLast(int data)
	{
        CSLinkedListNode newnode = new CSLinkedListNode(data);
		
		if(head == null) 
		{
			System.out.println("list is empty");
			head = newnode;
			tail = newnode;
			newnode.next = newnode;
			return;
		}else 
		{
			newnode.next = tail.next;
			tail.next = newnode;
			tail = newnode;
		}
	}
	
	public void InsertInBetweenList(int value, int data) 
	{
        CSLinkedListNode newnode = new CSLinkedListNode(data);
        CSLinkedListNode temp = tail.next; // or head
		
        if(head == null) 
		{
			System.out.println("list is empty..nothing to search!");
			head = newnode;
			tail = newnode;
			newnode.next = newnode;
			return;
		}
        
        
        do {
            if (temp.data == value) {
                // Insert the new node after the current node
                newnode.next = temp.next;
                temp.next = newnode;

                // If inserting after the tail, update tail
                if (temp == tail) {
                    tail = newnode;
                }
                return;
            }
            temp = temp.next;
        } while (temp != head);

        System.out.println("Value " + value + " not found in the list.");
    }
	
	public void DeleteFirstNode() 
	{	
		if(head == null) {
			System.out.println(" List is empty!...Nothing to delete");
			return;
		}
		
		// only one node
		
		head = tail.next;
		
		if(head==tail) 
		{
			tail = null;
			head = null;
		}else                    // more than one node
		{
			tail.next = head.next;
			head = head.next;
		}
	}
	
	public void DeleteLastNode() 
	{
		if(head == null) {
			System.out.println(" List is empty!...Nothing to delete");
			return;
		}
		
		if(head == tail) {
			head = null;
			tail = null;
			return;
		}
		
		CSLinkedListNode temp = head;
		
		while(temp.next != tail) 
		{
			temp = temp.next;
		}
		temp.next = head;
		tail = temp;	
	}
      
	public void DeleteInBetweenList(int value) 
	{
		if(head == null) {
			System.out.println("List is empty...Nothing to delete");
			return;
		}
		
		CSLinkedListNode temp = tail.next;
		CSLinkedListNode prev = tail;
		
		if(head == tail && temp.data == value) {   // only one node
			head = null;
			tail = null;
			return;
		}
		
		while(temp != tail && temp.data != value )
		{
			prev = temp;
			temp  = temp.next;
		}
		
		if(temp.data == value) {
			prev.next = temp.next;
			return;
		}else {
			System.out.println(" Node with data " + value + " is not found!");
		}
	}
	
	public boolean SearchingNodeByValue(int value) 
	{	
		if(head == null)
			return false;
		
		CSLinkedListNode temp = head;
		
		do {
			if(temp.data == value)
				return true;
			temp = temp.next;
		}while(temp != tail);
		
		return false;
	}
	
	public void sortList() 
	{
		if(head == null) {
			System.out.println("Nothing to sort");
			return;
		}
		
		boolean swapped;
		do {
			swapped = false;
			CSLinkedListNode temp = head;
			
			while(temp != tail)
			{
				if(temp.data > temp.next.data) 
				{
					int var = temp.data;
					temp.data = temp.next.data;
					temp.next.data = var;
					
					swapped = true;
				}
				
				temp = temp.next;
			}
		}while(swapped);	
	}
	
	public CSLinkedListNode ReversalList()
	{
		if(head == null || head == tail) {
			return head;
		}
		
		CSLinkedListNode temp = head;
		CSLinkedListNode prev = null;
		CSLinkedListNode next;
		
		do {
			next = temp.next;
			temp.next = prev;
			prev = temp;
			temp = next;
			
		}while(temp != head);
		
		head.next = prev;
		head = prev;
		
		return head;
	}
	
	
	
	
	public void display() 
	{
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        CSLinkedListNode temp = head;
        do {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("HEAD");
    }

	public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();

        // Insert operations
        cll.InsertAtTheLast(10);
        cll.InsertAtTheLast(20);
        cll.InsertAtTheLast(30);
        cll.InsertAtTheBegining(5);

        System.out.println("Initial List:");
        cll.display();

        // Deletion cases
        cll.DeleteFirstNode(); // Delete head
        System.out.println("After deleting head (5):");
        cll.display();

        cll.DeleteLastNode(); // Delete tail
        System.out.println("After deleting tail (30):");
        cll.display();

        cll.DeleteInBetweenList(15); // Delete non-existent
        System.out.println("After attempting to delete non-existent (15):");
        cll.display();

        // Search cases
        System.out.println("Search for 10: " + cll.SearchingNodeByValue(10));
        System.out.println("Search for 100: " + cll.SearchingNodeByValue(100));

        // Sorting
        cll.InsertAtTheLast(50);
        cll.InsertAtTheLast(40);
        cll.InsertAtTheLast(25);
        System.out.println("Before sorting:");
        cll.display();

        cll.sortList();
        System.out.println("After sorting:");
        cll.display();

        // Reversal
        cll.ReversalList();
        System.out.println("After reversing:");
        cll.display();
    }
	
}

class CSLinkedListNode
{
	int data;
	CSLinkedListNode next;
	
	public CSLinkedListNode(int data) 
	{
		this.data = data;
		next = null;
	}	
}