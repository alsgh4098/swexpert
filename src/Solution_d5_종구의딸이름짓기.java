
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d5_종구의딸이름짓기 {

	static int N;
	static int M;

	static char[][] map;
	static boolean[][] visited;
	// 오른, 아래
	static int[] dx = { 0, 1 };
	static int[] dy = { 1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
				}
			}

			System.out.println("#" + t + " " + bfs());
		}
	}

	public static class Point {
		int x;
		int y;
		String str;

		public Point(int x, int y, String string) {
			super();
			this.x = x;
			this.y = y;
			this.str = string;
		}
	}

	private static String bfs() {
		Queue<Point> q = new LinkedList<Point>();
		String str = "" + map[0][0];
		q.offer(new Point(0, 0, "" + map[0][0]));

		while (!q.isEmpty()) {
			Point temp = q.poll();

			if (str.length() == temp.str.length() && temp.str.compareTo(str) < 0) {
				str = temp.str;
			} else if (str.length() == temp.str.length() && temp.str.compareTo(str) > 0) {
				continue;
			}

			if (visited[temp.x][temp.y]) {
				continue;
			} else {
				visited[temp.x][temp.y] = true;

				str = temp.str;

				if (temp.x == N - 1 && temp.y == M - 1) {
					return temp.str;
				}

				int nx = temp.x + dx[0];
				int ny = temp.y + dy[0];

				int nx2 = temp.x + dx[1];
				int ny2 = temp.y + dy[1];

				if (inner(nx, ny) && inner(nx2, ny2)) {
					if (map[nx][ny] < map[nx2][ny2]) {
						str += map[nx][ny];
						q.offer(new Point(nx, ny, str));
					} else if (map[nx][ny] > map[nx2][ny2]) {
						str += map[nx2][ny2];
						q.offer(new Point(nx2, ny2, str));
					} else {
						str += map[nx2][ny2];
						q.offer(new Point(nx, ny, str));
						q.offer(new Point(nx2, ny2, str));
					}
				}

				if (inner(nx, ny) && !inner(nx2, ny2)) {
					str += map[nx][ny];
					q.offer(new Point(nx, ny, str));
				}

				if (!inner(nx, ny) && inner(nx2, ny2)) {
					str += map[nx2][ny2];
					q.offer(new Point(nx2, ny2, str));
				}

				visited[temp.x][temp.y] = false;
			}
		}

		return null;
	}

	static boolean inner(int x, int y) {
		if (0 <= x && x < N && 0 <= y && y < M) {
			return true;
		} else {
			return false;
		}
	}

}
