package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solutino_d2_1954_달팽이숫자 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
//		int[] dx = { -1,1,0,0 };
//		int[] dy = {  0,0,-1,1 }; // 위, 아래, 왼, 오
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][N];
			
			char dir = 'r';
			
			int number = 1;
			
			int x = 0;
			int y = 0;
			
			
			while( 0<N ) {
				if( dir == 'r') {
					for (int i = 0; i < N; i++) {
						map[x][y] = number;
						y++;
						number++;
					}
					y--;
					x++;
					N = N-1;
					dir = 'd';
				}else if( dir == 'd') {
					for (int i = 0; i < N; i++) {
						map[x][y] = number;
						x++;
						number++;
					}
					x--;
					y--;
					dir = 'l';
				}else if( dir == 'l') {
					for (int i = 0; i < N; i++) {
						map[x][y] = number;
						y--;
						number++;
					}
					
					y++;
					x--;
					N = N-1;
					dir = 'u';
				}else if( dir == 'u') {
					for (int i = 0; i < N; i++) {
						map[x][y] = number;
						x--;
						number++;
					}
					x++;
					y++;
					dir = 'r';
				}
			}
			System.out.printf("#%d\n",t);
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					System.out.printf("%d ",map[i][j]);
				}
				System.out.println();
			}
			
		}

	}

}
