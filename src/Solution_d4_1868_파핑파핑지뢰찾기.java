import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d4_1868_파핑파핑지뢰찾기 {

	static char[][] map;
	static int N;
	static int[] dx = { -1,-1,0,1,1,1,0,-1 };
	static int[] dy = { 0,1,1,1,0,-1,-1,-1 };
	static boolean zero;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());

			map = new char[N + 2][N + 2];

			// * 지뢰
			// . 노지뢰

			// A로 패딩
			for (int i = 0; i < N + 2; i++) {
				map[i][0] = 'A';
				map[i][N + 1] = 'A';
				map[0][i] = 'A';
				map[N + 1][i] = 'A';
			}

			char[] chr_arr;

			for (int i = 1; i < N + 1; i++) {
				chr_arr = br.readLine().toCharArray();
				for (int j = 1; j < N + 1; j++) {
					map[i][j] = chr_arr[j - 1];
				}
			}
//			printMap();
			// 지뢰 아닌칸에 숫자찍어주기.
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					mk_num(i, j);

				}
			}
//			printMap();

			//결과값
			int res = 0;
			
			for (int i = 1; i < N + 1; i++) {
				for (int j = 1; j < N + 1; j++) {
					
					
					//0인지 여부 먼저확인
					//0이면 8방에 연결된 부분 전부 밝혀주고 한 번 클릭한걸로 계산.
					if(map[i][j] == '0') {
						zero_chck(i, j);						
					}
					
					if(zero) {
						res++;
					}
					zero = false;
				

				}
				
			}
			
			for (int i = 1; i < N+1; i++) {
				for (int j = 1; j < N+1; j++) {
					// 남은값 더 해주기
					if (map[i][j] != 'A' 
						&& map[i][j] != '*' 
						&& map[i][j] != 'B') {
						res++;
					}
				}
			}

//			printMap();
			
			System.out.printf("#%d %d\n",t,res);

		}

	}

	static void printMap() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	// 8방향의 지뢰를 찾아서 갯수만큼 그 자리에 입력.
	static void mk_num(int x, int y) {
		if (map[x][y] == '*') {
		}

		if (map[x][y] == '.') {
			int number = 0;

			for (int i = 0; i < 8; i++) {
//				System.out.print(dx[i]);
//				System.out.print(" "+dy[i]+"\n");
				if (map[x + dx[i]][y + dy[i]] == '*') {
					number++;
				}
			}
//			System.out.println();

			map[x][y] = Character.forDigit(number, 10);
		}

	}

	// 0이 있는 8방을 모두 B로 바꿔줌
	static void zero_chck(int x, int y) {
		if (map[x][y] == 'A' || map[x][y] == '*' || map[x][y] == 'B') {

			return;
		}
		
//		if(map[x][y] == '0') {
			map[x][y] = 'B';
			zero = true;
			for (int i = 0; i < 8; i++) {
				if(map[x+dx[i]][y+dy[i]] =='0') {
					zero_chck(x + dx[i], y + dy[i]);
				}else if(map[x+dx[i]][y+dy[i]] != 'A'
						&& map[x+dx[i]][y+dy[i]] != 'B'
						&& map[x+dx[i]][y+dy[i]] != '*'){
					map[x+dx[i]][y+dy[i]] = 'B';
				}
//				zero_chck(x + dx[i], y + dy[i]);
			}
//		}
		
	}

}
