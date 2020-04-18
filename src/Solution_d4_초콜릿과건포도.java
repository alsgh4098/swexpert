import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_초콜릿과건포도 {

	static int[][] map;

	static int N;
	static int M;
	static int res;
	static int[][][][] memoi;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			memoi = new int[N + 1][M + 1][N + 1][M + 1];

			for (int[][][] m1 : memoi) {
				for (int[][] m2 : m1) {
					for (int[] m3 : m2) {
						Arrays.fill(m3, Integer.MAX_VALUE);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			res = dfs(0, 0, N, M);
			System.out.println("#" + t + " " + res);
		}
	}// end main

	static int dfs(int y, int x, int h, int w) {
		// 종료
		// w와 h는 크기를 나타낸다.
		// y와 x가 왼쪽아래 꼭지점 좌표
		// w와 h는 오른쪽 위 꼭지점 좌표
		if (w == 1 && h == 1) {
			return 0;
		}

		if (memoi[y][x][h][w] != Integer.MAX_VALUE) {
			return memoi[y][x][h][w];
		}

		// 실행
		// 기존에 있던 덩어리의 건포도 갯수.

		int sum = 0;

		// 이 문제의 아이디어는 내 생각엔 여기다.
		// y,x와 h,w로 초콜릿의 크기를 잡고
		// y(가로) x(세로)를 크기를 늘려가면서 잘라 나가는것.

		for (int i = y; i < h + y; i++) {
			for (int j = x; j < w + x; j++) {
				sum += map[i][j];
			}
		}
		
		// 초콜릿은 가로로 또는 세로로 자르면 계속 두조각씩 나오게된다.
		
		
		// 가로로 나눠서 최소비용을 구한다.
		for (int i = 1; i < h; i++) {
			// 위쪽에 대한 비용
			if (memoi[y][x][i][w] == Integer.MAX_VALUE) {
				memoi[y][x][i][w] = dfs(y, x, i, w);
			}

			// 아래쪽에 대한 비용.
			if (memoi[y + i][x][h - i][w] == Integer.MAX_VALUE) {
				memoi[y + i][x][h - i][w] = dfs(y + i, x, h - i, w);
			}

			int res = sum + memoi[y][x][i][w] + memoi[y + i][x][h - i][w];
			
			// 잘랐을때 그 이후의 초콜릿 조각들의 건포도의 합이 가장 작은 값을 담아야한다.
			memoi[y][x][h][w] = Math.min(memoi[y][x][h][w], res);
		}
		// 세로로 나눠서 최소비용을 구한다.
		for (int i = 1; i < w; i++) {

			// 왼쪽에 대한 비용
			if (memoi[y][x][h][i] == Integer.MAX_VALUE) {
				memoi[y][x][h][i] = dfs(y, x, h, i);
			}

			// 오른쪽에 대한 비용
			if (memoi[y][x + i][h][w - i] == Integer.MAX_VALUE) {
				memoi[y][x + i][h][w - i] = dfs(y, x + i, h, w - i);
			}

			int res = sum + memoi[y][x][h][i] + memoi[y][x + i][h][w - i];

			memoi[y][x][h][w] = Math.min(memoi[y][x][h][w], res);
		}
		// 재귀호출

		// 잘랐을 때 최소의 건포도 갯수를 갖는값을 리턴.
		// 이미 그값이 메모이제이션에 담겨 있을 경우 이 리턴값이 반환되는것이 아니라.
		// 위에 if()에 있는 return이 반환.
		return memoi[y][x][h][w];
	}

}
