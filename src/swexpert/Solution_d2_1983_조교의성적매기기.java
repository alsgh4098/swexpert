package swexpert;

import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Solution_d2_1983_조교의성적매기기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int std_num = sc.nextInt();
			int find_std_num = sc.nextInt()-1;
			
			Integer[] score = new Integer[std_num];
			
			for(int j=0; j<std_num; j++) {
				score[j] = sc.nextInt()*35 + sc.nextInt()*45 + sc.nextInt()*20;
			}
			
			String[] score_list = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			
//			for(int x=0; x<std_num; x++) {
//				for(int y=0; y<std_num-x-1; y++) {
//					if(y==find_std_num) {
//						find_std_score = score[y];
//					}
//					
//					if(score[y] < score[y+1]) {
//						int temp = score[y+1];
//						score[y+1] = score[y];
//						score[y] = temp;
////						System.out.println(score[x]);
//					}
//				}
//			}
			int find_std_score = score[find_std_num];
			Arrays.sort(score, java.util.Collections.reverseOrder());
			int find_std_num3 = Arrays.asList(score).indexOf(find_std_score);
			
//			for(int j=0; j<score.length; j++) {
//				if(score[j] == find_std_score) {
//					find_std_num = j;
//				}
//			}
			
			int index = (find_std_num3 * 10)/std_num;
			
			System.out.printf("#%d %s\n",i,score_list[index]);
			
		}
		
		
	}

}
