package _0214_;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution_d3_8673_코딩토너먼트 {

	static ArrayList<Integer> list;
	static int N;
	static int SUM;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		
		for (int t = 1; t <= TC; t++) {
			N = sc.nextInt();

			SUM = 0;
			
			ArrayList<Integer> list = new ArrayList<Integer>();
			
			for (int i = 0; i < Math.pow(2, N); i++) {
				list.add(sc.nextInt());
			}
			
			solution(list);
			
			System.out.printf("#%d %d\n",t,SUM);
		}

	}
	
	static void solution(ArrayList<Integer> list) {
		
		ArrayList<Integer> n_list = new ArrayList<Integer>();
		
		if(list.size() == 1) {
			return;
		}
		
		int len = list.size();
		
//		System.out.println(len);
		
		int i = 0;
		
		while( i < len-1) {
			
			if( list.get(i).intValue() < list.get(i+1).intValue()) {
				SUM += list.get(i+1).intValue() - list.get(i).intValue();
				
				n_list.add(list.get(i+1));
				
//				System.out.println(SUM+" sum");
			}else {
				SUM += list.get(i).intValue() - list.get(i+1).intValue();
				
				n_list.add(list.get(i));
				
//				System.out.println(SUM+" sum");
			}
			
			i += 2;
		}
		
		solution(n_list);
	}

	
}
