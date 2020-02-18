package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d4_7733_치즈도둑 {

	static String[][] map;
	static String[][] temp;
	static int N;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static boolean exist_piece;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			N = Integer.parseInt(br.readLine());

			map = new String[N + 2][N + 2];

			for (int i = 0; i < N + 2; i++) {
				for (int j = 0; j < N + 2; j++) {
					map[i][j] = "a";
				}
			}

			StringTokenizer st;

			int maxday = 0;
			int day = 0;

			for (int i = 1; i < N + 1; i++) {

				st = new StringTokenizer(br.readLine());

				for (int j = 1; j < N + 1; j++) {
					map[i][j] = st.nextToken();
					day = Integer.parseInt(map[i][j]);
					if (day > maxday) {
						maxday = day;
					}

				}
			}

			int piece = 0;
			int max_piece = 0;
			temp = new String[N + 2][N + 2];
			
			//day는 0부터 입력받은 치즈의 최고 값까지.
			for (int i = 0; i <= maxday; i++) {
				for (int x = 1; x < N + 1; x++) {
					for (int y = 1; y < N + 1; y++) {
						solution(x, y, i);

					}
				}
				temp_reset(); // 먹은부분을 체크한 맵으로 temp를 초기화.
				for (int x = 1; x < N + 1; x++) {
					for (int y = 1; y < N + 1; y++) {
						// 아직 먹지 않은 부분만 체크.
						// 먹은 부분은 0으로 되어있고, 먹지 않은 부분중 체크된 부분은 b로 체크되어 있음.
						if (!temp[x][y].equals("0") || !temp[x][y].equals("b")) {
							solution2(x, y);
							if (exist_piece) {
								piece++;
							}
							if (piece > max_piece) {
								max_piece = piece;
							}
							exist_piece = false;
						}
					}
				}
//				System.out.printf("day %d\n", i);
//				print_temp();
//				System.out.printf("piece %d\n", piece);

				piece = 0;
			}

			System.out.printf("#%d %d\n", t, max_piece);

		}
	}

	static void solution(int x, int y, int day) {
		if (map[x][y].equals("a") || map[x][y].equals("0")) {
			return;
		}

		for (int i = 0; i < 4; i++) {
			if (map[x][y].equals(Integer.toString(day))) {
				map[x][y] = "0";// 먹은부분 체크
				solution(x + dx[i], y + dy[i], day);
			}
		}
	}
	
	
	//이 솔루션을 한번 타고 들어가면 먹지 않은 부분중 이어져있는 모든 부분을 체크함. 
	//exist_piece로 조각이 있음을 확인.
	static void solution2(int x, int y) {

		if (temp[x][y].equals("0") || temp[x][y].equals("a") || temp[x][y].equals("b")) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			exist_piece = true;
			temp[x][y] = "b"; // 먹은부분중 이미 확인한 부분.
			solution2(x + dx[i], y + dy[i]);
		}
	}
	
	//먹은 부분이 체크된 후의 map을 copy함.
	//
	static void temp_reset() {
		for (int i = 0; i < N + 2; i++) {
			for (int j = 0; j < N + 2; j++) {
				temp[i][j] = map[i][j];
			}
		}
	}

//	static void printMap() {
//		for (int i = 0; i < map.length; i++) {
//			for (int j = 0; j < map.length; j++) {
//				System.out.print(map[i][j]);
//			}
//			System.out.println();
//		}
//
//		System.out.println();
//
//	}
//
//	static void print_temp() {
//		for (int i = 0; i < temp.length; i++) {
//			for (int j = 0; j < temp.length; j++) {
//				System.out.print(temp[i][j]);
//			}
//			System.out.println();
//		}
//	}

}
