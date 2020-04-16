package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기 {

	static int T;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			String input = sc.next();

			int index = 0;
			int count = 0;
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '1') {
					index = i;
					break;
				}
			}
			for (int i = index; i < input.length() - 1; i++) {
				if (input.charAt(i) != input.charAt(i + 1)) {
					count++;
				}
			}
			System.out.println("#" + t + " " + (count + 1));
		}
	}

}
