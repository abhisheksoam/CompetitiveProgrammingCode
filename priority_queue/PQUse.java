package priority_queue;

import java.util.ArrayList;

public class PQUse {

	public static ArrayList<Integer> getKMax(int a[], int k) throws HeapEmptyException {
		int currentElementIndex = 0;
		PriorityQueue<Integer> p = new PriorityQueue<>();
		for (; currentElementIndex <k; currentElementIndex++) {
			p.insert(a[currentElementIndex], a[currentElementIndex]);
		}
		
		for (; currentElementIndex < a.length; currentElementIndex++) {
			if (a[currentElementIndex] > p.min().priority) {
				p.removeMin();
				p.insert(a[currentElementIndex], a[currentElementIndex]);
			}
		}
		ArrayList<Integer> output= new ArrayList<>();
		while (!p.isEmpty()) {
			output.add(p.removeMin().value);
		}
		return output;
	}
	public static void main(String args[]) throws HeapEmptyException {
		java.util.PriorityQueue<Integer> p = new java.util.PriorityQueue<>();
	
		int a[] = {10,9,8,7,61,25,14,3,12,1};
//		ArrayList<Integer> out = getKMax(a, a.length);
//		
//		for (int i = 0; i < out.size(); i++) {
//			System.out.println(out.get(i));
//		}
		
		for (int k :a) {
			p.add(k);
		}
		
		while (!p.isEmpty()) {
				System.out.println(p.poll());
			 
		}
		
	}
}
