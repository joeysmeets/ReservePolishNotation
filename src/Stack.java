
public interface Stack<E> {
	
	void push(E element);
	
	void pop();
	
	void clear();
	
	E peek();
	
	E get(int index);
	
	int search(E element);
	
	boolean contains(E element);
	
	boolean empty();
}
