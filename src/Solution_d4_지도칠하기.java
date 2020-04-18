import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_지도칠하기 {

	static int N;
	static int[] color;
	static int[][] mat;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			// 노드의 수. 국가의 수
			N = Integer.parseInt(br.readLine());
			color = new int[N];
			mat = new int[N][N];
			dp = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				color[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					mat[i][j] = Integer.parseInt(st.nextToken());
				}
			} // end input

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (mat[i][j] == 1 && color[i] == color[j]) {
						dp[i]++;
					}
				}
			}

			// 연결되어있는 국가끼리 색이 전부 다를 때 종료.
			// 연결되어있을 때 색을 바꿔준다.
			// 색은 국가의 수만큼 주어진다.
			int count = 0;

			while (true) {

				int max = -1;

				// 색이 같은 노드가 가장 많이 연결되어 있는 노드를 찾는다.
				for (int i = 0; i < N; i++) {
					if (dp[i] > max) {
						max = dp[i];
					}
				}

				for (int i = 0; i < N; i++) {
					// 위에서 찾은 노드의 인덱스를 i로 둔다.
					if (dp[i] == max && dp[i] != 0) {
						// 1부터 N까지의 색 j중에서
						for (int j = 1; j <= N; j++) {
							boolean select = true;
							// i와 연결된 다른 노드들 j2의 색 color[j2]와 위에서 선택한 색 j가 모두 다를 경우.
							for (int j2 = 0; j2 < N; j2++) {
								if (mat[i][j2] == 1) {
									if (j == color[j2]) {
										select = false;
										break;
									}
								}
							}
							// i의 색을 위에서 정한 j색으로 바꿔주고 count를 늘린다.
							if (select) {
								color[i] = j;
//									System.out.println(j);
								count++;
								break;
							}
						}

						break;
					}
				}

				// 다시 dp를 만든다.
				dp = new int[N];
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (mat[i][j] == 1 && color[i] == color[j]) {
							dp[i]++;
						}
					}
				}

				boolean finish = true;

				for (int i = 0; i < N; i++) {
					if (dp[i] != 0) {
						finish = false;
						break;
					}
				}

				if (finish) {
					break;
				}
			}

			System.out.println("#" + t + " " + count);
		}

	}// end main

}
