
public class SimpleStack {
	
	Node lastNode;

	private class Node{
		Object data;
		Node nextNode;

		public Node(Object data) {
			super();
			this.data = data;
		}

		@Override
		public String toString() {
			return "Node [data=" + data + ", nextNode=" + nextNode + "]";
		}
	}
	
	void push(Object obj) {
		if(lastNode == null) {
			lastNode = new Node(obj);
		}else {
			Node temp = lastNode;
			lastNode = new Node(obj);
			lastNode.nextNode = temp;
		}
	}
	
	Object pop() {
		Node rtrn = lastNode;
		lastNode = lastNode.nextNode;
		return rtrn.data;
	}
	
	int size() {
		int len = 0;
		Node copy = lastNode;
		while(copy.nextNode != null) {
			len++;
			copy = copy.nextNode;
		}
		if(copy != null) {
			len+=1;
		}
		return len;
	}
	
	void printStack() {
		Node copy = lastNode;
		while(copy.nextNode != null) {
			System.out.print(copy.data+" ");
			copy = copy.nextNode;
		}
		System.out.println(copy.data);
		System.out.println();
	}
}
