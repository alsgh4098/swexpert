package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1926_간단한369게임 {

	static int T;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int radix100 = i / 100;
			int radix10 = (i / 10) % 10;
			int radix = i % 10;
			boolean clap = false;
			if (radix100 == 3 || radix100 == 6 || radix100 == 9) {
				System.out.print("-");
				clap = true;
			}
			if (radix10 == 3 || radix10 == 6 || radix10 == 9) {
				System.out.print("-");
				clap = true;
			}
			if (radix == 3 || radix == 6 || radix == 9) {
				System.out.print("-");
				clap = true;
			}
			if (!clap) {
				System.out.print(i);
			}
			System.out.print(" ");
		}

	}

}
