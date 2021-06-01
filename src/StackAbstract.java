
public abstract class StackAbstract<E> {
	public abstract void push(E element);
	public abstract void pop();
	public abstract void clear();
	public abstract E peek();
	public abstract E get(int index);
	public abstract int search(E element);
	public abstract int size();
	public abstract boolean contains(E element);
	public abstract boolean empty();
}
