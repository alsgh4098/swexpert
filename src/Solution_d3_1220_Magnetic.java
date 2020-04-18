import java.io.IOException;
import java.util.Scanner;

public class Solution_d3_1220_Magnetic {

	static int N;
	static int[][] map;
	static int count;

	public static void main(String[] args) throws NumberFormatException, IOException {

		for (int t = 1; t <= 10; t++) {
			Scanner sc = new Scanner(System.in);

			N = sc.nextInt();
			map = new int[N][N];
			count = 0;

			System.out.println(N);

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}

//			printMap(map);

			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) {
					if (map[i][j] == 2) {
						map[i][j] = 0;
					}

					if (map[i][j] == 1) {
						break;
					}
				}
			}

			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					if (map[i][j] == 1) {
						map[i][j] = 0;
					}
					if (map[i][j] == 2) {
						break;
					}
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 1) {
						solution(i, j);
					}
				}
			}

			System.out.printf("#%d %d\n", t, count);
		}

	}

	public static void printMap(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void solution(int x, int y) {
		while (y + 1 < N) {
			y++;
			if (map[x][y] == 2) {
				count++;
				break;
			} else if (map[x][y] == 1) {
				break;
			}

		}
	}

}
