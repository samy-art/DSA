package Stacks;

public class StackUsingList
{
	static LinkedListNode head;
	
	public void push(int data)
	{
		LinkedListNode newnode  = new LinkedListNode(data);
		newnode.next = head;
		head = newnode;
		System.out.println("pushed stack:" + newnode.data);
		return;
		
	}
	
	public void pop() 
	{
		if(head == null)
		{
			System.out.println("stack underflow!!");	
		}
		
		LinkedListNode temp = head;
		System.out.println("popped out stack:" + temp.data);
		head=head.next;
		temp = null;
		return;
	}
	
	
	public static void main(String[] args) 
	{
		StackUsingList sll = new StackUsingList();
		sll.push(30);
		sll.pop();
		
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