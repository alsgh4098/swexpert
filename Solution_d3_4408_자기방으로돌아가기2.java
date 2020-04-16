

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d3_4408_자기방으로돌아가기2 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int[] room = new int[400];
			
			int N = Integer.parseInt(st.nextToken());
			
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				int here = Integer.parseInt(st.nextToken());
				int there = Integer.parseInt(st.nextToken());
				
				if(there < here) {
					int temp = there;
					there = here;
					here = temp;
				}
				
				
				for (int j = here-1; j <= there-1; j++) {
					room[j]++;
					
					if(here%2 == 0 && there%2==1) {
						if( j == here-1) {
							if(0 <= j-1 && there < N) {
								room[j-1]++;
								room[there]++;
							}
						}
					}
				}
				
			}
			
			Arrays.sort(room);
			
			System.out.printf("#%d %d\n",t,room[399]);
			
			
		}
		
	}
}
		




