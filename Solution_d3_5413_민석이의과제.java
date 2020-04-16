package _0214_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d3_5413_민석이의과제 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <=TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			int number = 0;
			boolean check = false;
			
			
			System.out.printf("#%d ",t);
			for (int i = 1; i <= N; i++) {
				number = i;
				
				for (int j = 0; j < M; j++) {
					if(number == arr[j]) {
//						System.out.printf("%d ",number);
						check = true;
						break;
					}{
						check = false;
					}
				}
				
				if(check) {
				}else {
					System.out.printf("%d ",number);
					check = false;
				}
				
			}
			System.out.println();
		}
		

	}

}
