

import java.util.Scanner;

public class Solution_d4_7699_수지의수지맞는여행 {

	static int T;
	static char[][] map;
	static boolean[] alphabet;
	static int R, C, ans;
	static int[] dy = { 0, 0, 1, -1 };
	static int[] dx = { 1, -1, 0, 0 }; // 우, 좌, 하, 상

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		T = sc.nextInt();

		for (int t = 1; t <= T; t++) {
			R = sc.nextInt();
			C = sc.nextInt();
			map = new char[R][C];

			alphabet = new boolean[26];

			for (int i = 0; i < map.length; i++) {
				map[i] = sc.next().toCharArray();
			}

			ans = 0;
//			System.out.println(map[0][0] );
//			alphabet[map[0][0] - 'A'] = true;
			
			dfs(0,0,1);
			
			System.out.println("#"+t+" "+ans);
		}

	}

	public static void dfs(int y, int x, int cnt) {
		// ans = 0
		if (ans < cnt) {
			ans = cnt;
		}

		if (cnt == 26) {
			return;
		}

		alphabet[map[y][x] - 'A'] = true;
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if(ny>=0 && ny<R && nx>=0 
					&& nx<C && !alphabet[map[ny][nx] - 'A']  ) {
				dfs(ny,nx,cnt+1);
			}
		}
		
		alphabet[map[y][x] - 'A'] = false;
	}

}
