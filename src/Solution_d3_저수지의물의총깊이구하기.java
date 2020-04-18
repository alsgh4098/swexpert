

import java.util.Scanner;

public class Solution_d3_저수지의물의총깊이구하기 {
	
	static char[][] map;
	static int max = Integer.MIN_VALUE;

	//좌표를 주는것이 아니라 맵을 직접주는경우.
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		String str;
		char[] chr_arr;
		for (int t = 1; t <= tc; t++) {
			int N = sc.nextInt();
			map = new char[N][N];
			max = Integer.MIN_VALUE;
			
			int number;
			
			// nextint를 받고난다음 공백을 버린다.
			sc.nextLine();
			
			for (int i = 0; i < N;  i++) {
				//한줄 입력받기.
				str = sc.nextLine();
				str = str.replace(" ", "");
//				System.out.println(str);
				chr_arr = str.toCharArray();
//				System.out.println(chr_arr.length);
				
				for (int j = 0; j < N; j++) {
					map[i][j] = chr_arr[j];
				}
			
			}
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					depth_check(map,i,j);
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		}
		
		
	}
	
	public static void depth_check(char[][] map,int x, int y) {
		int w_count = 0;
		int g_count = 0;
		
		//8방 체크
		
		// 왼
		if( x-1 >= 0) {
			if (map[x-1][y] == 'W') {
				w_count++;
			}else if (map[x-1][y] == 'G') {
				g_count++;
			}
		}
		
		// 오른
		if( x+1 < map.length) {
			if (map[x+1][y] == 'W') {
				w_count++;
			}else if (map[x+1][y] == 'G') {
				g_count++;
			}
		}
		
		//위
		if( y-1 >= 0) {
			if (map[x][y-1] == 'W') {
				w_count++;
			}else if (map[x][y-1] == 'G') {
				g_count++;
			}
		}
		
		//아래
		if( y+1 < map.length) {
			if (map[x][y+1] == 'W') {
				w_count++;
			}else if (map[x][y+1] == 'G') {
				g_count++;
			}
		}
		
		//왼위
		if( x-1 >= 0 && y-1>=0) {
			if (map[x-1][y-1] == 'W') {
				w_count++;
			}else if (map[x-1][y-1] == 'G') {
				g_count++;
			}
		}
		
		//왼아래
		if( x-1 >= 0 && y+1 < map.length) {
			if (map[x-1][y+1] == 'W') {
				w_count++;
			}else if (map[x-1][y+1] == 'G') {
				g_count++;
			}
		}
		
		//오른위
		if(  x+1 < map.length && y-1>=0 ) {
			if (map[x+1][y-1] == 'W') {
				w_count++;
			}else if (map[x+1][y-1] == 'G') {
				g_count++;
			}
		}
		
		//오른아래
		if(  x+1 < map.length && y+1 < map.length) {
			if (map[x+1][y+1] == 'W') {
				w_count++;
			}else if (map[x+1][y+1] == 'G') {
				g_count++;
			}
		}
		
		if(g_count == 8) {
			w_count = 1;
		}
		
		if(w_count > max) {
			max = w_count;
		}
	}

}
