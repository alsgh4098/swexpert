package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_역량_디저트카페 {
	
	// 사각형을 이루는 네방향을 한번씩 무조건 써야함.
		 		 // 오른아래 오른위 왼위 왼아래
	static int[] dx = {1,-1,-1,1};
	static int[] dy = {1,1,-1,-1};
	
	static int N;
	static int[][] map;
	static boolean[][] visited;
	static boolean[] dessert;
	static int max;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			max = Integer.MIN_VALUE;
			
			StringTokenizer st;
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited = new boolean[N][N]; // 왔던길 체크
			dessert = new boolean[101]; // 디저트 종류체크
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					visited[i][j] = true;
					dessert[map[i][j]] = true;
					dfs(i,j,i,j,0,0);
					visited[i][j] = false;
					dessert[map[i][j]] = false;
				}
			}
			
			System.out.println("#"+t+" "+((max==Integer.MIN_VALUE)?-1:max+1));
		
		}

	}//end main
	
	// 시작 x,y 와 먹은 디저트 종류를 체크할 count
	static void dfs(int x, int y,int sx, int sy, int count, int d) {
		//사각형을 만들고(네방향을 다 사용하고) 출발점으로 돌아왔을 때
		int nx = x+dx[d];
		int ny = y+dy[d];

		if(!inner(nx, ny)) {
			return;
		}
		
		if(nx==sx && ny==sy && d == 3 && visited[nx][ny]) {
			
			if(count > max) {
				max = count;
			}
			
			return;
		}
		
		// 출발점으로 돌아가는것외에 방문했던곳을 다시 갈 때
		if(visited[nx][ny]) {
			return;
		}
		
		// 이미 먹은 디저트일때.
		if(dessert[map[nx][ny]]) {
			return;
		}
		
		// 방문체크
		visited[nx][ny] = true;
		// 디저트체크
		dessert[map[nx][ny]] = true;
		
		
		if(d<3) {			
			dfs(nx,ny,sx,sy,count+1,d+1);
		}
		dfs(nx,ny,sx,sy,count+1,d);
		
		visited[nx][ny] = false;
		dessert[map[nx][ny]] = false;
		
		
	}
	static boolean inner(int x,int y) {
		if(0<=x && x<N && 0<=y && y<N) {
			return true;
		}else {
			return false;
		}
	}

}
