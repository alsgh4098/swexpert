
import java.util.Arrays;
import java.util.Scanner;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class Solution_d2_1983_조교의성적매기기2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			int std_num = sc.nextInt();
			int find_std_num = sc.nextInt()-1;
			int find_std_score = 0;
			
			Integer[] score = new Integer[std_num];
			
			for(int j=0; j<std_num; j++) {
				score[j] = sc.nextInt()*35 + sc.nextInt()*45 + sc.nextInt()*20;
			}
			
			String[] score_list = {"A+","A0","A-","B+","B0","B-","C+","C0","C-","D0"};
			
			
			find_std_score = score[find_std_num];
			
			
			for(int x=0; x<std_num; x++) {
				for(int y=0; y<std_num-1; y++) {
					if(score[y] < score[y+1]) {
						int temp = score[y];
						score[y] = score[y+1];
						score[y+1] = temp;
					}
				}
			}
			
			for(int j=0; j<score.length; j++) {
				if(score[j] == find_std_score) {
					find_std_num = j;
				}
			}
			
			int index = (find_std_num * 10)/std_num;
			
			System.out.printf("#%d %s\n",i,score_list[index]);
			
		}
		
		
	}

}
