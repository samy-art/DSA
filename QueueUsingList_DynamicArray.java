package Queue;

public class QueueUsingList_DynamicArray 
{
	int arr[];
	int capacity;
	int presentLength; // how much of an array is being used now
	
	public QueueUsingList_DynamicArray()
	{
		arr = new int[5];
		capacity = 5;
		presentLength = 0;
	}
	
	public void Insert(int data) 
	{
		if(presentLength==capacity) {
			int temp[]=new int[2*capacity];
			for(int i=0; i<capacity;i++) {
				temp[i]=arr[i];  //copy the elements
			}
			capacity = 2*capacity;
			arr =temp;
		}
		
		arr[presentLength] = data;
		presentLength++;
	}
	
	public int GetElement(int index)
	{
		if(index<presentLength) 
		{
			return arr[index];
		}
		System.out.println("Index out of bound!!");
		return -1;
	}
	
	public void Delete() {
		presentLength--;
	}
	
	public void display() {
	    if (presentLength == 0) {
	        System.out.println("Queue is empty!");
	    } else {
	        System.out.print("Queue contents: ");
	        for (int i = 0; i < presentLength; i++) {
	            System.out.print(arr[i] + " ");
	        }
	        System.out.println();
	    }
	}
	
	public static void main(String[] args) 
	{
		QueueUsingList_DynamicArray q = new QueueUsingList_DynamicArray();
		q.Insert(10);
		q.Insert(39);
		q.Insert(50);
		
		q.display();
		
		q.Delete();
		q.display();
		
	}

}
