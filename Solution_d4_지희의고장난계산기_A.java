package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_지희의고장난계산기_A {

	static boolean[] btn;

	static int X;
	
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			btn = new boolean[10];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num;
			for (int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					btn[i] = true;
				}
			}

			X = Integer.parseInt(br.readLine());
			find(X,0);
			
			min = min == Integer.MAX_VALUE ? -1:min;

			System.out.println("#" + t + " " + min);
		}

	}// end main

	private static int find(int x, int cnt) {
		// TODO Auto-generated method stub
		if(isMake(x+"")) {
			
			if(cnt == 0) {
				min = len(x) + 1;
			}
			return len(x)+1;
		}
		int result = -1;
		
		for (int i = 2, end = (int)Math.sqrt(x)+1; i < end; i++) {
			if( x%i==0 && isMake(i+"")) {
				int len1 = len(i)+i;
				
				int len2 = find(x/i,cnt+1);
				
				if(len2>-1) {
					result = len1+len2;
					if(result < min && x == X) {
						min = result;
					}
				}
			}
		}
		return result;
		
	}
	

	private static int len(int x) {
		return (int)(Math.log10(x)+1);
	}

	private static boolean isMake(String x) {
		for(char c : x.toCharArray()) {
			if( !btn[c-'0']) {
				return false;
			}
		}
		return true;
	}


}
