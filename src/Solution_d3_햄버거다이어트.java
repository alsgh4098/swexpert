
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution_d3_햄버거다이어트 {
	
	static int N;
	static int L;
	
	static int[] score;
	static int[] kal;
	
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			max = Integer.MIN_VALUE;
			
			score = new int[N];
			kal = new int[N];
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				kal[i] = sc.nextInt();
			}
			
			bfs(0,0,0);
			
			System.out.println("#"+t+" "+max);
		}

	}
	
	static void bfs(int scr, int kl, int select) {
		if(select == N) {
			if(kl<=L) {
				if(max < scr) {
					max = scr;
				}
			}
			return;
		}
		
		bfs(scr+score[select],kl+kal[select],select+1);
		bfs(scr,kl,select+1);
	}

}
