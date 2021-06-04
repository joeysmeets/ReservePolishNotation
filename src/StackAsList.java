import java.io.IOException;

public class StackAsList<E> implements Stack<E> {

	private int size = 0;
	private Node first;
	
	//constuctor
	public StackAsList() {
		this.first = null;
	}
	
	//inner class 
	class Node {
		public E data;
		public Node next;
	}	

	@Override
	public void push(E element) {
		//add an element at first position
		Node newNode = new Node();
		newNode.data = element;
		
		if (first != null) {
			newNode.next = first;
		}
		first = newNode;
		size++;
	}

	@Override
	public E pop() throws StackUnderflowException{
		if (!empty()) {
			//get the data field of the first element
			E tmp = first.data;
			//update first element
			first = first.next;
			size--;
			return tmp;
		}else{
			throw new StackUnderflowException("Nothing on the stack to pop.");
		} 
	}

	@Override
	public void clear() { //is it ok to just set first to null instead?
		if (empty()) {return;}
		while (first.next != null) {
			first = first.next;
		}
		//remove last element
		first = null;
		size = 0;
	}

	@Override
	public E peek() throws StackUnderflowException {
		if(!empty()) {
			return first.data;
		}else{
			throw new StackUnderflowException("Stack is empty.");
		}
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean empty() {
		if (first != null) {return false;}
		else {return true;}
	}
	
	@Override
	public String toString() {
		String r = "";
		Node position;
		
		if (this.empty()) {
			return r;
		}else{
			position = first;
		}
		
		while (position.next != null) {
			r += position.data;
			r += ", ";
			position = position.next;
		}
		
		//add the last node's data
		r += position.data;
		return r;
	}
	
	public static void main(String[] args) throws StackUnderflowException, IOException {
		/*StackAsList<Integer> ints = new StackAsList<Integer>();
		ints.push(1);
		ints.push(2);
		ints.push(3);
		ints.push(4);
		ints.push(5);
		System.out.println(ints.toString());
		ints.pop(); //pop the 5
		System.out.println(ints.peek());
		System.out.println(ints.toString());
		System.out.println("Size: " + ints.size());
		ints.clear();
		System.out.println("toString after clear: " + ints.toString());
		System.out.println("Size: " + ints.size());
		
		
		StackAsList<String> strings = new StackAsList<String>();
		strings.push("string1");
		strings.push("string2");
		strings.push("string3");
		System.out.println(strings.size());
		System.out.println(strings.toString());
		strings.clear();
		strings.peek();*/ //should throw exception
		
		Postfix tester = new Postfix();
		String testInfix = "1 2 + 3 - - -"; //incorrectly formed
		System.out.println(tester.infixToPostfix(testInfix));
		
		System.out.println(tester.evaluate("123*+"));
		tester.evaluateInfixFromConsole();
	}
	
}
