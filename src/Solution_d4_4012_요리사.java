import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_4012_요리사 {

	static int[][] map;
	static int[] gradient;
	static int N;
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			map = new int[N][N];
			gradient = new int[N];
			StringTokenizer st;

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			solution(0, 0, 0);

			System.out.printf("#%d %d\n", t, min);
//			printMap(map);

		}

	}

	static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}

	static void solution(int grd_idx, int a_cnt, int b_cnt) {
		if (a_cnt > N / 2 || b_cnt > N / 2) {
			return;
		} else {
			if (grd_idx == N) {

				int res = check();

				if (res < min) {
					min = res;
				}
				return;
			} else {

				gradient[grd_idx] = 1;
				solution(grd_idx + 1, a_cnt + 1, b_cnt);
				gradient[grd_idx] = 2;
				solution(grd_idx + 1, a_cnt, b_cnt + 1);

			}
		}
	}

	static int check() {

		int a_sum = 0;
		int b_sum = 0;

		for (int i = 0; i < map.length; i++) {
			if (gradient[i] == 1) {
				for (int j = 0; j < map.length; j++) {
					if( i == j) {
						continue;
					}
					if (gradient[j] == 1) {
						a_sum += map[i][j];
					}
				}
			} else if (gradient[i] == 2) {
				for (int j = 0; j < map.length; j++) {
					if( i == j) {
						continue;
					}
					if (gradient[j] == 2) {
						b_sum += map[i][j];
					}
				}
			}
		}

		int res = ((a_sum - b_sum > 0) ? (a_sum - b_sum) : (b_sum - a_sum));

		return res;
	}

}
