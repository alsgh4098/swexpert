import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	private Object[] nodes;
	private int lastIndex;
	private final int SIZE;
	
	public BinaryTree(int size) {
		nodes = new Object[size+1];
		this.SIZE = size;
		
		
	}
	
	public boolean isEmpty() {
		return lastIndex==0;
	}
	
	public boolean isFull() {
		return lastIndex == SIZE;
	}
	
	public void add(Object e) { // 완전이진트리로 채움.
		if(isFull()) {
			System.out.println("포화상태입니다.");
			return;
		}
		nodes[++lastIndex] = e;
	}
	
	// 재귀로 구현하는 바이너리 트리 DFS탐색
	// 전위 중위 후위

	
	public void searchPreOrder() {
		searchPreOrder(1);
	}
	
	public void searchInOrder() {
		searchInOrder(1);
	}
	
	public void searchPostOrder() {
		searchPostOrder(1);
	}
	
	private void searchPreOrder(int index) {
		if(index <= lastIndex) {
			System.out.print(nodes[index]+" "); // V
			searchPreOrder(index*2); // L
			searchPreOrder(index*2+1);	// R		
		}
	}
	
	private void searchInOrder(int index) {
		if(index <= lastIndex) {
			searchInOrder(index*2); // L
			System.out.print(nodes[index]+" "); // V
			searchInOrder(index*2+1); // R
		}
	}
	
	private void searchPostOrder(int index) {
		if(index <= lastIndex) {
			searchPostOrder(index*2); // L
			searchPostOrder(index*2+1);	 // R	
			System.out.print(nodes[index]+" "); // V
		}
	}
	
	// 큐로 구현하는 바이너리 트리 BFS탐색
	
	public void searchBFS() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.print(nodes[cur]+" ");
			if(cur*2<=lastIndex)queue.offer(cur*2);
			if(cur*2+1<=lastIndex)queue.offer(cur*2+1);
		}
	}
	
	public void searchBFS2() {
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(1);
		
		while(!queue.isEmpty()) {
			int size = queue.size();
			
			while(size-->0) {
				int cur = queue.poll();
				System.out.print(nodes[cur]+" ");
				if(cur*2<=lastIndex)queue.offer(cur*2);
				if(cur*2+1<=lastIndex)queue.offer(cur*2+1);
			}
			System.out.println();
		}
	}
}
