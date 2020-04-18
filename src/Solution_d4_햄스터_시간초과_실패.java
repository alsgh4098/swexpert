import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d4_햄스터_시간초과_실패 {

	static int[] map;
	static boolean[] visited;
	static int[][] rstrc;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			// 우리(햄스터 방)
			int N = Integer.parseInt(st.nextToken());

			map = new int[N];
			visited = new boolean[N];

			// 햄스터 수
			int X = Integer.parseInt(st.nextToken());

			// 최대한 햄스터를 채워넣음
			Arrays.fill(map, X);

			// 제약 조건 수
			int M = Integer.parseInt(st.nextToken());
			// 제약 조건
			rstrc = new int[M][N];

			int res = 0;

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken()) - 1;
				int f = Integer.parseInt(st.nextToken()) - 1;
				int rs = Integer.parseInt(st.nextToken());

				int index = s;
				int sum = (f - s + 1) * X;
				while (rs != sum && index <= f) {
					if (index > 0) {
						map[index - 1]++;
						map[index]--;
					} else {
						map[index]--;
					}

					if (map[index] == 0) {
						index++;
					}

					sum = 0;
					for (int j = s; j <= f; j++) {
						sum += map[j];
					}
				}
				
				if(index > f) {
					res = -1;
				}
			}

			if (res == -1) {
				System.out.println("#" + t + " " + res);
			} else {
				System.out.print("#" + t + " ");
				for (int i = 0; i < N; i++) {
					System.out.print(map[i] + " ");
				}
				System.out.println();
			}

		}

	}

}
