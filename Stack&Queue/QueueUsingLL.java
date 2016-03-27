package stacks_queues;

import linked_list.Node;

public class QueueUsingLL <T>{
	
	private Node<T> head;
	private Node<T> tail;
	private int count;
	
	public int size(){
		return count;
	}
	
	public boolean isEmpty(){
		if (size()==0) {
			return true;
		}
		
		return false;
		
	}
	
	
	public T front() throws Exception{
		if (size()==0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		
		return head.data;
		
	}

	public void enqueue(T nextElement){
		Node <T> newNode= new Node<T>(nextElement);
		if (size()==0){
			head =newNode;
			tail=newNode;
			count++;
		}
		
		else {
		tail.next= newNode;
		tail =tail.next;
		tail.next=null;
		count++;
		}
	}
	
	public T  dequeue() throws Exception{
		if (size()==0){
			QueueEmptyException e = new QueueEmptyException();
			throw e;
		}
		
		T returnValue = head.data;
		head = head.next;
		count--;
		return returnValue;
	}
	
	
}
