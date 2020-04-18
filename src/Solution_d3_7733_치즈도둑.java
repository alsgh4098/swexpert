
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_7733_치즈도둑 {

	static char[][] map;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			int N = Integer.parseInt(br.readLine());

			map = new char[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				map[0][i] = 'a';
				map[N + 1][i] = 'a';
				map[i][0] = 'a';
				map[i][N + 1] = 'a';
			}

//			printMap();

			StringTokenizer st;
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = st.nextToken().charAt(0);
				}
			}

			printMap();

			int[] piece_list = new int[N * N];
			int n = 0;

			for (int d = 1; d <= 100; d++) {
				for (int i = 1; i < N + 1; i++) {
					for (int j = 1; j < N + 1; j++) {
						solution(i, j, d);
					}
				}
			}

			Arrays.sort(piece_list);

			System.out.printf("#%d %d\n", piece_list[N * N - 1]);

		}

	}

	static void printMap() {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	static void solution(int x, int y, int day) {
		// 범위를 벗어날경우.
		if (map[x][y] == '0' || map[x][y] == 'a') {
			return;
		} else {
			// 4방탐색.
			for (int i = 0; i < 4; i++) {
				if (map[x][y] - '0' == day) {
					map[x][y] = '0';
					count++;
				}
				solution(x + dx[i], y + dy[i], day);
			}
		}
	}

	static void solution2(int x, int y) {
		// 범위를 벗어날경우.
		if (map[x][y] == '0' || map[x][y] == 'a') {
			return;
		} else {
			// 4방탐색.
			for (int i = 0; i < 4; i++) {
				solution2(x + dx[i], y + dy[i]);
			}
		}
	}
}
