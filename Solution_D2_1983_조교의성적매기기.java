package com.ssafy.edu;

import java.util.Scanner;

public class Solution_D2_1983_조교의성적매기기 {

	static int T;
	static int N;
	static int K;
	static double G;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			G = N / 10;
			double rank = 1;
			double[] scores = new double[N];
			for (int n = 0; n < N; n++) {
				scores[n] = (sc.nextInt() * 0.35 + sc.nextInt() * 0.45 + sc.nextInt() * 0.2);
			}
			for (int i = 0; i < N; i++) {
				if (scores[K-1] < scores[i]) {
					rank++;
				}
			}
			if (rank / G <= 1) {
				System.out.println("#" + t + " A+");
			}else if(rank / G <= 2) {
				System.out.println("#" + t + " A0");
			}else if(rank / G <= 3) {
				System.out.println("#" + t + " A-");
			}else if(rank / G <= 4) {
				System.out.println("#" + t + " B+");
			}else if(rank / G <= 5) {
				System.out.println("#" + t + " B0");
			}else if(rank / G <= 6) {
				System.out.println("#" + t + " B-");
			}else if(rank / G <= 7) {
				System.out.println("#" + t + " C+");
			}else if(rank / G <= 8) {
				System.out.println("#" + t + " C0");
			}else if(rank / G <= 9) {
				System.out.println("#" + t + " C-");
			}else {
				System.out.println("#" + t + " D0");
			}
		}
	}

}
