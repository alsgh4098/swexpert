package swexpert;

import java.util.Scanner;

public class Solution_d2_1961_숫자배열회전 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int N = sc.nextInt();
			int[][] cube = new int[N][N];
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					cube[j][k] = sc.nextInt();
				}
			}
			
			int[][] cube_90 = new int[N][N];
			int[][] cube_180 = new int[N][N];
			int[][] cube_270 = new int[N][N];
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					cube_270[j][k] = cube[k][N-1-j];
				}
			}
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					cube_180[j][k] = cube_270[k][N-1-j];
				}
			}
			
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					cube_90[j][k] = cube_180[k][N-1-j];
				}
			}
			
			
			System.out.printf("#%d\n",i);
			for(int k=0; k<N; k++) {
				for(int j=0; j<N; j++) {
					System.out.print(cube_90[k][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(cube_180[k][j]);
				}
				System.out.print(" ");
				for(int j=0; j<N; j++) {
					System.out.print(cube_270[k][j]);
				}
				System.out.print("\n");
			}

			
		}
	}

}
