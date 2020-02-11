package swexpert;

import java.util.Scanner;

public class Solution_d2_간단한압축풀기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		
		
		for(int i=1; i<=tc; i++) {
			char[] chr_arr = null;
			int number = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			sc.nextLine();
			for(int j=1; j<=number; j++) {
				String str = sc.next();
				char chr = str.charAt(0);
				int chr_len = sc.nextInt();
				
				
				for(int k=1; k<=chr_len; k++) {
					sb.append(chr);
				}
			}
			chr_arr = sb.toString().toCharArray();
			System.out.printf("#%d\n",i);
			for(int j=0; j<chr_arr.length; j++) {
				System.out.print(chr_arr[j]);
				if( j%10 == 9) {
					System.out.println();
				}
			}
			System.out.println();
			
		}
		
	}

}
