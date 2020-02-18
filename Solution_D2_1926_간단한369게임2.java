package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1926_간단한369게임2 {

	static int T;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();

		for (int i = 1; i <= T; i++) {
			int count = 0;
			char[] cs = (i + "").toCharArray();
			for (int k = 0; k < cs.length; k++) {
				if (cs[k] == '3' || cs[k] == '6' || cs[k] == '9') {
					count++;
				}
			}
			String v = count == 0 ? i + "" : counts(count);
			System.out.print(v+" ");
		}
	}
	public static String counts(int n) {
		String s ="";
		for(int i=0; i<n; i++) {
			s = s+"-";
		}
		return s;
	}

}
