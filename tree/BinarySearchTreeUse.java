package trees;

public class BinarySearchTreeUse {

	public static int min(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MAX_VALUE;
		return Math.min(min(root.right),Math.min(root.data, min(root.left)));
	}
	
	public static int max(BinaryTreeNode<Integer> root) {
		if (root == null)
			return Integer.MIN_VALUE;
		return Math.max(max(root.right),Math.max(root.data, max(root.left)));
	}
	
	public static boolean isBST3(BinaryTreeNode<Integer> root, int min, int max) {
		if (root == null)
			return true;
		
		if (root.data < min || root.data > max) {
			return false;
		}
		boolean isLeftBST = isBST3(root.left, min, root.data);
		boolean isRightBST = isBST3(root.right,root.data + 1, max);
		return isLeftBST && isRightBST;
	}
	
	
	
	public static boolean isBST3(BinaryTreeNode<Integer> root) {
		return isBST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	// Returns min max if isBST is true else min max is not calculated
	public static BSTReturnType isBST2(BinaryTreeNode<Integer> root) {
		if (root == null) {
			BSTReturnType output = new BSTReturnType();
			output.isBST = true;
			output.min = Integer.MAX_VALUE;
			output.max = Integer.MIN_VALUE;
			return output;
		}
		BSTReturnType leftOutput = isBST2(root.left);
		BSTReturnType rightOutput = isBST2(root.right);
		if (!leftOutput.isBST || !rightOutput.isBST ) {
			BSTReturnType output = new BSTReturnType();
			output.isBST = false;
			return output;
		}
		
		if (root.data < leftOutput.max || root.data > rightOutput.min) {
			BSTReturnType output = new BSTReturnType();
			output.isBST = false;
			return output;
		}
		
		BSTReturnType output = new BSTReturnType();
		output.isBST = true;
		output.min = Math.min(leftOutput.min, root.data);
		output.max = Math.max(rightOutput.max, root.data);
		return output;
		
		
		
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if (root == null)
			return true;
		
		if (root.data < max(root.left)) {
			return false;
		}
		
		if (root.data > min(root.right)) {
			return false;
		}
		
		return isBST(root.right) && isBST(root.left);
	}
	
	public static BinaryTreeNode<Integer> findElement(BinaryTreeNode<Integer> bstRoot, int element) {
		if (bstRoot == null) {
			return null;
		}
		
		if (bstRoot.data == element) {
			return bstRoot;
		} else if (bstRoot.data > element) {
			return findElement(bstRoot.left, element);
		} else {
			return findElement(bstRoot.right, element);
		}
	}
	
	public static void main(String[] args) {
		
	}

}
