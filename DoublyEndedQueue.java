package Queue;

import java.util.Scanner;

public class DoublyEndedQueue 
{
	int n=5;
	int[] queue=new int[5];
	int f=-1;
	int r=-1;
	
	public void enqueuefront(int x)
	{
		if(f==0 && r==n-1||f==r+1)
		{
			System.out.println("Queue full");
		}
		else if(f==-1 && r==-1)   // empty queue
		{
			f=0;r=0;
			queue[f]=x;
		
		}
		else if(f==0)
		{
			f=n-1;           // wrap around
			queue[f]=x;

		}
		else
		{
			f--;
			queue[f]=x;
			
		}
	}

	public void enqueuerear(int x)
	{
		if(f==0 && r==n-1 || f==r+1)
		{
			System.out.println("Queue full");
		}
		else if(f==-1 && r==-1)
		{
			f=0;
			r=0;
			queue[r]=x;
			
		}
		else if(r==n-1)
		{
			r=0;
			queue[r]=x;
		}
		else
		{
			r++;
			queue[r]=x;
		}
	}

	public void deletefront()
	{
		if(f==-1 && r==-1)
		{
			System.out.println("queue empty");
		}
		else if(f==r)
		{
			System.out.println(queue[f]);
			f=-1;
			r=-1;
		}
		else if(f==n-1)
		{
			System.out.println(queue[f]);
			f=0;
			
		}
		else 
		{
			System.out.println(queue[f]);
			f++;
		}
	}

	void deleterear()
	{
		if(f==-1 && r==-1)
		{
			System.out.println("queue empty");
		}
		else if(f==r)
		{
			System.out.println(queue[r]);
			f=-1;
			r=-1;
		}
		else if(r==0)
		{
			System.out.println(queue[r]);
			r=n-1;
		}
		else
		{
			System.out.println(queue[r]);
			r--;
		}
	}

	public void display()
	{
		int i = f;
		while(true)
		{
			System.out.print(queue[i] + " ");
			if(i==r)
				break;
			i=(i+1)%n;
		}
		System.out.println();
	}

	public void search(int target)
	{
		int i=f;
		boolean found = false;
		while(true)
		{
			if(queue[i]==target)
			{
				System.out.println("target found");
				found=true;
				break;
			}
			if(i==r)
				break;
			i=(i+1)%n;
		}
		if(!found)
		{
		System.out.println("target not found");
		}
		
	}

	public void sort()
	{
		for(int i=f;i!=r;i=(i+1)%n)
		{
			for(int j=f;j!=r;j=(j+1)%n)
			{
				int next=(j+1)%n;
				if(queue[j]>queue[next])
				{
					int temp=queue[j];
					queue[j]=queue[next];
					queue[next]=temp;
				}
			}
		}
		System.out.println("sorted queue");
		display();
	}

	public void reverse()
	{
		if (f == -1) {
	            System.out.println("Deque is empty");
	            return;
	        }
		int start=f;
		int end=r;
		
		while(start!=end && (end+1)%n!=start) 
		{
			int temp=queue[start];
			queue[start]=queue[end];
			queue[end]=temp;
			
			start=(start+1)%n;
			end=(end-1+n)%n;
			
		}
		
		System.out.println("reversed");
		display();
		
		
	}

public static void main(String[] args) {
		
	DoublyEndedQueue dq = new DoublyEndedQueue();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("1.enqueue front 2. enqueue rear 3. dequeue front 4.dequeu rear 5. display 6.search 7.sort 8.reverse");
			int choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter the item to add");
				int item=sc.nextInt();
				dq.enqueuefront(item);
				break;
				
			case 2:
				System.out.println("Enter the item to add");
				item=sc.nextInt();
				dq.enqueuerear(item);
				break;

				
			case 3:
				dq.deletefront();
				break;
				
			case 4:
				dq.deleterear();
				break;
				
			case 5:
				dq.display();
				break;
				
			case 6:
				System.out.println("Enter the target");
				int target=sc.nextInt();
				dq.search(target);
				break;
				
			case 7:
				dq.sort();
				break;
				
			case 8:
				dq.reverse();
				break;

				
			default:
				System.out.println("Invalid inputs");
			}
		}

	}

}

