package stacks_queues;

import linked_list.Node;

public class StackUsingLL<T> {
	private Node<T> head;
	private int count;
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public T top() throws StackEmptyException {
		if (isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		return head.data;
	}
	
	public T pop() throws StackEmptyException {
		if (isEmpty()) {
			StackEmptyException e = new StackEmptyException();
			throw e;
		}
		T temp = head.data;
		head = head.next;
		count--;
		return temp;
	}
	
	public void push(T data) {
		Node<T> newNode = new Node<T>(data);
		newNode.next = head;
		head = newNode;
		count++;
	}
	
}
