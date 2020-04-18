

import java.util.Arrays;
import java.util.Scanner;

public class Solution_d3_원재의메모리복구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			
			String number = sc.next();
			
			char[] number_arr = number.toCharArray();
			char[] number_arr2 = new char[number_arr.length];
			Arrays.fill(number_arr2, '0');
			
			int res = 0;
			
			for (int i = 0; i < number_arr.length; i++) {
				if(number_arr[i] == '1') {
					if(number_arr2[i] == '1') {
						continue;
					}else {
						res++;
						for (int j = i; j < number_arr2.length; j++) {
							number_arr2[j] = '1'; 
						}
					}
				}else {
					if(number_arr2[i] == '0') {
						continue;
					}else {
						res++;
						for (int j = i; j < number_arr2.length; j++) {
							number_arr2[j] = '0'; 
						}
					}
				}
				if(Arrays.equals(number_arr, number_arr2)) {
					break;
				}
			}
			
			System.out.println("#"+t+" "+res);
			
		}

	}

}
