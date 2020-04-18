import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_요리사 {
	
	static int N;
	
	static int[][] score;
	
	static boolean[] selected;
	
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			score = new int[N][N];
			selected = new boolean[N];
			
			min = Integer.MAX_VALUE;
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					score[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			A(0,0);
			
			System.out.println("#"+t+" "+min);
			
		}

	}// end main
	
	static void A(int count,int index) {
		
		if(index >= N) {
			return;
		}
		
		if(N/2 == count) {
			calc();
			return;
		}
		
//		for (int i = 0; i < N; i++) {
//			if( (flag&(1<<i)) != 0 ) {
//				continue;
//			}else {
//			}
//		}
		selected[index] = true;
		A(count+1,index+1);
		selected[index] = false;
		A(count,index+1);
	}
	
	static void calc() {
		int sum_A = 0;
		int sum_B = 0;
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(selected[i] && selected[j]) {
					sum_A += score[i][j];
				}
				if(!selected[i] && !selected[j]) {
					sum_B += score[i][j];
				}
			}
		}
		
		if(Math.abs(sum_A - sum_B) < min) {
			min = Math.abs(sum_A - sum_B);
		}
	}

}
