

import java.util.Scanner;

public class Solution_d3_3376_파도반수열 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 
		
		long[] arr = new long[100];
		
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 1;
		
		for(int i=3; i<100; i++) {
			arr[i] = arr[i-2] + arr[i-3];
		}
		
//		for(int i=0; i<100; i++) {
//			System.out.println(arr[i]);
//		}
		
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int n = sc.nextInt();
			System.out.printf("#%d %d\n",i,arr[n-1]);
		}
	}

}
