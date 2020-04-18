import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_4615_재미있는오셀로게임2 {
	
	public static int N;
	
	public static int[][] map;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			map = new int[N][N];
			
			// 초기 바둑판
			if(N==4) {
				map[1][1] = 2;
				map[2][2] = 2;
				map[1][2] = 1;
				map[2][1] = 1;				
			}else if(N==6) {
				map[2][2] = 2;
				map[3][3] = 2;
				map[2][3] = 1;
				map[3][2] = 1;
			}else if(N==8) {
				map[3][3] = 2;
				map[4][4] = 2;
				map[3][4] = 1;
				map[4][3] = 1;
			}
			
			int M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken())-1;
				
				int y = Integer.parseInt(st.nextToken())-1;
				
				int b_w = Integer.parseInt(st.nextToken());
				
				check(x,y,b_w);
				
			}
			
			int w_sum = 0;
			int b_sum = 0;
			
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map.length; j++) {
					if(map[i][j] == 1) {
						b_sum++;
					}else if(map[i][j] == 2){
						w_sum++;
					}
				}
			}
			
			
			System.out.printf("#%d %d %d\n",t ,w_sum,b_sum);
			
		}

	}
	
	public static void check(int x, int y, int b_w) {
		//8방 체크
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		System.out.println();
		
		// 왼
		if( y-2 >= 0) {
			if (map[y-2][y] == b_w
			  && map[y-1][y] == ((b_w == 1) ? 2 : 1) ){
				map[y-1][y] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		// 오른
		if( y+2 < N) {
			if (map[y+2][y] == b_w
			  && map[y+1][y] == ((b_w == 1) ? 2 : 1) ){
				map[y+1][y] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		//위
		if( x-2 >= 0) {
			if (map[x-2][y] == b_w
			  && map[x-1][y] == ((b_w == 1) ? 2 : 1) ){
				map[x-1][y] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		//아래
		if( x+2 < N) {
			if (map[x+2][y] == b_w
			  && map[x+1][y] == ((b_w == 1) ? 2 : 1) ){
				map[x+1][y] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		//왼위
		if( x-2 >= 0 && y-2 >= 0) {
			if (map[x-2][y-2] == b_w
			  && map[x-1][y-1] == ((b_w == 1) ? 2 : 1) ){
				map[x-1][y-1] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		//왼아래
		if( x+2 < N && y-2 >= 0) {
			if (map[x+2][y-2] == b_w
			  && map[x+1][y-1] == ((b_w == 1) ? 2 : 1) ){
				map[x+1][y-1] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		//오른위
		if( x-2 >= 0 && y+2 < N) {
			if (map[x-2][y+2] == b_w
			  && map[x-1][y+1] == ((b_w == 1) ? 2 : 1) ){
				map[x-1][y+1] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
		//오른아래
		if( x+2 < N && y+2 < N) {
			if (map[x+2][y+2] == b_w
			  && map[x+1][y+1] == ((b_w == 1) ? 2 : 1) ){
				map[x+1][y+1] = b_w;
				map[x][y] = b_w;
				return;
			}
		}
		
	}

}