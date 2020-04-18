import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d4_1249_보급로2 {
	
	public static class Point{
		int y;
		int x;
		
		public Point(int y, int x, int cost) {
			super();
			this.y = y;
			this.x = x;
			this.cost = cost;
		}
		int cost;
		
	}

	static int N;
	static int[][] map;
	static int[][] memoi;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());

		for (int t = 1; t <= tc; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N + 2][N + 2];
			memoi = new int[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				map[i][0] = -1;
				map[i][N + 1] = -1;
				map[0][i] = -1;
				map[N + 1][i] = -1;
				Arrays.fill(memoi[i], Integer.MAX_VALUE);
			}
			
			char[] num_arr;
			
			for (int i = 1; i < N + 1; i++) {
				num_arr = br.readLine().toCharArray();
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = num_arr[j-1]-'0';
				}
			}

			Queue<Point> q = new LinkedList<Point>();

			q.offer(new Point(1,1,0));
//			printMap();
			while (!q.isEmpty()) {
				Point temp = q.poll();

				for (int i = 0; i < 4; i++) {
					int x = temp.x+ dx[i];
					int y = temp.y + dy[i];
					int score = temp.cost;
					if (map[x][y] != -1) {
						score = score + map[x][y];
						if (score < memoi[x][y]) {
							memoi[x][y] = score;
							q.offer(new Point(x,y,score));
						}
					}

				}
			}

			System.out.printf("#%d %d\n", t, memoi[N][N]);

		}

	}
	
	static void printMap() {
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
