import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Solution_7988_내전경기2 {

	static int[][] graph;
	static int[] colors;
	static int K;
	static HashMap<String, Integer> map;
	static String res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			K = Integer.parseInt(br.readLine());

			map = new HashMap<String, Integer>();

			StringTokenizer st;

			res = "Yes";

			graph = new int[2 * K][2 * K];
			colors = new int[2 * K];

			int idx = 0;

			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());

				String str1 = st.nextToken();
				String str2 = st.nextToken();

				if (map.containsKey(str1) && map.containsKey(str2)) {

				} else if (map.containsKey(str1)) {
					map.put(str2, idx++);
				} else if (map.containsKey(str2)) {
					map.put(str1, idx++);
				} else {
					map.put(str1, idx++);
					map.put(str2, idx++);
				}

				graph[map.get(str1)][map.get(str2)] = 1;
				graph[map.get(str2)][map.get(str1)] = 1;

			}

			for (Integer i : map.values()) {
				if (colors[i] == 0) {
					if (dfs(i, 1)) {
						break;
					}
				}
			}

			System.out.println("#" + t + " " + res);
		}

	}

	private static boolean dfs(int start, int color) {
		colors[start] = color;

		for (int j = 0; j < 2 * K; j++) {
			if (graph[start][j] == 1) {
				if (colors[j] == color) {
					res = "No";
					return true;
				}

				if (colors[j] == 0) {
					if (dfs(j, -color)) {
						return true;
					}
				}
			}
		}

		return false;

	}

}
