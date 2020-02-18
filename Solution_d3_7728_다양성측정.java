package _0214_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_7728_다양성측정 {
	
	static int[] number;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			number = new int[10];
			
			int count = 0;
			
			char[] nmb_list = br.readLine().toCharArray();
			
			for (int i = 0; i < nmb_list.length; i++) {
				number[nmb_list[i]-'0'] = 1;
			}
			
			for (int i = 0; i < number.length; i++) {
				if(number[i] != 0) {
					count++;
				}
			}
			
			System.out.printf("#%d %d\n",t,count);
			
		}
		
	}

}
