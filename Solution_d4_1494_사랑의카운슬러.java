package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_1494_사랑의카운슬러 {

	static int N;
	static int[] wx;
	static int[] wy;

	// 뽑힌여부
	static boolean[] select;
	static long min;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			wx = new int[N];
			wy = new int[N];
			
			select = new boolean[N];
			min = Long.MAX_VALUE;
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				
				wx[i] = Integer.parseInt(st.nextToken());
				wy[i] = Integer.parseInt(st.nextToken());
				
			}
			
			
			solution(0,0);
			
			System.out.printf("#%d %d\n",t,min);
			
		}

	}
	
	static void solution(int start, int count) {
		if(count == N/2) {
			//경우의 수 확인.
//			for (int i = 0; i < N/2; i++) {
//				System.out.print(worms_1[i]+" ");
//			}
//			System.out.println();
			
			long xx = 0;
			long yy = 0;
			
			for (int i = 0; i < select.length; i++) {
				if(select[i] == false) {
					xx += wx[i];
					yy += wy[i];
				}else {
					xx -= wx[i];
					yy -= wy[i];
				}
			}
			
			long res = xx*xx + yy*yy;
			
			if(res < min) {
				min = res;
			}
			
			return;
		}
		
		for (int i = start; i < N; i++) {
			
			if(select[i] == false) {
				select[i] = true;
				solution(i+1,count+1);				
				select[i] = false;
			}
		
		}
		
	}

}
