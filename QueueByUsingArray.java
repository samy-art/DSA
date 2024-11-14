package Queue;

public class QueueByUsingArray 
{
	static int arr[]= new int[5];
	
	static int front = -1;
	static int rear = -1;
	
	// Enqueue
	
	public void Enqueue(int data) 
	{
		if(rear == arr.length-1) {
			System.out.println("queue overflow!!");
		}else {
			if(front==-1 && rear == -1) {   //queue empty
				front = 0; rear = 0;
			}else rear++;
			arr[rear] = data;
			System.out.println("engueued data:" + data);
		}
	}
	
	// Dequeue
	
	public void Dequeue()
	{
		if (front == -1 || front > rear) 
		{
			System.out.println("Queue underflow!!");
		}
		
		if (front == rear) {    // queue has only one element
			front = rear =-1;   //  now empty queue
		}
		System.out.println("Dequeued data: " + arr[front]);
		front++;
			
	}

	public void display() 
	{
        if (front == -1 || front > rear) 
        {
            System.out.println("Queue is empty!");
        } else 
        {
            System.out.print("Queue contents: ");
            for (int i = front; i <= rear; i++) 
            {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
	
	
	public static void main(String[] args)
	{
		QueueByUsingArray q  = new QueueByUsingArray();
		
		q.Enqueue(10);
		q.Enqueue(22);
		q.Enqueue(75);
		q.Enqueue(45);
		q.display();
		q.Dequeue();
		q.display();
		
		
		
	}
	
}
