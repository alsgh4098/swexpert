

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d3_문제제목 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();

		char[] chr_arr;
		int[] num_arr;

		for (int t = 1; t <= tc; t++) {

			int N = sc.nextInt();

			chr_arr = new char[N];
			num_arr = new int[N];

			for (int i = 0; i < N; i++) {
				num_arr[i] = sc.next().charAt(0) - 'A';
			}

			Arrays.sort(num_arr);
			
			int count = 0;
			
			if( num_arr[0] == 0) {
				count++;
			}
			
			if(count == 1) {
				for (int i = 0; i < num_arr.length-1; i++) {
//					System.out.println(num_arr[i]);
					
					if( num_arr[i+1] - num_arr[i] ==1 ) {
							count++;
					}else if(num_arr[i+1] - num_arr[i] == 0) {
									
					}else {
							break;
					}
				}
			}
			
			
			System.out.printf("#%d %d\n", t, count);

		}

	}

}