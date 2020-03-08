package swexpert2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_d4_방향전환 {

	static int N;

	static int sx;
	static int sy;
	static int fx;
	static int fy;

	static int[] dx = { 1, -1 };
	static int[] dy = { 1, -1 };

	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int t = 1; t <= TC; t++) {
			sx = sc.nextInt()+100;
			sy = sc.nextInt()+100;
			fx = sc.nextInt()+100;
			fy = sc.nextInt()+100;

			visited = new boolean[201][201];
			
			min = Integer.MAX_VALUE;

			q = new LinkedList<int[]>();
			// 세로로 시작
			q.offer(new int[] { sx, sy, 0, 0 });
			bfs();
			
			visited = new boolean[201][201];
			q = new LinkedList<int[]>();
			// 가로로시작
			q.offer(new int[] { sx, sy, 1, 0 });
			bfs();
			
			System.out.println("#"+t+" "+min);

		}

	}// end main

	static Queue<int[]> q;
	static int min = Integer.MAX_VALUE;
	static boolean inner(int x,int y) {
		if (0 <= x && x <= 200 && 0 <= y && y <= 200) {
			return true;
		} else {
			return false;
		}
	}

	static void bfs() {
		while (!q.isEmpty()) {
			int[] temp = q.poll();
			int x = temp[0];
			int y = temp[1];
			// 0 가로이동 x축 이동
			// 1 세로이동 y축 이동
			int dir = temp[2];
			int count = temp[3];
			
			if (visited[x][y]) {
				continue;
			}

			visited[x][y] = true;

			if (x == fx && y == fy) {
				if (min > count) {
					min = count;
				}
				break;
			}
			if (dir == 1) {
				for (int i = 0; i < 2; i++) {
					int nx = x + dx[i];
					if (inner(nx,y)) {
						q.offer(new int[] { nx, y, 0, count + 1 });
					}
				}
			} else {
				for (int i = 0; i < 2; i++) {
					int ny = y + dy[i];
					if (inner(x,ny)) {
						q.offer(new int[] { x, ny, 1, count + 1 });
					}
				}
			}

		}

	}

}
