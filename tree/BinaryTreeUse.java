package trees;

import java.util.Scanner;

import stacks_queues.QueueUsingLL;
import stacks_queues.StackEmptyException;
import stacks_queues.StackUsingLL;

public class BinaryTreeUse {

	// returns lca if both the nodes are found, otherwise it will return whichever node is found
	public static BinaryTreeNode<Integer> lca(BinaryTreeNode<Integer> root, int data1, int data2) {
		if (root == null)
			return null;
		
		if (root.data == data1 || root.data == data2) {
			return root;
		}
		
		BinaryTreeNode<Integer> leftAns = lca(root.left, data1, data2);
		BinaryTreeNode<Integer> rightAns = lca(root.right, data1, data2);
		if (leftAns != null && rightAns != null) {
			return root;
		}
		
		if (leftAns != null) {
			return leftAns;
		}
		return rightAns;
	}
	
	public static void preorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		System.out.println(root.data);
		preorder(root.left);
		preorder(root.right);
	}

	public static void postorder(BinaryTreeNode<Integer> root) {
x		if (root == null)
			return;
		postorder(root.left);
		postorder(root.right);
		System.out.println(root.data);

	}

	public static void inorder(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.println(root.data);
		inorder(root.right);
	}


	public static void print(BinaryTreeNode<Integer> root) {
		if (root == null)
			return;
		String toBeprinted = root.data + ":";
		if (root.left != null)
			toBeprinted += root.left.data + ",";

		if (root.right != null)
			toBeprinted += root.right.data + ",";
		System.out.println(toBeprinted);

		print(root.left);
		print(root.right);
	}

	public static BinaryTreeNode<Integer> takeInputLevelWise() {
		System.out.println("Enter root data");
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		// Nodes for which I haven't taken children info yet
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes  = new QueueUsingLL<>();
		pendingNodes.enqueue(root);

		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> currentNode;
			try {
				currentNode = pendingNodes.dequeue();
			} catch (Exception e) {
				System.out.println("Cant come here");
				return null;
			}
			System.out.println("Enter left child for " + currentNode.data);
			int leftData  = s.nextInt();
			if (leftData != -1) {
				BinaryTreeNode<Integer> left = new BinaryTreeNode<Integer>(leftData);
				pendingNodes.enqueue(left);
				currentNode.left = left;
			}

			System.out.println("Enter right child for " + currentNode.data);
			int rightData  = s.nextInt();
			if (rightData != -1) {
				BinaryTreeNode<Integer> right = new BinaryTreeNode<Integer>(rightData);
				pendingNodes.enqueue(right);
				currentNode.right = right;
			}
		}
		return root;
	}

	public static BinaryTreeNode<Integer> getTreeFromPreAndIn(int[] pre,
			int[] in, int preS, int preE, int inS, int inE) {
		if (inS > inE) {
			return null;
		}

		int rootData = pre[preS];
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);

		int i = inS;
		while (i <= inE) {
			if (in[i] == rootData)
				break;
			i++;
		}

		int leftInStart = inS;
		int leftInEnd = i - 1;
		int rightInStart = i + 1;
		int rightInEnd = inE;

		int leftPreStart = preS + 1;
		int rightPreEnd = preE;

		int leftLength = leftInEnd - leftInStart + 1;
		int leftPreEnd = leftPreStart + leftLength - 1;
		int rightPreStart = leftPreEnd + 1;
		root.left = getTreeFromPreAndIn(
				pre, in, leftPreStart, leftPreEnd, leftInStart, leftInEnd);
		root.right = getTreeFromPreAndIn(
				pre, in, rightPreStart, rightPreEnd, rightInStart, rightInEnd);
		return root;
	}

	public static void printLevelWiseAtDifferentLine3(BinaryTreeNode<Integer> root) {
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
		queue.enqueue(root);
		int currentLevelCount = 1;
		int nextLevelCount = 0;
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> current;

			try {
				current = queue.dequeue();
			} catch (Exception e) {
				System.out.println("Cant come here");
				return;
			}
			System.out.print(current.data + " ");
			currentLevelCount--;
			
			if (current.left != null) {
				nextLevelCount++;
				queue.enqueue(current.left);
			}
			if (current.right != null) {
				nextLevelCount++;
				queue.enqueue(current.right);
			}
			
			if (currentLevelCount == 0) {
				System.out.println();
				currentLevelCount = nextLevelCount;
				nextLevelCount = 0;
			}
		}


	}

	public static void printLevelWiseAtDifferentLine2(BinaryTreeNode<Integer> root) {
		QueueUsingLL<BinaryTreeNode<Integer>> queue = new QueueUsingLL<>();
		queue.enqueue(root);
		queue.enqueue(null);

		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> current;

			try {
				current = queue.dequeue();
			} catch (Exception e) {
				System.out.println("Cant come here");
				return;
			}
			if (current == null) {
				System.out.println();
				if (queue.isEmpty())
					return;
				queue.enqueue(null);
			} else {
				System.out.print(current.data + " ");
				if (current.left != null)
					queue.enqueue(current.left);
				if (current.right != null)
					queue.enqueue(current.right);
			}
		}

	}

	public static void printLevelWiseAtDifferentLine1(BinaryTreeNode<Integer> root) {
		QueueUsingLL<BinaryTreeNode<Integer>> primary = new QueueUsingLL<>();
		QueueUsingLL<BinaryTreeNode<Integer>> secondary = new QueueUsingLL<>();

		primary.enqueue(root);
		while (!primary.isEmpty()) {
			BinaryTreeNode<Integer> current;
			try {
				current = primary.dequeue();
			} catch (Exception e) {
				System.out.println("Not possible");
				return;
			}

			System.out.print(current.data + " ");
			if (current.left != null)
				secondary.enqueue(current.left);
			if (current.right != null)
				secondary.enqueue(current.right);

			if (primary.isEmpty()) {
				System.out.println();
				QueueUsingLL<BinaryTreeNode<Integer>> temp = primary;
				primary = secondary;
				secondary = temp;
			}

		}


	}

	public static int height(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}


	public static int max(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MIN_VALUE;

		int max = root.data;
		int leftMax = max(root.left);
		int rightMax = max(root.right);
		return Math.max(max, Math.max(leftMax, rightMax));

	}


	public static pair diamaterHeight(BinaryTreeNode<Integer> root) {
		if (root == null) {
			pair output = new pair();
			output.diameter = 0;
			output.height = 0;
			return output;
		}

		pair leftOutput = diamaterHeight(root.left);
		pair rightOutput = diamaterHeight(root.right);

		int height = Math.max(leftOutput.height, rightOutput.height) + 1;

		int option1 = leftOutput.height + rightOutput.height;
		int option2 = leftOutput.diameter;
		int option3 = rightOutput.diameter;

		int diameter = Math.max(option1, Math.max(option2, option3));
		pair output = new pair();
		output.height = height;
		output.diameter = diameter;
		return output;
	}

	public static int countNodes(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;
		return 1 + countNodes(root.left) + countNodes(root.right);
	}
	
	public static int diameter(BinaryTreeNode<Integer> root) {
		if (root == null)
			return 0;

		int lh = height(root.left);
		int rh = height(root.right);

		int ld = diameter(root.left);
		int rd = diameter(root.right);
		int option1 = lh + rh;

		return Math.max(option1, Math.max(ld, rd));

	}

	public static void printPairsSumToK(BinaryTreeNode<Integer> root, int k) throws StackEmptyException {
	
		int n = countNodes(root);
		
		StackUsingLL<BinaryTreeNode<Integer>> instack = new StackUsingLL<>();
		StackUsingLL<BinaryTreeNode<Integer>> revstack = new StackUsingLL<>();
		instack.push(root);
		revstack.push(root);
		boolean inOrderNext = true;
		boolean revInOrderNext = true;
		int inorderElement = -1;
		int revinorderElement = -1;
		boolean inFlag = true;
		boolean revInFlag = true;
		
		int nodesCoveredSoFar = 0;
		
		while (nodesCoveredSoFar < n - 1) {
			if (inOrderNext) {
				// find the next element in in order
				boolean done = false;
				while (!done) {
					BinaryTreeNode<Integer> top = instack.top();
					if (inFlag && top.left != null) {
						instack.push(top.left);
						inFlag = true;
					} else {
						try {
							instack.pop();
						} catch (StackEmptyException e) {
							return;
						}
						if (top.right != null) {
							instack.push(top.right);
							inFlag = true;
						}
						inorderElement = top.data;
						inFlag = false;
						done = true;
					}
				}
				
			}
			
			if (revInOrderNext) {
				boolean done = false;
				while (!done) {
					BinaryTreeNode<Integer> top = revstack.top();
					if (revInFlag && top.right != null) {
						revstack.push(top.right);
						revInFlag = true;
					} else {
						try {
							revstack.pop();
						} catch (StackEmptyException e) {
							return;
						}
						if (top.left != null) {
							revstack.push(top.left);
							revInFlag = true;
						}
						revinorderElement = top.data;
						revInFlag = false;
						done = true;
					}
				}
			}
			
			if (inorderElement + revinorderElement == k) {
				System.out.println(inorderElement + " " + revinorderElement);
				inOrderNext = true;
				revInOrderNext = true;
				nodesCoveredSoFar += 2;
			} else if (inorderElement + revinorderElement > k) {
				revInOrderNext = true;
				inOrderNext = false;
				nodesCoveredSoFar++;
			} else {
				inOrderNext = true;
				revInOrderNext = false;
				nodesCoveredSoFar++;
			}
			
		}
		
	}
	
	public static void inorderIter(BinaryTreeNode<Integer> root) {
		StackUsingLL<BinaryTreeNode<Integer>> stack = new StackUsingLL<>();
		
		stack.push(root);
		boolean flag = true;
		while (!stack.isEmpty()) {
			BinaryTreeNode<Integer> top;
			try {
				top = stack.top();
			} catch (StackEmptyException e) {
				return;
			}
			if (flag && top.left != null) {
				stack.push(top.left);
				flag = true;
			} else {
				try {
					stack.pop();
				} catch (StackEmptyException e) {
					return;
				}
				flag = false;
				System.out.println(top.data);
				if (top.right != null) {
					stack.push(top.right);
					flag = true;
				}
			}
		}
		
	}
	
	public static void main(String args[]) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		//print(root);
		//printLevelWiseAtDifferentLine3(root);
		//inorderIter(root);
		try {
			printPairsSumToK(root, 8);
		} catch (StackEmptyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
