package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d3_1244_최대상금 {

	static int N;
	static String number_str;
	static char[] number_chr;
	static char[] number_chr_copy;
	static int change_count;
	static int[] nums;
	static int max = 0;
	static int cnt;
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		
//		int tc = Integer.parseInt(br.readLine());
		int tc = sc.nextInt();
		
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			cnt = 0;
			nums = new int[2];
			number_str = sc.next();
			max = Integer.parseInt(number_str);
			number_chr = number_str.toCharArray();
			
			change_count = Integer.parseInt(sc.next());
//			nCr(0,0);
//			for (int i = 0; i < cnt; i++) {
//			}
			combi(0,0);

			
			
			System.out.printf("#%d %d\n",t,max);
			
		}

	}

	public static void combi(int start, int count) {

		if (2 == count) {
			number_chr_copy = Arrays.copyOf(number_chr, number_chr.length);

			char chr = number_chr_copy[nums[0]];
//			System.out.println(nums[0]);
//			System.out.println(nums[1]);
			number_chr_copy[nums[0]] = number_chr_copy[nums[1]];
			number_chr_copy[nums[1]] = chr;
			
			String str = String.valueOf(number_chr_copy);
			int number_copy = Integer.parseInt(str);
			if(number_copy > max) {
				max = number_copy;
			}
			System.out.println(Arrays.toString(nums));
			
			return;
		} else {
			for (int i = start; i < number_chr.length; i++) {
					nums[count] = i;
					combi(i+1, count + 1);
			}
		}
	}
	
	public static void nCr(int start, int count) {
		if(2==count) {
			cnt++;
			return;
		}
		
		for (int i = start; i < number_str.length(); i++) {
			nCr(i+1,count+1);
		}
	}
}