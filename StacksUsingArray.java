package Stacks;

public class StacksUsingArray 
{
	int arr[];
	int top = -1;
	
	int capacity;

	public StacksUsingArray(int size) 
	{
		super();
		this.capacity = size;
		arr = new int[capacity];
		top = -1;
	}
	
	public void push(int item) 
	{
		if(isFull())
		{
			System.out.println("Stack is Full!!...Cannot add"); // stack overflow!
			return;
		}
		arr[++top]=item;
	}

	public void pop()
	{
		if(isEmpty()) 
		{
		    System.out.println("Stack is Empty!!...cannot remove"); // stack underflow!!
		    return;
		}	
		top--;
	}
	
	public void peek() 
	{
		if(isEmpty()) 
		{
		    System.out.println("Stack is Empty!!...cannot peek");	
		    return;
		}
		System.out.println("the top element of the stack is:" + arr[top]);
		
	}
	private boolean isEmpty()
	{
		return top == -1;
	}

	private boolean isFull() 
	{
		return top == capacity -1;
	}	

	public static void main(String[] args) {
		StacksUsingArray sua = new StacksUsingArray(4);
		sua.pop();
		sua.push(24);
		sua.peek();
	}
}
