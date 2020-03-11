package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import javafx.scene.layout.Priority;

public class Solution_d4_하나로 {
	
	static int N;
	
	static long[][] islands;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			N = Integer.parseInt(br.readLine());
			
			// 그래프의 인접행렬.
			islands = new long[N][N];
			
			StringTokenizer isle_X = new StringTokenizer(br.readLine());
			StringTokenizer isle_Y = new StringTokenizer(br.readLine());
			
			long[][] isle = new long[N][2]; 
			
			for (int i = 0; i < isle.length; i++) {
				isle[i] = new long[]{Long.parseLong(isle_X.nextToken()),Long.parseLong(isle_Y.nextToken())};
			}
			
			// 이 문제에서의 가중치는 섬간의 간격
			for (int i = 0; i < N; i++) {
				long[] from = isle[i]; 
				for (int j = 0; j < N; j++) {
					long[] to = isle[j];
					islands[i][j] = (from[0]-to[0]) * (from[0]-to[0]) + (from[1]-to[1]) * (from[1]-to[1]);
				}
			}
			
			double E = Double.parseDouble(br.readLine());
			
			double res = prim(0)*E;
			
			System.out.println("#"+t+" "+Math.round(res));
		}
		
	}

	private static long prim(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		
		Node[] arr = new Node[N];
		
		long cost = 0;
		
		for (int j = 0; j < N; j++) {
			arr[j] = new Node(j,Long.MAX_VALUE);
			if(j == start) {
				arr[j].cost = 0;
			}
			pq.add(arr[j]);
		}
		
		while(!pq.isEmpty()) {
			Node front = pq.poll();
			
			cost += front.cost;
			
			for (int i = 0; i < N; i++) {
				
				Node child = arr[i];
				
				if(pq.contains(child)) {
					long tempCost = islands[front.idx][child.idx];
					if(tempCost < child.cost) {
						child.cost = tempCost;
						pq.remove(child);
						pq.add(child);
					}
				}
			}
		}
		
		
		return cost;
	}
	
	
	
	static class Node implements Comparable<Node>{
		int idx;
		long cost;
		public Node(int idx, long cost) {
			super();
			this.idx = idx;
			this.cost = cost;
		}
		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + "]";
		}
		
		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return Long.compare(this.cost, o.cost);
		}
		
	}
}
