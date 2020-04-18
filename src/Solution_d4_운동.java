import java.util.Scanner;

public class Solution_d4_운동 {

	static int[][] graph;
	static int ans;
	static boolean[] visit;
	static int N, M;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int tc = 1; tc <= TC; tc++) {
			ans = Integer.MAX_VALUE;
			N = sc.nextInt();
			M = sc.nextInt();

			graph = new int[N + 1][N + 1];

			for (int i = 0; i < M; i++) {
				int s = sc.nextInt(); // start
				int e = sc.nextInt(); // end
				int c = sc.nextInt(); // cost

				// c가 0이면 도로가 없는것.
				graph[s][e] = c;
			}

			for (int now = 1; now <= N; now++) {
				visit = new boolean[N + 1]; // 방문정보 초기화
				dfs(now, now, 0);
			}

			System.out.println("#" + tc + " " + (ans == Integer.MAX_VALUE ? -1 : ans));
		}
	}

	static void dfs(int now, int start, int dist) { // 현재 서있는 정점, 출발을 어디서 했는지.
		if (now == start && visit[now]) { // 출발점으로 돌아왔네? 사이클.
			if (dist < ans) {
				ans = dist;
			}
			return;
		}

		if (visit[now]) {
			return;
		}

		if (dist >= ans) {
			return;
		}

		visit[now] = true;

		for (int i = 1; i <= N; i++) {
			if (graph[now][i] > 0) { // 현재 정점에서 이동가능한 다음 정점 찾는 작업.
				dfs(i, start, dist + graph[now][i]);
			}
		}

	}

}
