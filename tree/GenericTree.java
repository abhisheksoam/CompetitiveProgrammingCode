package trees;

import java.util.Scanner;

import linked_list.DoubleNode;
import stacks_queues.QueueUsingLL;

public class GenericTree {

	public static TreeNode<Integer> takeInputLevelWise() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		
		// Nodes for which I haven't taken children info yet
		QueueUsingLL<TreeNode<Integer>> pendingNodes  = new QueueUsingLL<>();
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			TreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (Exception e) {
				System.out.println("Cant come here");
				return null;
			}
			System.out.println("Enter number of children of " + currentNode.data);
			int n = s.nextInt();
			for (int i = 0; i < n; i++) {
				System.out.println("Enter " + i + "th child of " + currentNode.data);
				int childData = s.nextInt();
				TreeNode<Integer> child = new TreeNode<Integer>(childData);
				currentNode.children.add(child);
				pendingNodes.enqueue(child);
			}
		}
		return root;
		
	}
	
//	public static int secondLargest(TreeNode<Integer> root) {
//		DoubleTreeNode d = findTopTwo(root);
//		return d.second.data;
//	}
//	
//	private static DoubleTreeNode<Integer> findTopTwo(TreeNode<Integer> root) {
//		
//	}

	public static void preorder(TreeNode<Integer> root) {
		System.out.println(root.data);
		for (TreeNode<Integer> child: root.children) {
			preorder(child);
		}
	}
	
	public static void postorder(TreeNode<Integer> root) {
		for (TreeNode<Integer> child: root.children) {
			postorder(child);
		}
		System.out.println(root.data);
	}
	
	
	public static void replaceWithDepth(TreeNode<Integer> root, int k) {
		root.data = k;
		for (TreeNode<Integer> child: root.children) {
			replaceWithDepth(child, k + 1);
		}
	}
	
	public static void replaceWithDepth(TreeNode<Integer> root) {
		replaceWithDepth(root, 0);
	}
	
	
	public static void printAtK(TreeNode<Integer> root, int k) {
		if (k == 0) {
			System.out.println(root.data);
			return;
		}
		for (int i = 0; i < root.children.size(); i++) {
			printAtK(root.children.get(i), k - 1);
		}
	}
	
	public static TreeNode<Integer> maxNode(TreeNode<Integer> root) {
		TreeNode<Integer> maxNode = root;
		for (int i = 0; i < root.children.size(); i++) {
			TreeNode<Integer> bestInChild = maxNode(root.children.get(i));
			if (bestInChild.data > maxNode.data) {
				maxNode = bestInChild;
			}
		}
		return maxNode;
	}
	
	public static int height(TreeNode<Integer> root) {
		int max = 0;
		for (int i = 0; i < root.children.size(); i++) {
			int childHeight = height(root.children.get(i));
			if (childHeight > max) {
				max = childHeight;
			}
		}
		return 1 + max;
	}
	
	public static TreeNode<Integer> takeInput() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		
		System.out.println("Enter number of children of " + rootData);
		int n = s.nextInt();
		for (int i = 0; i < n; i++) {
			TreeNode<Integer> child = takeInput();
			root.children.add(child);
		}
		return root;
	}
	
	public static void printTree(TreeNode<Integer> root) {
		String toBePrinted = root.data + ":";
		for (int i = 0; i < root.children.size(); i++) {
			toBePrinted += root.children.get(i).data + ",";
		}
		System.out.println(toBePrinted);
		for (int i = 0; i < root.children.size(); i++) {
			printTree(root.children.get(i));
		}
	}
	
	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		printTree(root);
	}

}
