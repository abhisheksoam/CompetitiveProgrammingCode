package stacks_queues;

public class SQUse {

	public static boolean isBalanced(String input)  {
		StackUsingLL<Character> stack = new StackUsingLL<>();

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);
			try {
				if (current == '{' || current == '(' || current == '[') {
					stack.push(current);
				} else if (current == '}') {
					if (stack.pop() != '{') {
						return false;
					}
				} else if (current == ']') {
					if (stack.pop() != '[') {
						return false;
					}
				} else if (current == ')') {
					if (stack.pop() != '(') {
						return false;
					}
				} 
			} catch(StackEmptyException e) {
				return false;
			}
		}
		if (stack.isEmpty())
			return true;
		else
			return false;

	}

	public static void main(String args[]){
		System.out.println(isBalanced("{ a + [ b+ (c + d)] + (e + f) }["));
		int[] a = {1,2,3,4,5,6};
		Stack s = new Stack(a.length);
		for (int i: a) {
			try {
				s.push(i);
			} catch (StackFullException e) {
				System.out.println("Not possible");
				return;
			}
		}

		try {
			while(!s.isEmpty()) {
				System.out.println(s.pop());
			}
			//s.pop();
		} catch (StackEmptyException e) {
			System.out.println("Not possible");
			return;
		}

	}
}
