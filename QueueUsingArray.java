package Queue;

public class QueueUsingArray 
{
	static int[]arr = new int[5];
	static int front = -1;     // queue is empty
	static int rear = -1;      // empty queue
	
	public void Enqueue(int data) 
	{
		if(rear == arr.length-1) 
		{
			System.out.println("Queue Overflow!");
			return;
		}else 
		{
			if(front == -1 && rear == -1)    // Empty queue
			{
				rear = front = 0;
				
			}else {rear++;}
			
			arr[rear] = data;
			System.out.println(data + "has to be enqueued");
			
		}
	}
	
	public void Dequeue() 
	{
		if(front == -1 || front>rear) {
			System.out.println("Queue Underflow!!...Nothing to dequeue");
			return;
		}
		
		System.out.println(arr[front] + "has been dequeued");
		
		if(front == rear)   // queue contains only one data
		{
			front = rear = -1;
		}else {
			front++;
		}
		
	}
	
	 // Display queue
    public void Display() 
    {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Search for a value in the queue
    
    public void Search(int value) 
    {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty! Cannot search.");
            return;
        }

        for (int i = front; i <= rear; i++) 
        {
            if (arr[i] == value) {
                System.out.println("Value " + value + " found at position " + (i - front + 1));
                return;
            }
        }
        System.out.println("Value " + value + " not found in the queue.");
    }

    // Sort the queue in ascending order
    
    public void SortQueue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty! Cannot sort.");
            return;
        }

        for (int i = front; i <= rear; i++) {
            for (int j = i + 1; j <= rear; j++) {
                if (arr[i] > arr[j]) {
                                            
                    int temp = arr[i];         // Swap arr[i] and arr[j]
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println("Queue has been sorted.");
        Display();
    }

    // Reverse the queue
    public void ReverseQueue() {
        if (front == -1 || front > rear) {
            System.out.println("Queue is empty! Cannot reverse.");
            return;
        }

        int start = front;
        int end = rear;

        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            start++;
            end--;
        }

        System.out.println("Queue has been reversed.");
        Display();
    }
    
    public static void main(String[] args)
    {
        QueueUsingArray queue = new QueueUsingArray();

        // Enqueue operations
        queue.Enqueue(10);
        queue.Enqueue(30);
        queue.Enqueue(20);
        queue.Enqueue(40);

        // Display the queue
        queue.Display(); // Output: Queue: 10 30 20 40

        // Search for an element
        queue.Search(20); // Output: Value 20 found at position 3
        queue.Search(50); // Output: Value 50 not found in the queue.

        // Sort the queue
        queue.SortQueue(); // Output: Queue has been sorted. Queue: 10 20 30 40

        // Reverse the queue
        queue.ReverseQueue(); // Output: Queue has been reversed. Queue: 40 30 20 10

        // Dequeue operations
        queue.Dequeue(); // Output: 40 has been dequeued.
        queue.Display(); // Output: Queue: 30 20 10
    }

}
