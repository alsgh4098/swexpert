package swexpert2;

import java.util.Scanner;

public class Solution_d4_우뚝선산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt();

			int[] mtn_arr = new int[N];

			for (int i = 0; i < N; i++) {
				mtn_arr[i] = sc.nextInt();
			}

			// 0시작 1오르막 2내리막
			int high = 0;
			// 우뚝선 산의 수.
			int highest = 0;

			int incre = 0;
			int decre = 0;

			for (int i = 0; i < N - 1; i++) {
				// 오르막
				if (high == 0 && mtn_arr[i] < mtn_arr[i + 1]) {
					incre++;
					continue;
				}

				// 정점찍고 내리막 시작
				if (high == 0 && mtn_arr[i] > mtn_arr[i + 1]) {
					decre++;
					// 정점 바로 다음이 내리막이고 끝일때.
					if (i + 1 == N - 1) {
						highest += incre * decre;
					}
					high = 1;
					continue;
				}

				// 내리막
				if (high == 1 && mtn_arr[i] > mtn_arr[i + 1]) {
					decre++;
					// 내리막의 끝이 산들이 끝일때.
					if (i + 1 == N - 1) {
						highest += incre * decre;
					}
				}

				// 내리막에서 오르막을 만날경우
				if (high == 1 && mtn_arr[i] < mtn_arr[i + 1]) {
					highest += incre * decre;
					decre = 0;
					incre = 1;
					high = 0;
					continue;
				}

			}

			System.out.println("#" + t + " " + highest);
		}

	}

}
