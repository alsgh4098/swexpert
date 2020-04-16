package ssafyalgo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_소금쟁이 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(in.readLine());
		int[] jump = { 3, 5, 6 };
		for (int t = 1; t <= T; t++) {
			String data = in.readLine();
			StringTokenizer st = new StringTokenizer(data);
			int N = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());
			boolean[][] map = new boolean[N][N];
			int[] x = new int[num];
			int[] y = new int[num];
			int[] dir = new int[num];
			for (int i = 0; i < num; i++) {
				st = new StringTokenizer(in.readLine());
				y[i] = Integer.parseInt(st.nextToken());
				x[i] = Integer.parseInt(st.nextToken());
				map[y[i]][x[i]] = true;
				dir[i] = Integer.parseInt(st.nextToken());
			}
			int i = 0;
			boolean isPassed = false;
			while (i < num) {
				if (dir[i] == 1) {
					for (int j = 0; j < 3; j++) {
						if (y[i] + jump[j] < N - 1) {
							if (map[y[i] + jump[j]][x[i]] == true) {
								isPassed = true;
								break;
							}
							map[y[i] + jump[j]][x[i]] = true;
						}
					}
				} else {
					for (int j = 0; j < 3; j++) {
						if (x[i] + jump[j] < N - 1) {
							if (map[y[i]][x[i] + jump[j]] == true) {
								isPassed = true;
								break;
							}
							map[y[i]][x[i] + jump[j]] = true;
						}
					}
				}
				if(isPassed) {
					break;
				}
				i++;
			}
			if(!isPassed) {
				i = -1;
			}
			System.out.println("#" + t + " " +( i+1));
		}
	}

}
