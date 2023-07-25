//21101989 황지연

public class Queue {
	private int[] elements;
	private int size;
	public static final int DEFAULT_CAPACITY = 8;

	public Queue() {
		this(DEFAULT_CAPACITY);
	}

	public Queue(int capacity) {
		elements = new int[capacity];
	}

	public void enqueue(int v) {
		if (size >= elements.length) {
			int[] temp = new int[elements.length * 2];
			System.arraycopy(elements, 0, temp, 0, elements.length);
			elements = temp;
		}

		elements[size++] = v;
	}

	public int dequeue() {
		int first_element = elements[0];
		for (int i = 1; i < size; i++) {
			elements[i - 1] = elements[i];
		}

		size--;
		return first_element;
	}

	public boolean empty() {
		return size == 0;
	}

	public int getSize() {
		return size;
	}
	
	public static void main(String[] args) {
		Queue queue = new Queue();
		for (int i = 1; i<=20; i++)
			queue.enqueue(i);
		
		while (!queue.empty())
			System.out.print(queue.dequeue()+" ");
		
	}

}


