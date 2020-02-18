package ssafyalgo0130;

import java.util.LinkedList;
import java.util.Queue;

public class QueTest {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(5);
		queue.offer(4);
		queue.offer(3);
		queue.offer(2);
		System.out.println(queue.size());
		
		while(!queue.isEmpty()) {
			int b = queue.peek();
			System.out.print(queue.size()+ " ");
			System.out.println(b);
			int a = queue.poll();
			System.out.print(queue.size()+ " ");
			System.out.println(a);
		}
		System.out.println();
		
		
	}

}
