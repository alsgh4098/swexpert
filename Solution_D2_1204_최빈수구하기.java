package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1204_최빈수구하기 {

	static int[] scores = new int[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			for (int i = 0; i < 1000; i++) {
				scores[sc.nextInt()]++;
			}
			int countMax = 0;
			int index = 0;
			for (int i = 0; i <= 100; i++) {
				if (countMax <= scores[i]) {
					countMax = scores[i];
					index = i;
				}
			}
			System.out.println("#" + N + " " + index);
			Arrays.fill(scores, 0);
		}

	}

}
