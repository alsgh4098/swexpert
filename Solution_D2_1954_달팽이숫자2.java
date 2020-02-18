package com.ssafy.edu;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D2_1954_달팽이숫자2 {

	static int T;
	static int[][] board;
	static int[] dx = { 1, 0, -1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int N = sc.nextInt();
			board = new int[N][N];

			int d = 3;
			int x = 0;
			int y = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[x][y] = i * N + j + 1;
					if (!(y + dy[d] < N && x + dx[d] < N 
							&& y + dy[d] >= 0 && x + dx[d] >= 0
							&& board[x + dx[d]][y + dy[d]] == 0)) {
						d++;
						if (d == 4) {
							d = 0;
						}
					}
					x += dx[d];
					y += dy[d];
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
