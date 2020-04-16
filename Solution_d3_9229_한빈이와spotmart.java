

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_9229_한빈이와spotmart {
	
	static int[] res;
	static int[] snack;
	static int N;
	static int M;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		// 최대한 무게가 많이나가는 과자 N개를고른다 무게 제한은  M.
		
		for (int t = 1; t <= TC; t++) {
			max = Integer.MIN_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			snack = new int[N];
			res = new int[2];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			solution(0,0);
			
			if(0 < max) {
				System.out.printf("#%d %d\n",t,max);
			}else {
				System.out.printf("#%d %d\n",t,-1);
			}
			
			
		}
		
	}
	
	public static void solution(int start, int count) {
		if(count == 2) {
			int sum = 0;
			for (int i = 0; i < res.length; i++) {
				sum += res[i];
			}
			if( sum <= M && max < sum) {
				max = sum;
			}
		}else {
			for (int i = start; i < N; i++) {
				res[count] = snack[i];
				solution(i+1,count+1);
			}
		}
	}

}
