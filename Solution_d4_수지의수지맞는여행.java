package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_수지의수지맞는여행 {
	
	static int R;
	static int C;
	
	static boolean[] alpha;
	static char[][] map;
	static boolean[][] visited;

	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			map = new char[R][C];
			visited = new boolean[R][C];
			
			alpha = new boolean[26];
			
			res = 0;
			
			for (int i = 0; i < R; i++) {
				char[] chr_arr = br.readLine().toCharArray();
				for (int j = 0; j < C; j++) {
					map[i][j] = chr_arr[j];
				}
			}
			
			dfs(0,0,1);
			
			System.out.println("#"+t+" "+res);
		}

	}
	
	static void dfs(int x, int y, int cnt) {
		if( res < cnt) {				
			res = cnt;
		}
		
		if(cnt == 26) {
			return ;
		}
		
		
		alpha[map[x][y]-65] = true;
		
		for (int i = 0; i < 4; i++) {
			 int nx = x+dx[i];
			 int ny = y+dy[i];
			 if( inner(nx,ny) && !visited[nx][ny] && !alpha[map[nx][ny]-65]) {
				 	dfs(nx,ny,cnt+1);
			 }
		}
		
		alpha[map[x][y]-65] = false;
		
	}
	
	static boolean inner(int x, int y) {
		if(0<= x && x < R && 0<= y && y < C) {
			return true;
		}else {
			return false;
		}
	}

}
