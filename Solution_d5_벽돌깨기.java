package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_d5_벽돌깨기 {
	
	static int TC,N,C,R;
	
	static int[][] map;
	
	static StringBuilder sb = new StringBuilder();
	
	static int[][] dirs = { {-1,0}, {1,0}, {0,1}, {0,-1} };
	
	static int brickCnt;
	
	static int answer;
	
	static String src = "5\r\n" + 
			"3 10 10\r\n" + 
			"0 0 0 0 0 0 0 0 0 0\r\n" + 
			"1 0 1 0 1 0 0 0 0 0\r\n" + 
			"1 0 3 0 1 1 0 0 0 1\r\n" + 
			"1 1 1 0 1 2 0 0 0 9\r\n" + 
			"1 1 4 0 1 1 0 0 1 1\r\n" + 
			"1 1 4 1 1 1 2 1 1 1\r\n" + 
			"1 1 5 1 1 1 1 2 1 1\r\n" + 
			"1 1 6 1 1 1 1 1 2 1\r\n" + 
			"1 1 1 1 1 1 1 1 1 5\r\n" + 
			"1 1 7 1 1 1 1 1 1 1\r\n" + 
			"2 9 10\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 0 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"0 1 0 0 0 0 0 0 0\r\n" + 
			"1 1 0 0 1 0 0 0 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 0 1 1 1 0 1 0\r\n" + 
			"1 1 1 1 1 1 1 1 0\r\n" + 
			"1 1 3 1 6 1 1 1 1\r\n" + 
			"1 1 1 1 1 1 1 1 1\r\n" + 
			"3 6 7\r\n" + 
			"1 1 0 0 0 0\r\n" + 
			"1 1 0 0 1 0\r\n" + 
			"1 1 0 0 4 0\r\n" + 
			"4 1 0 0 1 0\r\n" + 
			"1 5 1 0 1 6\r\n" + 
			"1 2 8 1 1 6\r\n" + 
			"1 1 1 9 2 1\r\n" + 
			"4 4 15\r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"0 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 0 0 \r\n" + 
			"1 0 5 0 \r\n" + 
			"1 1 1 0 \r\n" + 
			"1 1 1 9 \r\n" + 
			"1 1 1 1 \r\n" + 
			"1 6 1 2 \r\n" + 
			"1 1 1 5 \r\n" + 
			"1 1 1 1 \r\n" + 
			"2 1 1 2 \r\n" + 
			"4 12 15\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9\r\n" + 
			"9 9 9 9 9 9 9 9 9 9 9 9";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		br = new BufferedReader(new StringReader(src));
		
		TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			sb.append("#").append(t).append(" ");
			/////////////////////////////////////////////////////////
			StringTokenizer tokens = new StringTokenizer(br.readLine());
			N = Integer.parseInt(tokens.nextToken());
			C = Integer.parseInt(tokens.nextToken());
			R = Integer.parseInt(tokens.nextToken());
			
			map = new int[R][C];
			brickCnt = 0;
			for (int r = 0; r < R; r++) {
				tokens = new StringTokenizer(br.readLine());
				for (int c = 0; c < C; c++) {
					map[r][c] = Integer.parseInt(tokens.nextToken());
					if(map[r][c]!=0) {
						brickCnt++;
					}
				}
			}
			
			answer = brickCnt;
			
//			출력 테스트
//			for (int[] row : map) {
//				System.out.println(Arrays.toString(row));
//			}
			
			// 구슬을 하나씩 떨어뜨려보자
			// 좌표가 달라져야 한다. --> 중복순열로 좌표 고르자
			// 벽돌의 개수도 전달, map도 전달
			
			dropMarble(N,brickCnt,map);
			
			sb.append(answer);
			/////////////////////////////////////////////////////////
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	//중복 순열
	private static void dropMarble(int r, int brickCnt, int[][] map) {
		if(r==0) {
			// 솔루션 사용.
			answer = Math.min(answer, brickCnt);
			return;
		}
		
		for(int c = 0; c<C; c++) {
			// 1.map의 복제
			int[][] cloned = cloneMap(map);
			// 2.해당 컬럼의 맨 처음 벽돌 가져오기
			Brick first = getFirstBrick(c,cloned);
			// 2-1 null -> continue
			if(first == null) continue;
			// 3. 구슬을 떨어뜨려서 벽돌을 깬다. --> 깨진 벽돌 개수??
			int broken = crash(first,cloned);
			// 3-1 이미 다 벽돌이 깨졌다면?? 정답 = 0, 종료
			if(broken >= brickCnt) {
				answer = 0;
				return;
			}
			// 4. 화면 정리
			cleanMap(cloned);
			// 5. 다음 샷 발사
			dropMarble(r-1, brickCnt-broken, cloned);
		}
		
	}

	private static void cleanMap(int[][] map) {
		for (int c = 0; c < C; c++) {
			for (int r = R-1, nr = R-1; r>=0.; r--) {
				if(map[r][c] != 0) {
					int temp = map[r][c];
					map[r][c] = 0;
					map[nr--][c] = temp;
				}
			}
		}
		
	}

	private static int crash(Brick first, int[][] map) {
		int broken = 0;
		// 얻어맞은 벽돌 삭제
		map[first.row][first.col] = 0;
		broken++;
		// 주변벽돌에 영향 주기.
		for (int p= 1; p < first.pow; p++) {
			// 사방탐색
			for (int d = 0; d < dirs.length; d++) {
				int nr = first.row + dirs[d][0]*p;
				int nc = first.col + dirs[d][1]*p;
				
				if(isIn(nr,nc) && map[nr][nc]!=0) {
					broken += crash(new Brick(nr,nc,map[nr][nc]), map);
				}
			}
		}
		
		return broken;
	}

	private static boolean isIn(int r, int c) {
		return 0<=r && 0<=c && r < R & c < C;
	}

	private static Brick getFirstBrick(int c, int[][] map) {
		for (int r = 0; r < R; r++) {
			if(map[r][c] != 0) {
				return new Brick(r,c,map[r][c]);
			}
		}
		return null;
	}

	private static int[][] cloneMap(int[][] map) {
		int[][] temp = new int[R][C];
		
		for (int i = 0; i < R; i++) {
			temp[i] = map[i].clone(); // deep copy
//			temp[i] = map[i];  swallow copy 단순 레퍼런스 복사.
		}
		
		return temp;
	}
	
	static class Brick{
		int row,col,pow;

		@Override
		public String toString() {
			return "Brick " + row + ", " + col + ", " + pow + "]";
		}

		public Brick(int row, int col, int pow) {
			super();
			this.row = row;
			this.col = col;
			this.pow = pow;
		}
	}

}
