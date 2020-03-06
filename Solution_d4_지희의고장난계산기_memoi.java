package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_지희의고장난계산기_memoi {

	static boolean[] btn;
	static int X;
	static int min;
	static int[] memoi;
	static int size;

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
			
			size = (int)Math.sqrt(X);
			
			memoi = new int[size];
			
			find(X,0);
			
			min = min == Integer.MAX_VALUE ? -1:min;

			System.out.println("#" + t + " " + min);
		}

	}// end main

	private static int find(int x, int cnt) {
		if(x<size && memoi[x] != 0) {
			return memoi[x];
		}
		if(isMake(x+"")) {
			int count = len(x)+1;
			if(cnt == 0) {
				min = count;
			}
			if(x < size) {
				memoi[x] = count;
			}
			return count;
		}
		int result = -1;
		for (int i = 2, end = (int)Math.sqrt(x)+1; i < end; i++) {
			if(x % i == 0 && isMake(i+"")) {
				int len1 = len(i) + 1;
				int len2 = find(x/i,cnt+1);
				
				if(len2>-1) {
					result = len1+len2;
					if(result<min && x == X) {
						min = result;
					}
				}
			}
		}
		if( x < size) {
			memoi[x] = result;
		}
		
		return result;
	}
		
	

	private static boolean isMake(String x) {
		for (char c: x.toCharArray()) {
			if(!btn[c-'0']) {
				return false;
			}
		}
		return true;
	}
	
	static int len(int x) {
		return (int)(Math.log10(x)+1);
	}



}
