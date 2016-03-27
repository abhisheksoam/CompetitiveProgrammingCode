package stacks_queues;

public class Stack {
	private int data[];
	private int nextIndex;
	
	public Stack(int n) {
		data = new int[n];
		nextIndex = 0;
	}
	
	public int size() {
		return nextIndex;
	}
	
	public boolean isEmpty() {
		if (size() == 0)
			return true;
		return false;
	}
	
	public int top() throws StackEmptyException {
		if (isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return data[nextIndex -1];
	}
	
	public void push(int next) throws StackFullException {
		if (nextIndex > data.length - 1) {
			StackFullException e = new StackFullException();
			throw e;
		}
			
		data[nextIndex] = next;
		nextIndex++;
	}
	
	public int pop() throws StackEmptyException {
		if (isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		
		nextIndex--;
		return data[nextIndex];
	}
	
	
	
}
