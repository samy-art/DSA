package LinkedList;

public class CircularlyDoublyLinkedList 
{
	static CDLinkedListNode head;
    static CDLinkedListNode tail;
	
    public void InsertAtBeginning(int data)
    {
    	CDLinkedListNode newnode = new CDLinkedListNode(data);
    	
    	if(head == null)
    	{
    		System.out.println("List is empty!");
    		newnode.next = newnode;
    		newnode.prev = newnode;
    		head = tail = newnode;
    		return;
    	}
    	
    	head = tail.next;
    	tail = head.prev;
    	
    	newnode.next = head;
    	newnode.prev = tail;
    	head.prev = newnode;
    	tail.next = newnode;
    	
    	head = newnode;	
    }
    
    public void InsertAtLast(int data)
    {
    	CDLinkedListNode newnode = new CDLinkedListNode(data);
    	
    	if(head == null)
    	{
    		System.out.println("List is empty!");
    		newnode.next = newnode;
    		newnode.prev = newnode;
    		head = newnode;
    		tail = newnode;
    		return;
    	}
    	
    	tail = head.prev;
    	
    	tail.next = newnode;
    	newnode.prev = tail;
    	head.prev = newnode;
    	newnode.next = head;
    	
    	tail = newnode;	
    }
    
    public void InsertInbetween(int data, int value)
    {
        CDLinkedListNode newnode = new CDLinkedListNode(data);
    	
    	if(head == null)
    	{
    		System.out.println("List is empty!");
    		return;
    	}
    	
    	CDLinkedListNode temp = head;
    	
    	do {
    		if(temp.data == value) 
    		{
    			newnode.next = temp.next;
    			newnode.prev = temp;
    			temp.next.prev = newnode;
    			temp.next = newnode;
    			
    			if(temp == tail) 
    			{
    				tail = newnode;
    			}	
    			return;
    		}
    		temp = temp.next;
    	}while(temp != head);	
    }
    
    public void DeleteFirstNode()
    {
    	if(head == null)
    	{
    		System.out.println("List is empty!...Nothing to delete");
    		return;
    	}
    	
    	if(head == tail) {
    		head = null;
    		tail = null;
    		return;
    	}
    	
    	head = head.next;  // head is updated
    	head.prev = tail;
    	tail.next = head;
    }
    
    public void DeleteLastNode() 
    {
    	if(head == null)
    	{
    		System.out.println("Nothing to delete : List is empty!");
    		return;
    	}
    	
    	if(head == tail) {
    		head = tail = null;
    		return;
    	}
    	
    	tail = tail.prev;
    	tail.next = head;
    	head.prev = tail;
    }
    
    public void DeleteInBetween(int data, int value) 
    {
    	if(head == null)
    	{
    		System.out.println("Nothing to delete : List is empty!");
    		return;
    	}
    	
    	CDLinkedListNode temp = head;
    	
    	do {
    		if(temp.data == value)
    		{
    			if(head == tail) 
    			{
    				head = tail = null;
    				return;
    			}
    			
    			temp.prev.next = temp.next;
    			temp.next.prev = temp.prev;
    			
    			if(temp == head) {
    				head = temp.next;
    				
    			}
    			
    			if(temp == tail) {
    				tail = temp.prev;
    				
    			}
    		}
    		temp = temp.next;
    	}while(temp != head);
    	
    }
    
    public void SearchByValue(int value)
    {
        if (head == null) {
            System.out.println("Empty List!");
            return;
        }

        CDLinkedListNode temp = head;

        
        do {
            if (temp.data == value)
            {
                System.out.println("Value " + value + " found in the list.");
                return;
            }
            temp = temp.next;
        } while (temp != head); 

        // If the value is not found
        System.out.println("Value " + value + " not found in the list.");
    }
    
    public void sortList() 
    {
    	if(head == null || head == tail) {
    		System.out.println(" Nothing to sort ");
    		return;
    	}
    	
    	boolean swapped;
    	
    	
    	do {
    		swapped = false;
    		CDLinkedListNode temp = head;
    		
    		while(temp != tail)
    		{
    			if(temp.data>temp.next.data)
        		{
        			int var = temp.data;
        			temp.data = temp.next.data;
        			temp.next.data = var;
        			swapped = true;
        		}
    			temp  =temp.next;	
    		}	
    	}while(swapped);
    }
    
    public CDLinkedListNode ReversalList()
    {
    	if(head == null || head == tail) {
    		return head;
    	}
    	
    	CDLinkedListNode temp = head;
    	CDLinkedListNode prev = null;
    	CDLinkedListNode next;
    	
    	do {
    		
    		next = temp.next;
    		temp.next = prev;
    		temp.prev = next;
    		prev = temp;
    		temp = next;
    		
    	}while(temp != head);
    	
    	tail = head;
    	head = prev;
    	
    	head.prev = tail;
    	tail.next = head;
    	
    	System.out.println("List has been reversed");
    	return head;
    }
    
    public void DisplayList() {
        if (head == null) {
            System.out.println("List is Empty!");
            return;
        }

        CDLinkedListNode temp = head;
        System.out.print("List: ");

        do {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("HEAD"); // Indicate circular nature
    }

    
    public static void main(String[] args)
    {
    	CircularlyDoublyLinkedList list = new CircularlyDoublyLinkedList();

        // Add nodes
        list.InsertAtLast(5);
        list.InsertAtLast(3);
        list.InsertAtLast(8);
        list.InsertAtLast(1);

        // Display original list
        list.DisplayList(); // Output: 5 3 8 1

        // Search for a value
        list.SearchByValue(3); // Output: Value 3 found in the list!

        // Sort the list
        list.sortList();
        list.DisplayList(); // Output: 1 3 5 8

        // Reverse the list
        list.ReversalList();
        list.DisplayList(); // Output: 8 5 3 1

        // Search for a value not in the list
        list.SearchByValue(10); // Output: Value 10 not found in the list!
    }


	

}

class CDLinkedListNode
{
	int data;
	CDLinkedListNode next;
	CDLinkedListNode prev;
	
	public CDLinkedListNode(int data) 
	{
		super();
		this.data = data;
		prev = next = null;
	}
	
	
	
}