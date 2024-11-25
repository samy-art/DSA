package Queue;

public class CircularQueue
{
	static int[]arr;
	static int front = -1;
	static int rear = -1;
    int size;
    
	public CircularQueue(int size)
	{
		super();
		this.size = size;
		arr = new int[size];
	}
	
	public void Enqueue(int data) 
	{
		if((rear + 1) % size == front)
		{
			System.out.println("Queue overflow");
			return;
		}
		
		if(front == -1) {
			System.out.println("Queue is empty!");
			front = 0;
		}
		
		rear = (rear + 1) % size;
		arr[rear] = data;
		
		System.out.println(data + "has been enqueued");
		
	}
    
	public void Dequeue() 
	{
		if(front == -1) 
		{
			System.out.println("Queue Underflow!!");   // empty queue
			return;
		}
		
		System.out.println(arr[front] + "has been dequeued");
		
		if(front == rear) 
		{
			front = rear = -1;
		}else {
			front = (front + 1) % size;   //wraps around to 0 index
		}	
	}
    
	public void DisplayQueue() 
	{
		if(front == -1) 
		{
			System.out.println("Queue Underflow!!...Nothing to display");   // empty queue
			return;
		}
		
//		for(int i=front; ; i = (i+1) % size) 
//		{
//			System.out.println(arr[i] + " " );
//			if(i==rear)
//				break;
//		}
		
		int i = front;
		while(true) {
			System.out.print(arr[i] + " ");
			
			if(i == rear)
				break;
			
			i = (i+1) % size;
		}
		System.out.println();
	}
	
	public void Search(int value) 
	{
		if(front == -1) 
		{
			System.out.println("Queue Underflow!!...Nothing to search");   // empty queue
			return;
		}
		
		int i = front;
		while(true) 
		{
			if(arr[i] == value) {
				System.out.println(value + " value found!");
			}
			
			if(i == rear)
				break;
			
			i = (i+1) % size;	
		}
		
		System.out.println(" value not found!");
	}
	
	public void Sort() {
	    if (front == -1) { // Empty queue
	        System.out.println("Queue Underflow!!...Nothing to sort");
	        return;
	    }

	    // Step 1: Extract all elements from the circular queue
	    int n = (rear >= front) ? rear - front + 1 : size - front + rear + 1;
	    int[] temp = new int[n];
	    int index = 0;

	    for (int i = front; ; i = (i + 1) % size) {
	        temp[index++] = arr[i];
	        if (i == rear) break;
	    }

	    // Step 2: Sort the extracted elements
	    java.util.Arrays.sort(temp);

	    // Step 3: Refill the queue with sorted elements
	    front = 0;
	    rear = n - 1;
	    for (int i = 0; i < n; i++) {
	        arr[i] = temp[i];
	    }

	    System.out.println("Queue has been sorted!");
	}

	
	public void reverseQueue() 
	{
		if(front == -1) {
			System.out.println("Queue empty...nothing to reverse");
			return;
		}
		
		int start = front;
		int end = rear;
		
		while(start != end && (end + 1)%size != start) 
		{
			int temp = arr[start];
			arr[start] = arr[end];
			arr[end] = temp;
			
			start = (start + 1)% size;
			end = (end - 1 + size)%size;
			
		}
		System.out.println("Queue Reversed");
	}

	public static void main(String[] args) 
	{
	    CircularQueue queue = new CircularQueue(5);

	    queue.Enqueue(10);
	    queue.Enqueue(20);
	    queue.Enqueue(30);
	    queue.Enqueue(40);
	    queue.DisplayQueue(); // Queue: 10 20 30 40

	    queue.Search(20); // Value 20 found at position: 1
	    queue.Search(50); // Value 50 not found in the queue.

	    queue.Sort(); // Queue has been sorted in ascending order. Queue: 10 20 30 40
	    queue.DisplayQueue();
	    queue.reverseQueue(); // Queue has been reversed. Queue: 40 30 20 10
	    queue.DisplayQueue();
	}

}
