package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d5_모래성쌓기_인접행렬_제한시간 {

	static char[][] map;
	static boolean[][] remove;

	static int N;
	static int M;

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new char[N][M];
			remove = new boolean[N][M];

			res = 0;

			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					map[i][j] = line.charAt(j);
				}
			} // end input

			solution();

			System.out.println("#" + t + " " + res);

		}

	}// end main

	static void solution() {

		while (true) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if(map[i][j] != '.') {						
						remove[i][j] = check_8(i, j);
					}
				}
			}

			// 지울게 없음.
			boolean finish = true;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (remove[i][j]) {
						map[i][j] = '.';
						remove[i][j] = false;
						finish = false;
					}
				}
			}

			if (finish) {
				break;
			} else {
				res++;
			}
		}

	}

	// 8방을 탐색하고 튼튼함과 비교해서 지워야할 모래성을 찾음.
	static boolean check_8(int x, int y) {
		int sum = 0;

		for (int i = 0; i < 8; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (inner(nx, ny) && map[nx][ny] == '.') {
				sum++;
			}
		}

		// 주변에 모래가 없는 칸의 수가 튼튼함과 같거나 크면 true를 리턴함. 지우라는 뜻.
		if (sum >= map[x][y] - '0') {
			return true;
		} else {
			return false;
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
