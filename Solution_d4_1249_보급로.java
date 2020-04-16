import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_1249_보급로 {
	
	static int N;
	static int[][] map;
	static int[][] memoi;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N+2][N+2];
			memoi = new int[N+2][N+2];
			
			
			
			for (int i = 0; i < N+2; i++) {
				map[0][i] = -1;
				map[N+1][i] = -1;
				map[i][0] = -1;
				map[i][N+1] = -1;
				Arrays.fill(memoi[i], Integer.MAX_VALUE);
			}
			
			char[] number = null;
			
			for (int i = 1; i < N+1; i++) {
				number = br.readLine().toCharArray();
				for (int j = 1; j < N+1; j++) {
					map[i][j] = number[j-1]-'0';
				}
			}
			
			Queue<int[]> q = new LinkedList<int[]>();
			
			// x,y,score
			q.offer(new int[] {1,1,0});
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
							
					for (int i = 0; i < 4; i++) {
						int x = temp[0]+dx[i];
						int y = temp[1]+dy[i];
						int s = temp[2];
						if(map[x][y] != -1) {
							int score = s + map[x][y];
							if( memoi[x][y] > score) {
								memoi[x][y] = score;
								q.offer(new int[] {x,y,memoi[x][y]});
						}
					}
				}
			}
			 
			 System.out.printf("#%d %d\n",t,memoi[N][N]);
			
		}
	}

	
	static void printMap(int[][] map) {
		for (int i = 0; i < N+2; i++) {
			for (int j = 0; j < N+2; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
