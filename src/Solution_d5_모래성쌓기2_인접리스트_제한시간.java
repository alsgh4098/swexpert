
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d5_모래성쌓기2_인접리스트_제한시간 {

	static int[][] map;
	static boolean[][] remove;

	static int N;
	static int M;

	static int[] dx = { -1, -1, -1, 0, 1, 1, 1, 0 };
	static int[] dy = { -1, 0, 1, 1, 1, 0, -1, -1 };

	static int res;
	
	static ArrayList<Sand> list;
	
	static class Sand{
		int x;
		int y;
		int toughness;
		
		public Sand(int x, int y, int toughness) {
			super();
			this.x = x;
			this.y = y;
			this.toughness = toughness;
		}
		
		
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			map = new int[N][M];
			remove = new boolean[N][M];

			res = 0;
			
			list = new ArrayList<Sand>();
			
			for (int i = 0; i < N; i++) {
				String line = br.readLine();
				for (int j = 0; j < M; j++) {
					char chr = line.charAt(j);
					if(chr != '.') {
						map[i][j] = chr-'0';
						list.add(new Sand(i,j,map[i][j]));
					}else {
						map[i][j] = 0;
					}
				}
			} // end input

			while (true) {
				
				int len = list.size();
				
				for (int i = 0; i < len; i++) {
					Sand s = list.get(i);
					int x = s.x;
					int y = s.y;
					
					int sum = 0;

					for (int j = 0; j < 8; j++) {
						int nx = x + dx[j];
						int ny = y + dy[j];

						if (0 <= nx && nx < N && 0 <= ny && ny < M && map[nx][ny] == 0) {
							sum++;
						}
					}

					// 주변에 모래가 없는 칸의 수가 튼튼함과 같거나 크면 true를 리턴함. 지우라는 뜻.
					if (sum >= map[x][y]) {
						remove[x][y] = true;
					}else {
						remove[x][y] = false;
					}
				}

				// 지울게 없음.
				boolean finish = true;
				
				for (int i = 0; i < len; i++) {
					Sand s = list.get(i);
					int x = s.x;
					int y = s.y;
					if(remove[x][y]) {
						list.remove(i);
						len--;
						map[x][y] = 0;
						remove[x][y] = false;
						finish = false;
					}
				}

				if (finish) {
					break;
				} else {
					res++;
				}
			}

			System.out.println("#" + t + " " + res);

		}

	}// end main

}