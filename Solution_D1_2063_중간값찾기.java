package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D1_2063_중간값찾기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int [] num = new int[N];
		for(int n=0; n<N; n++) {
			num[n] = sc.nextInt();
		}
		Arrays.sort(num);		//ascending
		System.out.println(num[N/2]);
		
		int [] a = new int[N];
		System.arraycopy(num, 0, a, 0, num.length);
	}
}
