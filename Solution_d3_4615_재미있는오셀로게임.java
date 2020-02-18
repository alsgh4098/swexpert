

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_4615_재미있는오셀로게임 {
	
	public static int N;
	
	public static int[][] map;
	
	static int[] dx = {-1,-1,-1,0,1,1,1,0};
	static int[] dy = {-1,0,1,1,1,0,-1,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		

		for (int t = 1; t <= TC; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
//			N *= N;
			
			map = new int[N+2][N+2];
			
			// 가장자리 패딩
			for (int i = 0; i < N+2; i++) {
				map[0][i] = 3;
				map[N+1][i] = 3;
				map[i][0] = 3;
				map[i][N+1] = 3;
			}
			
			// 흑1 백2
			// 초기 바둑판
			map[N/2][N/2] = 2;
			map[N/2][N/2+1] = 1;
			map[N/2+1][N/2+1] = 2;
			map[N/2+1][N/2] = 1;
			
//			printMap(map);
			
			int M = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				
				int x = Integer.parseInt(st.nextToken());
				
				int y = Integer.parseInt(st.nextToken());
				
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
			
//			printMap(map);
			
			
			System.out.printf("#%d %d %d\n",t ,b_sum,w_sum);
			
		}

	}
	
	public static void check(int x, int y, int b_w) {
		//b_w는 내가 놓으려는 돌의 색
		// 1흑, 2백

		//8방 탐색
		for (int i = 0; i < 8; i++) {
			//원래 돌을 놓으려던 위치
			int init_x = x;
			int init_y = y;
			
			int init_x2 = x+dx[i];
			int init_y2 = y+dy[i];
			
			//돌을 방향에 따라 한 칸 옮긴 위치
			int nx = x+dx[i];
			int ny = y+dy[i];
			
			//상대방 돌을 넘어갔는지 여부
			boolean change = false;

			//범위를 벗어났으면 다른방향 탐색.
			if( map[nx][ny] == 3) {
				continue;
			}else {
				//범위를 벗어나기 전까지. 정해진 방향으로 탐색.
				
				// 놓으려는 돌의 위치에서 만나게될 자신과 같은 돌의 위치까지.
				int doll_count = 0;
				while(map[nx][ny] != 3) {
					//그 자리에 아무런 돌도 없을때
					if(map[nx][ny] == 0) {
						break;
					//그 자리가 상대방 돌일때.
					}else if(map[nx][ny] == ((b_w == 1) ? 2:1)){
						//돌 바꿔주기.
						doll_count++;
						change = true;
					//자신의 돌일 때
					}else {
						for (int j = 0; j < doll_count; j++) {
							map[init_x2][init_y2] = b_w;
							init_x2 += dx[i];
							init_y2 += dy[i];
						}
						break;
					}
					
					if(change) {
//						바꾸기가 완료되었으면, 원래 돌을 놓으려던 위치에 돌을 놔준다.
						map[init_x][init_y] = b_w;
					}
					
					nx += dx[i];
					ny += dy[i];
				}
				
			}
			
//			printMap(map);
//			System.out.println();
		}
	}
	
	public static void printMap(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

}
