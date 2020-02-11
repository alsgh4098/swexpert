package swexpert;

import java.util.Scanner;

public class Solution2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		char[] chr_arr;
		
		for (int t = 1; t <= tc ; t++) {
			
			int N = sc.nextInt();
			int[] checkcontin = new int[N];
			
			chr_arr = new char[N];
			
			for (int i = 0; i < N; i++) {
				
				chr_arr[i] = sc.next().charAt(0);
				
				
			}
			
			int max = 0;
			
			for (int i = 0; i < N-1; i++) {
				
				System.out.println(chr_arr[i+1] - chr_arr[i]);
				if(chr_arr[i+1] - chr_arr[i] == 1) {
					checkcontin[i+1] = checkcontin[i]+1;
				}else {
					checkcontin[i+1] = 0;
				}
				
				if(checkcontin[i+1] > max) {
					max = checkcontin[i+1];
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
			
		}
		
	}

}
