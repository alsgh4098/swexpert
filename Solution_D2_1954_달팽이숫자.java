package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자 {

	static int T;
	static int[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			board = new int[N][N];

			int d = 0;
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[x][y] = i * N + j + 1;
					if (d == 0) {
						if (y + 1 < N && board[x][y + 1] == 0) {
							y++;
						} else {
							d = 1;
							x++;
						}
					} else if (d == 1) {
						if (x + 1 < N && board[x + 1][y] == 0) {
							x++;
						} else {
							d = 2;
							y--;
						}
					} else if (d == 2) {
						if (y - 1 >= 0 && board[x][y - 1] == 0) {
							y--;
						} else {
							d = 3;
							x--;
						}
					} else if (d == 3) {
						if (x - 1 >= 0 && board[x - 1][y] == 0) {
							x--;
						} else {
							d = 0;
							y++;
						}
					}
				}
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
