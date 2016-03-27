 package maps;

import java.util.ArrayList;

import linked_list.Node;

public class Map<K,V> {
	ArrayList<Node<pair<K, V>>> buckets;
	int count;
	int numBuckets;

	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 10;
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
		count = 0;
	}
	
	public Map(int expectedSize) {
		buckets = new ArrayList<>();
		numBuckets = 2*expectedSize;
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
		count = 0;
	}
	
	
	public int size() {
		return count;
	}
	
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	private int getBucketNumber(K key) {
		int hashCode = key.hashCode();
		int bucketNumber = hashCode % numBuckets;
		return bucketNumber;
	}
	
	public boolean remove(K key) {
		int bucketNumber = getBucketNumber(key);
		Node<pair<K, V>> head = buckets.get(bucketNumber);
		Node<pair<K,V>> prev = null;
		
		while (head != null) {
			if (head.data.key.equals(key)) {
				// Remove
				if (prev != null) {
					prev.next = head.next;
				} else {
					buckets.set(bucketNumber, head.next);
				}
				count--;
				return true;
			}
			prev = head;
			head = head.next;
		}
		return false;
	}
	
	public boolean constainKey(K key) {
		if (get(key) != null) {
			return true;
		} else {
			return false;
		}
	}
	
	public V get(K key) {
		int bucketNumber = getBucketNumber(key);
		Node<pair<K, V>> head = buckets.get(bucketNumber);
		while (head != null) {
			if (head.data.key.equals(key)) {
				return head.data.value;
			}
			head = head.next;
		}
		return null;
	}
	
	private void rehash() {
		ArrayList<Node<pair<K, V>>> temp = buckets;
		buckets = new ArrayList<>();
		numBuckets = 2*numBuckets;
		count = 0;
		for (int i = 0; i < numBuckets; i++) {
			buckets.add(null);
		}
		
		
		for (Node<pair<K,V>> head: temp) {
			while (head != null) {
				put(head.data.key, head.data.value);
				head = head.next;
			}
		}
	}
	
	public void put(K key, V value) {
		int bucketNumber = getBucketNumber(key);
		
		Node<pair<K, V>> head = buckets.get(bucketNumber);
		while (head != null) {
			if (head.data.key.equals(key)) {
				head.data.value = value;
				return;
			}
			head = head.next;
		}
		
		head = buckets.get(bucketNumber);
		
		pair<K,V> newNodeData = new pair<>();
		newNodeData.key = key;
		newNodeData.value = value;
		
		Node<pair<K, V>> newNode = new Node<pair<K,V>>(newNodeData);
		newNode.next = head;
		buckets.set(bucketNumber, newNode);
		count++;
		if ((count*1.0)/numBuckets > 0.7) {
			rehash();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
