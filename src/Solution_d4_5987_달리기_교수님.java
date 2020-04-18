import java.util.ArrayList;
import java.util.Scanner;

public class Solution_d4_5987_달리기_교수님 {

	static int[] needs;
	static long[] memo;

	static int T, N;
	static int M;
	static int count;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();

		for (int t = 1; t <= TC; t++) {
			int f, s;
			N = sc.nextInt();
			M = sc.nextInt();
			needs = new int[N];
			memo = new long[(1 << N)];
			for (int i = 0; i < M; i++) {
				f = sc.nextInt() - 1;
				s = sc.nextInt() - 1;
				needs[f] |= (1 << s);
			}
			long r = dfs(0);
			System.out.println("#" + t + " " + r);
		}
	}// end main

	private static long dfs(int flag) {
		if (flag == (1 << N) - 1) {
			return 1;
		}
		
		// 메모이
		if (memo[flag] > 0) {
			return memo[flag];
		}
		
		// 순열
		
		// 순서는 눈에 보이지 않는다.
		// N = 3을 예로들면
		// 0111
		// 0111이렇게 두값이 나오므로
		// 답이 2인데
		// 001의 상황에서
		// 101 다음 111인 경우와
		// 011 다음 111인 경우가 나오기 때문에 답이 2인것이다.
		
		// N = 3인경우에
		// 세자리를 표시하기위해 memo의 크기를 1<<N으로 잡아서
		// 1000으로 0이 총 세칸 나오게 했고,
		// 여기서 오른쪽 끝에 0이 0번 인덱스 
		// 그 왼쪽이 1번인덱스
		// 마지막것이 2번인덱스로
		// 총 3명의 선수를 비교할수 있는 것이다.
		
		// 비트마스킹 순열과
		// 메모이제이션
		// 순열로 위치를 나타낼수 있음을 알아야한다.
		for (int i = 0; i < N; i++) {
			if ((flag & 1 << i) == 0) {
				// needs에는 각각의 조건들이 담겨있다.
				// flag는 우리가 DFS완탐으로 세우고자 하는 줄을 생성.
				// 위에서 조건을 생성해서 줄을 세워서 needs에 넣었을때
				// 조건이 생성되지 않아 아무 값도 갖고있지 않은 needs의 칸에는 0이 들어가 있고
				// (flag & 0) == 0이므로
				// 더 깊이 들어갈 수 있다.
				if ((flag & needs[i]) == needs[i]) {
					memo[flag] += dfs(flag | 1 << i);
				}
			}
		}

		return flag;
	}

}
