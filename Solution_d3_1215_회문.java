

import java.util.Scanner;

public class Solution_d3_1215_회문 {

	static char[][] chr_map ;
	static char[] chr_arr;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		for (int t = 1; t <= 10; t++) {
			int N = sc.nextInt();
			chr_map = new char[8][8];
			
			sc.nextLine();
			
			for (int i = 0; i < chr_map.length; i++) {
				String str = sc.nextLine();
				chr_arr = str.toCharArray();
				for (int j = 0; j < chr_map.length; j++) {
						chr_map[i][j] = chr_arr[j];
				}
			}
			
			int count = 0;

			
			// 회문이 짝수
			if(N%2 == 0) {
				//가로검사
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 9-N; j++) {
						StringBuilder sb = new StringBuilder();
						
						for (int k = 0; k < N; k++) {
							sb.append(chr_map[i][j+k]);
						}
						String str = sb.toString();
						String str2 = sb.reverse().toString();
						
						if( str.equals(str2)) {
							count++;
						}
					}
				}
				
				
				//세로검사
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 9-N; j++) {
						StringBuilder sb = new StringBuilder();
						
						for (int k = 0; k < N; k++) {
							sb.append(chr_map[j+k][i]);
						}
						String str = sb.toString();
						String str2 = sb.reverse().toString();
						
						if( str.equals(str2)) {
							count++;
						}
					}
				}
			 //회문이 홀수
			}else if(N%2 ==1) {
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 9-N; j++) {
						StringBuilder sb = new StringBuilder();
						
						for (int k = 0; k < N; k++) {
							sb.append(chr_map[i][j+k]);
						}
						String str = sb.toString();
						String str2 = sb.reverse().toString();
						
						if( str.equals(str2)) {
							count++;
						}
					}
				}
				
				
				//세로검사
				for (int i = 0; i < 8; i++) {
					for (int j = 0; j < 9-N; j++) {
						StringBuilder sb = new StringBuilder();
						
						for (int k = 0; k < N; k++) {
							sb.append(chr_map[j+k][i]);
						}
						String str = sb.toString();
						String str2 = sb.reverse().toString();
						
						if( str.equals(str2)) {
							count++;
						}
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,count);
			
		}
	
	}

}
