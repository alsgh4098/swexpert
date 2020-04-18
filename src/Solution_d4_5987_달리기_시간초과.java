import java.util.ArrayList;
import java.util.Scanner;

public class Solution_d4_5987_달리기_시간초과 {
	
	static int[] runner;
	static int[][] arr;
	
	static int N;
	static int M;
	
	static int res;
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			// 승자, 패자정보
			// arr[i][0] 승자
			// arr[i][1] 패자
			runner = new int[N];
			arr = new int[M][2];
			res = 0;
			for (int i = 0; i < M; i++) {
				arr[i][0] = sc.nextInt();
				arr[i][1] = sc.nextInt();
			}
			
			permu(0,0);
		
			System.out.println("#"+t+" "+res);
			
		}
	}// end main
	
	static void permu(int flag, int count) {
		if(count == N) {
			calc();
			return;
		}
		
		for (int i = 1; i <= N; i++) {
			if((flag&1<<i) != 0) {
				continue;
			}else {
				runner[count] = i;
				permu(flag|1<<i,count+1);
			}
		}
	}

	private static void calc() {
		boolean right = true;
		
		for (int i = 0; i < M; i++) {
			int winner = arr[i][0];
			int looser = arr[i][1];
			
			int win_idx = 0;
			int lose_idx = 0;
			for (int j = 0; j < N; j++) {
				if(runner[j] == winner) {
					win_idx = j;
				}
				
				if(runner[j] == looser) {
					lose_idx = j;
				}
			}
			
			if(win_idx < lose_idx) {
				right = false;
				break;
			}
		}
		
		if(right) {
			res++;
		}
		
	}

}
