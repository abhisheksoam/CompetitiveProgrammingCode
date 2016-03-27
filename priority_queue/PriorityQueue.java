package priority_queue;

import java.util.ArrayList;

public class PriorityQueue<V> {
	ArrayList<Pair<Integer, V>> data;
	public PriorityQueue() {
		data = new ArrayList<>();
		data.add(null);
	}
	
	public Pair<Integer, V> removeMin() throws HeapEmptyException {
		if (isEmpty()) {
			HeapEmptyException e = new HeapEmptyException();
			throw e;
		}
		
		Pair<Integer, V> min = data.get(1);
		data.set(1, data.get(data.size() - 1));
		data.remove(data.size() - 1);
		
		int parentIndex = 1;
		int leftChildI = 2*parentIndex;
		int rightChildI = 2*parentIndex + 1;
		
		while (leftChildI <= data.size() - 1) {
			int indexToBESwappedWith = -1;
			if (data.get(leftChildI).priority < data.get(parentIndex).priority) {
				indexToBESwappedWith = leftChildI;
			}
			
			if (rightChildI <= data.size() - 1) {
				if (data.get(rightChildI).priority < data.get(leftChildI).priority &&
						data.get(rightChildI).priority < data.get(parentIndex).priority) {
					indexToBESwappedWith = rightChildI;
				}
			}
			
			if (indexToBESwappedWith == -1) {
				return min;
			}
			Pair<Integer, V> temp = data.get(parentIndex);
			data.set(parentIndex, data.get(indexToBESwappedWith));
			data.set(indexToBESwappedWith, temp);
			parentIndex = indexToBESwappedWith;
			leftChildI = 2*parentIndex;
			rightChildI = 2*parentIndex + 1;
		}
		return min;
	}
	
	public void insert(int p, V value) {
		Pair<Integer, V> pair = new Pair<>(p, value);
		data.add(pair);
		int childIndex = data.size() - 1;
		int parentIndex = childIndex/2;
		
		while (childIndex > 1) {
			if (data.get(parentIndex).priority > data.get(childIndex).priority) {
				Pair<Integer, V> temp = data.get(parentIndex);
				data.set(parentIndex, data.get(childIndex));
				data.set(childIndex, temp);
				childIndex = parentIndex;
				parentIndex = childIndex/2;
			} else {
				return;
			}
		}
	}
	
	public Pair<Integer, V> min() throws HeapEmptyException {
		if (isEmpty()) {
			HeapEmptyException e = new HeapEmptyException();
			throw e;
		}
		return data.get(1);
	}
	
	public int size() {
		return data.size() - 1;
	}
	
	public boolean isEmpty() {
		if (size() == 0) {
			return true;
		} else {
			return false;
		}
	}
	
	
}
