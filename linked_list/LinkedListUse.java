package linked_list;

import java.util.Scanner;

public class LinkedListUse {

	public static void printLL(Node<Integer> head11) {
		while (head11 != null) {
			System.out.print(head11.data + "-->");
			head11 = head11.next;
		}
	}
	
	public static Node<Integer> reverseIter(Node<Integer> head) {
		if (head == null || head.next == null)
			return head;
		Node<Integer> prev = null;
		Node<Integer> current = head;
		while (current != null) {
			Node<Integer> temp = current.next;
			current.next = prev;
			prev = current;
			current = temp;
		}
		return prev;
	}
	
	public static Node<Integer> reverseBetter2(Node<Integer> head) {
		if (head == null || head.next == null) 
			return head;
		Node<Integer> smallRev = reverseBetter2(head.next);
		head.next.next = head;
		head.next = null;
		return smallRev;
	}
	
	public static DoubleNode reverseBetter(Node<Integer> head) {
		if (head == null || head.next == null)  {
			DoubleNode output = new DoubleNode();
			output.head = head;
			output.tail = head;
			return output;
		}
		
		DoubleNode smallerReversed = reverseBetter(head.next);
		smallerReversed.tail.next = head;
		head.next = null;
		DoubleNode output = new DoubleNode();
		output.head = smallerReversed.head;
		output.tail = head;
		return output;
	}
	
	public static Node<Integer> reverse(Node<Integer> head) {
		if (head == null || head.next == null) 
			return head;
		
		Node<Integer> smallerReversed = reverse(head.next);
		
		Node<Integer> temp = smallerReversed;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = head;
		head.next = null;
		return smallerReversed;
	}
	

	public static Node<Integer> delete(Node<Integer> head, int position) {
		if (position == 0) {
			return head.next;
		}

		Node<Integer> temp = head;
		while (position != 1) {
			temp = temp.next;
			position--;
		}
		temp.next = temp.next.next;
		return head;
	}

	public static Node<Integer> deleteR(Node<Integer> head, int position) {
		if (position == 0) {
			return head.next;
		}
		head.next = deleteR(head.next, position - 1);
		return head;
	}

	public static Node<Integer> insert(Node<Integer> head, int position, int element) {
		Node<Integer> newNode = new Node<Integer>(element);
		if (position == 0) {
			newNode.next = head;
			return newNode;
		}

		Node<Integer> temp = head;
		while (position != 1) {
			temp = temp.next;
			position--;
		}

		newNode.next = temp.next;
		temp.next = newNode;
		return head;
	}

	public static Node<Integer> takeInput() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter head");
		int input = s.nextInt();
		Node<Integer> head = null;
		Node<Integer> tail = null;

		while (input != -1) {
			Node<Integer> nextNode = new Node<>(input);
			if (head == null) {
				head = nextNode;
				tail = nextNode;
			} else {
				tail.next = nextNode;
				tail = nextNode;
			}
			System.out.println("Enter next");
			input = s.nextInt();
		}
		return head;
	}

	public static Node<Integer> insertR(Node<Integer> head, int position, int element) {
		if (position == 0) {
			Node<Integer> newNode = new Node<Integer>(element);
			newNode.next = head;
			return newNode;
		}
		Node<Integer> temp = insertR(head.next, position -1, element);
		head.next = temp;
		return head;
	}

	public static int lengthR(Node<Integer> head) {
		if (head == null)
			return 0;
		return 1 + lengthR(head.next);
	}

	public static int length(Node<Integer> head) {
		int size = 0;
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}

	public static int find(Node<Integer> head, int element) {
		if (head == null) {
			return -1;
		}
		if (head.data == element) {
			return 0;
		}
		int index = find(head.next,element);
		if (index == -1)
			return -1;
		else
			return 1 + index;
	}

	public static Node<Integer> midNode(Node<Integer> head) {
		if (head == null) {
			return null;
		}

		Node<Integer> slow = head;
		Node<Integer> fast = head.next;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		return slow;
	}

	public static Node<Integer> bubbleSort(Node<Integer> head) {

		int n = lengthR(head);

		for (int i = 0; i < n-1; i++) {
			Node<Integer> temp = head;
			Node<Integer> prev = null;

			while (temp != null && temp.next != null) {
				if (temp.data > temp.next.data) {
					if (prev== null) {
						head = temp.next;
						temp.next = temp.next.next;
						head.next = temp;
						prev = head;
					} else {
						Node<Integer> nextNext = temp.next.next;
						temp.next.next = temp;
						prev.next = temp.next;
						temp.next = nextNext;
						prev = prev.next;
						
					}
				} else {
					prev = temp;
					temp = temp.next;
				}
			}

		}
		return head;
	}


	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		printLL(head);
		//head = insert(head, 1, 18);
		System.out.println();
		head = reverse(head);
		printLL(head);
	}

}
