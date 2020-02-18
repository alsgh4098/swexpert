

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_d3_1873_상호의배틀필드 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());


		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			char[][] map = new char[H][W];

			for (int i = 0; i < H; i++) {
				map[i] = br.readLine().toCharArray();
			}

			int x = 0;
			int y = 0;

			// map 출력.
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
//					System.out.print(map[i][j]);
					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						x = i;
						y = j;
					}
				}
//				System.out.println();
			}

			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 명령어 갯수.

			char[] comm = br.readLine().toCharArray();

			for (int i = 0; i < N; i++) {
				if (comm[i] == 'U') {
					if (0 <= x - 1 && map[x - 1][y] == '.') {
						map[x][y] = '.';
						x--;
						map[x][y] = '^';
					} else {
						map[x][y] = '^';
					}
				} else if (comm[i] == 'D') {
					if (x + 1 < H && map[x+1][y] == '.') {
						map[x][y] = '.';
						x++;
						map[x][y] = 'v';
					} else {
						map[x][y] = 'v';
					}
				} else if (comm[i] == 'L') {
					if (0 <= y - 1 && map[x][y - 1] == '.') {
						map[x][y] = '.';
						y--;
						map[x][y] = '<';
					} else {
						map[x][y] = '<';
					}
				} else if (comm[i] == 'R') {
					if (y + 1 < W && map[x][y + 1] == '.') {
						map[x][y] = '.';
						y++;
						map[x][y] = '>';
					} else {
						map[x][y] = '>';
					}
				} else if (comm[i] == 'S') {
					int sx = x;
					int sy = y;

					if (map[sx][sy] == '^') {
						while (0 <= sx-1 && map[sx][sy] != '#') {
							sx--;
							if (map[sx][sy] == '*') {
								map[sx][sy] = '.';
								break;
							}
						}
					} else if (map[sx][sy] == 'v') {
						while (sx+1 < H && map[sx][sy] != '#') {
							sx++;
							if (map[sx][sy] == '*') {
								map[sx][sy] = '.';
								break;
							}
						}
					} else if (map[sx][sy] == '<') {
						while (0 <= sy-1 && map[sx][sy] != '#') {
							sy--;
							if (map[sx][sy] == '*') {
								map[sx][sy] = '.';
								break;
							}
						}
					} else if (map[sx][sy] == '>') {
						while (sy+1 < W && map[sx][sy] != '#') {
							sy++;
							if (map[sx][sy] == '*') {
								map[sx][sy] = '.';
								break;
							}
						}
					}
				}
			}
			
			System.out.printf("#%d ",t);
			// map 출력.
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}

	}

}
