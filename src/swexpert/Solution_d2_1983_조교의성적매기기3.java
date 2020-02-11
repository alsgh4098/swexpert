package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d2_1983_조교의성적매기기3 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=1; i<=tc; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int people = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken())-1;
			
			Integer[] stu_scr = new Integer[people];
			String[] grade = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D+","D0","D-"};
			int k_score = 0;
			
			for (int j = 0; j < people; j++) {
				st = new StringTokenizer(br.readLine());
				
				int one = Integer.parseInt(st.nextToken());
				int two = Integer.parseInt(st.nextToken());
				int thr = Integer.parseInt(st.nextToken());
				
				stu_scr[j] = one*35 + two*45 + thr*20;
				
				if(j==k) {
					k_score = stu_scr[j];
				}
				
			}
			
			
			Arrays.sort(stu_scr,Comparator.reverseOrder());
			
			int k_index = 0;
			
			for (int j = 0; j < stu_scr.length; j++) {
					if( stu_scr[j] == k_score ) {
						k_index = j;
					}
			}
			
			String k_grade = grade[k_index/(people/10)];
			
			System.out.printf("#%d %s\n",i,k_grade);
		}
		
		
	}

}
