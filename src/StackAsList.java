
public class StackAsList<E> implements Stack<E> {
	// https://www.youtube.com/watch?v=GFkgtK8eFpo 
	
	private static final int DEFAULT_CAPACITY = 10;
	private E[] store;
	private int size = 0;
	private int capacity;
	
	//constuctor
	public StackAsList() {
		capacity = DEFAULT_CAPACITY;
		store = (E[]) new Object[DEFAULT_CAPACITY];
	}
	
	public StackAsList(int capacity) {
		this.capacity = capacity;
		store = (E[]) new Object[this.capacity];
	}

	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int search(E element) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean contains(E element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean empty() {
		// TODO Auto-generated method stub
		return false;
	}

}
