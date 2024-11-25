package Queue;

public class PriorityQueue {
    int[] arr;
    int currentIndex;

    public PriorityQueue(int capacity) {
        arr = new int[capacity];
        currentIndex = 0;
    }

    public void insertIntoQueue(int data) {
        if (currentIndex == arr.length) {
            System.out.println("Priority Queue is full");
            return;
        }
        arr[currentIndex] = data;
        currentIndex++;
    }

    public int removeFromQueue() {
        if (currentIndex == 0) {
            System.out.println("Priority Queue is empty");
            return -1;  
        }
        int maxValueIndex = 0;
        for (int i = 1; i < currentIndex; i++) {
            if (arr[i] > arr[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        int maxData = arr[maxValueIndex];
        for (int i = maxValueIndex; i < currentIndex - 1; i++) {
            arr[i] = arr[i + 1];
        }
        currentIndex--;
        return maxData;
    }

    public int peek() {
        if (currentIndex == 0) {
            System.out.println("Priority Queue is empty");
            return -1;  
        }

        int maxValueIndex = 0;
        for (int i = 1; i < currentIndex; i++) {
            if (arr[i] > arr[maxValueIndex]) {
                maxValueIndex = i;
            }
        }
        return arr[maxValueIndex];
    }

    public void printQueue() {
        for (int i = 0; i < currentIndex; i++) {
            System.out.print(arr[i] + "  ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue(5);

        pq.insertIntoQueue(10);
        pq.insertIntoQueue(5);
        pq.insertIntoQueue(20);
        pq.insertIntoQueue(15);
        pq.insertIntoQueue(30);

        // Print the priority queue
        pq.printQueue();

        // Peek at the highest priority element
        System.out.println("Peek: " + pq.peek());

        // Remove the highest priority element
        System.out.println("Removed: " + pq.removeFromQueue());

        // Print the priority queue after removal
        pq.printQueue();

        // Remove another element
        System.out.println("Removed: " + pq.removeFromQueue());

        // Print the priority queue after another removal
        pq.printQueue();
    }
}
