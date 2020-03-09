package swexpert2;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {

	static int[][] map = new int[3][3];
	static int[][] dirs = { { 1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		bfs3();

	}

	private static void bfs1() {
		// 0,0 ~2,2로 이동하는 최단거리를 찾아보자!
		// 방문했던 곳은 더 이상 가지 말자!!
		boolean[][] visited = new boolean[3][3];
		// 두개 이상의 정보를 담아야 해.
		// 배열 <- 동일한 데이터 타입만 처리, 빠르고 가볍다
		// 객체 <- 다른 데이터 타입 처리가능. 코도의 직관적인 이해가 가능하다.
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			Point front = q.poll();
			// 사용
			System.out.println(front);

			// 자식 탐색
			for (int d = 0; d < dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];

				if (isIn(nr, nc)) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}
		}

	}

	private static void bfs2() {
		// 0,0 ~2,2로 이동하는 최단거리를 찾아보자!
		// 방문했던 곳은 더 이상 가지 말자!!
		boolean[][] visited = new boolean[3][3];
		// 두개 이상의 정보를 담아야 해.
		// 배열 <- 동일한 데이터 타입만 처리, 빠르고 가볍다
		// 객체 <- 다른 데이터 타입 처리가능. 코도의 직관적인 이해가 가능하다.
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point front = q.poll();
				// 사용
				System.out.println(front);

				// 자식 탐색
				for (int d = 0; d < dirs.length; d++) {
					int nr = front.row + dirs[d][0];
					int nc = front.col + dirs[d][1];

					if (isIn(nr, nc)) {
						if (!visited[nr][nc]) {
							visited[nr][nc] = true;
							q.offer(new Point(nr, nc, front.depth + 1));
						}
					}
				}

			} // end for
			System.out.println("하나의 턴이 종료");
		} // end while

	}

	private static void bfs3() {
		// 0,0 ~2,2로 이동하는 최단거리를 찾아보자!
		// 방문했던 곳은 더 이상 가지 말자!!
		boolean[][] visited = new boolean[3][3];
		// 두개 이상의 정보를 담아야 해.
		// 배열 <- 동일한 데이터 타입만 처리, 빠르고 가볍다
		// 객체 <- 다른 데이터 타입 처리가능. 코도의 직관적인 이해가 가능하다.
		Queue<Point> q = new LinkedList<>();

		q.offer(new Point(0, 0, 0));
		visited[0][0] = true;

		int size = q.size();
		while (size-- > 0) {
			Point front = q.poll();
			// 사용
			System.out.println(front);

			// 자식 탐색
			for (int d = 0; d < dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];

				if (isIn(nr, nc)) {
					if (!visited[nr][nc]) {
						visited[nr][nc] = true;
						q.offer(new Point(nr, nc, front.depth + 1));
					}
				}
			}

			System.out.println("턴은 종료되었고.. 남은것은"+q);
		} // end while

	}

	private static boolean isIn(int nr, int nc) {
		if (0 <= nr && nr < 3 && 0 <= nc && nc < 3) {
			return true;
		}
		return false;
	}

	static class Point {
		int row, col, depth;

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

	}

}
