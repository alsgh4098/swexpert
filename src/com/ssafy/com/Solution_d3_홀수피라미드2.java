package com.ssafy.com;

import java.util.Scanner;

public class Solution_d3_홀수피라미드2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for (int t = 1; t <= tc; t++) {
			
			long ln = 1L;
			long rn= 1L;
			long dn = 2L;
			
			int N = sc.nextInt();
			
			for (int i = 1; i < N; i++) {
				ln += dn;
				dn += 4L;
				rn += dn;
			}
			
			System.out.printf("#%d %d %d\n",t,ln,rn);
		}
		
	}

}
