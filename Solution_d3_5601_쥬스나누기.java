package _0214_;

import java.util.Scanner;

public class Solution_d3_5601_쥬스나누기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			
			int N = sc.nextInt();
			
			char N_chr = Character.forDigit(N, 10) ;
			
			System.out.printf("#%d",t);
			for (int i = 0; i < N; i++) {
				System.out.printf(" %c/%c",'1',N_chr);
			}
			System.out.println();
		}
		
	}

}
