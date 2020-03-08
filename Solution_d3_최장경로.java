package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d3_최장경로 {
	
	static int N;
	static int M;
	static int[][] nodes;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			// 인접행렬
			nodes = new int[N+1][N+1];
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int ths = Integer.parseInt(st.nextToken());
				int tht = Integer.parseInt(st.nextToken());
				
				nodes[ths][tht] = 1;
				nodes[tht][ths] = 1;
			}
			
			// 방문
			visited = new boolean[N+1];
			
			// 기본값 1
			max = 1;

			for (int i = 1; i <= N; i++) {
				visited[i] = true;
				dfs(i,1);
				visited[i] = false;
			}
			
			System.out.println("#"+t+" "+max);

		}
		
	}// end main
	
	static int max = 1;
	
	static void dfs(int node, int count) {
		max = Math.max(max, count);
		
		for (int i = 1; i <= N; i++) {
			if(nodes[node][i] == 1 && visited[i] == false) {
				visited[i] = true;
				dfs(i,count+1);
				visited[i] = false;
			}
		}
		
	}

}
