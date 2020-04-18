import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d4_1226_미로1 {
	
	static int[][] map;
	// 상,우,하,좌
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean possible;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <= 10; t++) {
			
			// 16x16
			map = new int[18][18];
			
			int tc = Integer.parseInt(br.readLine());
			
			//패딩
			for (int i = 0; i < 18; i++) {
				map[0][i] = 1;
				map[0][17] = 1;
				map[i][0] = 1;
				map[17][0] = 1;
				
			}
			
			// 시작점 2
			// 벽 1
			// 길 0
			// 도착점 3
			// 갔던길 1
			char[] chr_arr;
			int sx = 0;
			int sy = 0;
			
			for (int i = 1; i < 17; i++) {
				chr_arr = br.readLine().toCharArray();
				for (int j = 1; j < 17; j++) {
					map[i][j] = chr_arr[j-1]-'0';
					if(map[i][j] == 2) {
						sx = i;
						sy = j;
					}
				}
			}
			
			possible = false;
			
			solution(sx,sy);
			
			System.out.printf("#%d %d\n",tc,(possible)?1:0);
			
		}

	}
	
	static void solution(int x, int y) {
		if(map[x][y] == 1) {
			return;
		}else if(map[x][y] == 3) {
			possible = true;
			return;
		}
		
		for (int i = 0; i < 4; i++) {
			// 갔던길 체크
//			int temp = map[x][y];
			map[x][y] = 1;
			solution(x+dx[i],y+dy[i]);
//			map[x][y] = temp;
		}
	}

}
