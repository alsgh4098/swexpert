
public class SimpleStack_P {
	
	private Node top;
	
	private class Node{
		String data;
		Node link;
		
		Node(String data, Node link) {
			super();
			this.data = data;
			this.link = link;
		}
		
	}
	
	public void push(String data) {
		top = new Node(data,top);
	}
	
	public Object pop() {
		if(isEmpty()) {
			System.out.println("스택이 초과되어 pop이 불가능합니다.");
			return null;
		}
		Node popNode = top;
		top = popNode.link;
		popNode.link = null;
		return popNode.data;
	}

	public boolean isEmpty() {
		return top == null;
	}
	
	public Object peek() {
		if(isEmpty()) {
			System.out.println("스택이 비어있어 peek이 불가능합니다.");
			return null;
		}
		return top.data;
	}
}
