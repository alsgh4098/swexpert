package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자2_D {

	static int T;
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			board = new int[N][N];

			int delta = 1;
			int left = N;
			int x=0;
			int y=-1;
			int num=0;
			while (true) {
				for (int i = 0; i < left; i++) {
					y = y+delta;
					board[x][y] = num;
					num++;
				}
				left--;
				if(left ==0) {
					break;
				}
				for (int i = 0; i < left; i++) {
					x = x+delta;
					board[x][y] = num;
					num++;
				}
				delta = -delta;
			}

			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(board[i][j] + " ");
				}
				System.out.println();
			}

		}

	}

}
