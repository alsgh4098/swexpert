
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.concurrent.LinkedBlockingDeque;

public class Solution_d5_오나의여신님_교수님 {

	static String src = "2\r\n" + 
			"5 3\r\n" + 
			"D*S\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			"...\r\n" + 
			"5 3\r\n" + 
			"D*S\r\n" + 
			"...\r\n" + 
			".X.\r\n" + 
			".X.\r\n" + 
			"...";
	
	static int T,R,C;
	static char[][] map;
	static int[][] dirs = { { -1, 0 }, 
							{ 1, 0 }, 
							{ 0, -1 }, 
							{ 0, 1 } };
	static StringBuilder sb = new StringBuilder();
	static Queue<Point> devil,player;
	
	static class Point {
		int row, col, depth;

		@Override
		public String toString() {
			return "Point [row=" + row + ", col=" + col + ", depth=" + depth + "]";
		}

		public Point(int row, int col, int depth) {
			super();
			this.row = row;
			this.col = col;
			this.depth = depth;
		}

	}
			
	
	public static void main(String[] args) throws NumberFormatException, Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//주석 처리할 부분.
		br = new BufferedReader(new StringReader(src));
		//
		
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			sb.append("#").append(t).append(" ");
			/////////////////////////////////////////////////////
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			R = Integer.parseInt(tokens.nextToken()); // N, M (2<=N, M<50)
			C = Integer.parseInt(tokens.nextToken());
			
			map = new char[R][C];
			
			devil = new LinkedList<>();
			player = new LinkedList<>();
			
			for (int r = 0; r < R; r++) {
				map[r] = br.readLine().toCharArray();
				for(int c=0; c<C; c++) {
					if(map[r][c] =='*') {
						devil.offer(new Point(r,c,0));
					}else if(map[r][c]=='S'){
						player.offer(new Point(r,c,0));
					}
				}
			}
			
			while(true) {
				// 1.만약 플레이어가 없다면 --> game over
				if(player.size() == 0) {
					sb.append("Game Over");
					break;
				}
				// 2. devile이 1초 동작 --> ., S를 만나면 오염시킨다.
				bfsDevil();
				// 3. player가 동작 --> .으로 이동, D를 민니먄 정려
				int result = bfsPlayer();
				
				if(result != -1) {
					sb.append(result);
					break;
				}
				
			}
			
			
			/////////////////////////////////////////////////////
			sb.append("\n");
		}
		System.out.println(sb);
		

	}
	
	private static int bfsPlayer() {
		int size = player.size();
		while(size-->0) {
			Point front = player.poll();
			
			//자식 탐색 - 사방탐색
			
			for (int d = 0; d < dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				
				// 범위에 있다면 수연이는 .로 이동, D가 목적지.
				if(isIn(nr,nc)) {
					if(map[nr][nc]=='D') {
						return front.depth+1;
					}else if(map[nr][nc]=='.'){
						map[nr][nc] = 'S';
						player.offer(new Point(nr,nc,front.depth+1));
					}
				}
			}
		}
		return -1;
	}

	// 새로운 녀석은 그냥 담아 둘 뿐
	static void bfsDevil() {
		int size = devil.size();
		while(size-->0) {
			Point front = devil.poll();
			
			//자식 탐색 - 사방타색
			
			for (int d = 0; d < dirs.length; d++) {
				int nr = front.row + dirs[d][0];
				int nc = front.col + dirs[d][1];
				
				// 범위에 있다면 악마는 ., S를 대상으로 이동
				if(isIn(nr,nc)) {
					if(map[nr][nc]=='.'||map[nr][nc]=='S') {
						map[nr][nc] = '*';
						devil.offer(new Point(nr,nc,front.depth+1));
					}
				}
			}
		}
	}

	private static boolean isIn(int nr, int nc) {
		return 0<=nr&&nr<R&&0<=nc&&nc<C;
	}

}
