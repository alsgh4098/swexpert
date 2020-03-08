package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_모래성쌓기3_큐성공 {

	static int[][] map;
	static int N;
	static int M;

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int res;
	
	static class Wave{
		int x;
		int y;
		int count;
		
		public Wave(int x, int y, int count) {
			super();
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
	
	static Queue<Wave> q;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			res = 0;

			q = new LinkedList<Wave>();

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					char chr = line.charAt(j);
					if(chr != '.') {
						map[i][j] = chr-'0';
					}else {
						map[i][j] = 0;
						q.offer(new Wave(i,j,0));
					}
				}
			} // end input
			
			solution();

			System.out.println("#" + t + " " + res);

		}

	}// end main

	static void solution() {
		
		while(!q.isEmpty()) {
			Wave wave = q.poll();
			int wx = wave.x;
			int wy = wave.y;
			int wcnt = wave.count;
			res = wcnt;
			
			for (int i = 0; i < 8; i++) {
				int nx = wx+dx[i];
				int ny = wy+dy[i];
				if(inner(nx,ny) && map[nx][ny] != 0) {
					map[nx][ny]--;
					if(map[nx][ny] == 0) {
						q.offer(new Wave(nx,ny,wcnt+1));
					}
				}
			}
		}
		

	}

	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		} else {
			return false;
		}
	}

}
