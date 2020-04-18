

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d3_3307_최장증가수열 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		for (int t = 1; t <= tc; t++) {

			int N = sc.nextInt();

			int[] arr = new int[N];
			int[] count = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.fill(count, 1);

			for (int i = 0; i < arr.length; i++) {
				for (int j = i + 1; j < arr.length; j++) {
					if (arr[i] < arr[j] && count[i] + 1 < count[j]) {
						count[j]++;
					}
				}
			}

			// ascending
			Arrays.sort(count);

			System.out.printf("#%d %d\n", t, count[N - 1]);

		}

	}

}