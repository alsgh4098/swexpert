import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_역량_미생물격리2 {

	static class Virus {
		int x;
		int y;
		int size;
		int dir;

		public Virus(int x, int y, int size, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.size = size;
			this.dir = dir;
		}
	}

	static int N;
	static int M;

	static ArrayList<Virus> list;

	// 빈칸 상 하 좌 우
	static int[] dx = { 0, -1, 1, 0, 0 };
	static int[] dy = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());

			list = new ArrayList<Virus>();

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int size = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());

				list.add(new Virus(x, y, size, dir));
			}

			timeGoes();

			int len = list.size();

			int sum = 0;

			for (int i = 0; i < len; i++) {
				sum += list.get(i).size;
			}

			System.out.println("#" + t + " " + sum);

		}

	}// end main

	static void timeGoes() {

		// 시간의 흐름
		for (int i = 0; i < M; i++) {

			// 시간의 흐름에 따른 바이러스들의 위치,사이즈 변화
			int len = list.size();
			for (int j = 0; j < len; j++) {
				Virus ths = list.get(j);
				ths.x = ths.x + dx[ths.dir];
				ths.y = ths.y + dy[ths.dir];

				if (ths.x == 0 || ths.y == 0 || ths.x == N - 1 || ths.y == N - 1) {// 약품
					if (ths.size / 2 == 0) {
						list.remove(j);
						len--;
						// 사이즈가 0보다 크면 방향을 바꿔서 계속 생존.
					} else {
						ths.size = ths.size / 2;
						ths.dir = changeDir(ths.dir);
					}
				} // end if
			} // end virus list

			len = list.size();

			// 바이러스 위치로 정렬.
			sort();

			// 바이러스 겹치는 여부 확인
			// 겹칠경우 큰 바이러스로 합쳐짐.
			for (int j = 0; j < len - 1; j++) {
				for (int j2 = j; j2 < len - 1; j2++) {
					Virus v1 = list.get(j2);
					Virus v2 = list.get(j2 + 1);

					if (v1.size < v2.size) {
						list.remove(j2);
						v2.size += v1.size;
						len--;
					} else {
						list.remove(j2+1);
						v1.size += v2.size;
						list.add(j2, v1);
						len--;
					}
				}
			}

		} // end time for
	}

	static void sort() {
		int len = list.size();
		for (int j = 0; j < len - 1; j++) {
			for (int j2 = j; j2 < len - 1; j2++) {
				Virus v1 = list.get(j2);
				Virus v2 = list.get(j2 + 1);

				if (v1.x * N + v1.y > v2.x * N + v2.y) {
					list.remove(j2);
					list.remove(j2);
					list.add(j2, v1);
					list.add(j2, v2);
				}
			}
		}
	}

	static boolean inner(int x, int y) {
		if (0 < x && x < N - 1 && 0 < y && y < N - 1) {
			return true;
		} else {
			return false;
		}
	}

	static int changeDir(int d) {
		switch (d) {
		case 1:
			return 3;
		case 2:
			return 4;
		case 3:
			return 1;
		case 4:
			return 2;
		default:
			return 0;
		}
	}
}
