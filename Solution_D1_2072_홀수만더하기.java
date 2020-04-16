package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D1_2072_홀수만더하기 {

	static int T;
	static int[] num;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			num = new int[10];
			for (int i = 0; i < num.length; i++) {
				num[i] = sc.nextInt();
			}
			int sum = 0;
			for (int j = 0; j < num.length; j++) {
				if (num[j] % 2 == 1)
					sum += num[j];
			}
			System.out.println("#" + (t+1) + " " + sum);
		}
	}

}
