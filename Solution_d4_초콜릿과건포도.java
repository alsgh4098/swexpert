package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_초콜릿과건포도 {
	
	static int[][] map;
	
	static int N;
	static int M;
	static int res;
	static int[][][][] memoi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			memoi = new int[N+1][M+1][N+1][M+1];
			
			for (int[][][] m1 : memoi) {
				for (int[][] m2 : m1) {
					for (int[] m3 : m2) {
						 Arrays.fill(m3, Integer.MAX_VALUE);
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = dfs(0,0,N,M);
			System.out.println("#"+t+" "+res);
		}
	}// end main
	
	static int dfs(int y, int x, int h, int w) {
		// 종료
		if( w == 1 && h ==1 ) {
			return 0;
		}
		
		if(memoi[y][x][h][w] != Integer.MAX_VALUE) {
			return memoi[y][x][h][w];
		}
		
		// 실행
		// 기존에 있던 덩어리의 건포도 갯수.
		
		int sum = 0;
		
		for (int i = y; i < h+y; i++) {
			for (int j = x; j < w+x; j++) {
				sum += map[i][j];
			}
		}
		
		// 가로로 나눠서 최소비용을 구한다.
		for (int i = 1; i < h; i++) {
			//위쪽에 대한 비용
			if(memoi[y][x][i][w] == Integer.MAX_VALUE) {
				memoi[y][x][i][w] = dfs(y,x,i,w);
			}
			
			
			//아래쪽에 대한 비용.
			if(memoi[y+i][x][h-i][w] == Integer.MAX_VALUE) {
				memoi[y+i][x][h-i][w] = dfs(y+i,x,h-i,w);
			}
			
			int sum3 = sum + memoi[y][x][i][w] + memoi[y+i][x][h-i][w];
			
			memoi[y][x][h][w] = Math.min(memoi[y][x][h][w], sum3);
		}
		// 세로로 나눠서 최소비용을 구한다.
		for (int i = 1; i < w; i++) {

			//왼쪽에 대한 비용
			if(memoi[y][x][h][i] == Integer.MAX_VALUE) {
				memoi[y][x][h][i] = dfs(y,x,h,i);
			}
			
			//위쪽에 대한 비용
			if(memoi[y][x+i][h][w-i] == Integer.MAX_VALUE) {
				memoi[y][x+i][h][w-i] = dfs(y,x+i,h,w-i);
			}
			
			//오른쪽에 대한 비용.
			int sum3 = sum + memoi[y][x][h][i] + memoi[y][x+i][h][w-i];
			
			memoi[y][x][h][w] = Math.min(memoi[y][x][h][w], sum3);
		}
		// 재귀호출
		
		
		return memoi[y][x][h][w];
	}


}
