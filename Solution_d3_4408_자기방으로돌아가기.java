

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d3_4408_자기방으로돌아가기 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int TC = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= TC; t++) {
			
			st = new StringTokenizer(br.readLine());
			
			int[] room = new int[400];
			
			int N = Integer.parseInt(st.nextToken());
			
			int[] here = new int[N];
			int[] there = new int[N];
			boolean[][] corridor = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				here[i] = Integer.parseInt(st.nextToken());
				there[i] = Integer.parseInt(st.nextToken());
				
				if(here[i] > there[i]) {
					int temp = here[i];
					here[i] = there[i];
					there[i] = temp;
				}
//				System.out.println(here);
			}
			
			boolean true_check = false;
			boolean false_check = false;
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(here[i] <= here[j] && here[j] <= there[i]) {						
//						System.out.println("1 : "+here[i] +" < "+here[j]+" < " + there[i]);
						corridor[i][j] = true;
						true_check = true;
					}else if(here[i] <= there[j] && there[j] <= there[i]) {
//						System.out.println("2 : "+here[i] +" < "+there[j]+" < " + there[i]);
						corridor[i][j] = true;
						true_check = true;
					}else {
						corridor[i][j] = false;
						false_check = true;
					}
				}
			}
			
			int res = 0;
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if(corridor[i][j] == true) {
						res += 1;
					}
				}
			}
			
			if(false_check) {
				res += 1;
			}else {
				if(res == 1) {
					res = 2;
				}
			}
			
			
			
//			Arrays.sort(room);
			
			
			System.out.printf("#%d %d\n",t,res);
			
			
		}
		
		

	}

}
