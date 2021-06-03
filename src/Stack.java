
public interface Stack<E> {
	
	void push(E element);
	
	E pop() throws StackUnderflowException;
	
	void clear();
	
	E peek() throws StackUnderflowException;
	
	E get(int index);
	
	int search(E element);
	
	int size();
	
	boolean contains(E element);
	
	boolean empty();
	
	String toString();
}
