import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solutiond_d4_1494_사랑의카운슬러2 {

	static long[] worms_x;
	static long[] worms_y;
	static boolean[] worms;
	static int N;
	static long min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());

			worms_x = new long[N];
			worms_y = new long[N];
			worms = new boolean[N];
			min = Long.MAX_VALUE;

			StringTokenizer st;

			// N개의 지렁이의 위치 좌표.
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				worms_x[i] = Integer.parseInt(st.nextToken());
				worms_y[i] = Integer.parseInt(st.nextToken());
			}

			// N개의 지렁이에서 2개씩 뽑는 조합으로 N/2개의 조합을 만들고
			// 그 조합의 벡터의 합이 최솟값을 값는 값을 출력.

			combi(0, 0);
//			System.out.println();
			System.out.printf("#%d %d\n", t, min);

		}
	}

	static void combi(int start, int count) {
		if (count == N / 2) {

			long sum_x = 0;
			long sum_y = 0;

			for (int i = 0; i < worms.length; i++) {
				if (worms[i] == true) {
					sum_x += worms_x[i];
					sum_y += worms_y[i];
				} else {
					sum_x -= worms_x[i];
					sum_y -= worms_y[i];
				}
			}

			long res =  sum_x * sum_x + sum_y  * sum_y;

			if (res < min) {
				min = res;
//				System.out.println(" min   "+min);
			}
			return;
		}

		for (int i = start; i < N; i++) {
			if(worms[i] == false) {
				worms[i] = true;
				combi(i + 1, count + 1);
				worms[i] = false;
			}
		}

	}
}