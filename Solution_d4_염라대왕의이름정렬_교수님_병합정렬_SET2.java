package swexpert2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

// 정렬 - 우선순위
// 중복을 제거


public class Solution_d4_염라대왕의이름정렬_교수님_병합정렬_SET2 {
	
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine()); // 1~50
		
		for (int t = 1; t <= TC; t++) {
			int N = Integer.parseInt(br.readLine()); // 이름의 개수 1~20,000
			
			Set<String> set = new TreeSet<String>(new Comparator<String>() {
				@Override
				public int compare(String pre, String next) {
					if(pre.length() != next.length()) { // 글자의 길이 짧은순서
						return pre.length() - next.length();
					}else { // 길이가 같으면, 사전순
						return pre.compareTo(next); // 오름차순
					}
				}
			});
			
			for (int i = 0; i < N; i++) {
				set.add(br.readLine());
			}
			
			StringBuilder sb = new StringBuilder();
			
			// 중복제거
			sb.append("#"+t+"\n");
			
			Iterator<String> iter = set.iterator();
			
			while(iter.hasNext()) {
				sb.append(iter.next()+"\n");
			}
			
			System.out.println(sb);
		} // end of testCase
		
		
	}

}// end of class
