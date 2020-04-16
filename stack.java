
public class stack {

	public static void main(String[] args) {
		SimpleStack stack = new SimpleStack();
		
		stack.push("진민호");
		stack.push("김대우");
		stack.push("박진원");
		
		System.out.println(stack.size());
		
		stack.printStack();		
		stack.pop();
		stack.printStack();
		stack.pop();
		stack.printStack();
		stack.pop();
	}

}
