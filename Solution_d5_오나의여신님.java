package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_오나의여신님 {
	
	static int N;
	static int M;
	static char[][] map;
	
	static int res;
	static Queue<Sy> suyeon;
	static Queue<Dv> devil;
	
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
 	
	static class Sy{
		int x;
		int y;
		int cnt;
		
		public Sy(int x, int y, int cnt) {
			super();
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static class Dv{
		int x;
		int y;
		
		public Dv(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M= Integer.parseInt(st.nextToken());
			
			map = new char[N][M];
			
			suyeon = new LinkedList<Sy>();
			devil = new LinkedList<Dv>();
			
			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = str.charAt(j);
					
					if(map[i][j] == '*') {
						devil.add(new Dv(i,j));
					}else if(map[i][j] == 'S') {
						suyeon.add(new Sy(i,j,0));
					}
				}
			}
			
			if(bfs() == -1) {
				System.out.println("#"+t+" "+"GAME OVER");
			}else{
				System.out.println("#"+t+" "+res);
			}
		}

	}

	private static int bfs() {
		while(!suyeon.isEmpty()) {
			
			int len = devil.size();
			
			for (int i = 0; i < len; i++) {
				Dv nd = devil.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = nd.x + dx[j];
					int ny = nd.y + dy[j];
					if(inner(nx,ny)) {
						if(map[nx][ny] == '.' ||
						   map[nx][ny] == 'S') {
							map[nx][ny] = '*';
							devil.offer(new Dv(nx,ny));
						}
					}
				}
			}
			
			len = suyeon.size();
			
			for (int i = 0; i < len; i++) {
				Sy ns = suyeon.poll();
				
				for (int j = 0; j < 4; j++) {
					int nx = ns.x + dx[j];
					int ny = ns.y + dy[j];
					if(inner(nx,ny)) {
						if(map[nx][ny] == '.') {
							map[nx][ny] = 'S';
							suyeon.offer(new Sy(nx,ny,ns.cnt+1));
						}
						
						if(map[nx][ny] == 'D') {
							res =  ns.cnt+1;
							return 0;
						}
					}
				}
			}
		}
		
		return -1;
		
	}
	
	static boolean inner(int x, int y) {
		return 0<=x && x < N && 0<= y && y < M;
	}

}
