package _0214_;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d3_1221_5일차GNS {

	static ArrayList<String> num;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		num = new ArrayList<>();
		
		num.add("ZRO");
		num.add("ONE");
		num.add("TWO");
		num.add("THR");
		num.add("FOR");
		num.add("FIV");
		num.add("SIX");
		num.add("SVN");
		num.add("EGT");
		num.add("NIN");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			st.nextToken();
			
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			String[] arr = new String[N];
			
			for (int i = 0; i < N; i++) {
				arr[i] = st.nextToken();
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = i+1; j < N; j++) {
					if(num.indexOf(arr[j]) < num.indexOf(arr[i])) {
						String temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			
			System.out.printf("#%d ",t);
			for (int j = 0; j < N; j++) {
				System.out.printf("%s ",arr[j]);
			}
			System.out.println();
			
			
		}
		 

	}

}
