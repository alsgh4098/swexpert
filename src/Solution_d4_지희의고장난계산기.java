import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_지희의고장난계산기 {

	static int[] button;

	static int res;

	static int[] numbers;

	static int target;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			button = new int[10];
			numbers = new int[1000001];
			res = -1;

			for (int i = 0; i < 10; i++) {
				button[i] = Integer.parseInt(st.nextToken());
			}

			target = Integer.parseInt(br.readLine());

			dfs(0, 0, 0);

			System.out.println("#" + t + " " + res);
		}

	}// end main

	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { 0, 0, 0 });

		while (!q.isEmpty()) {

			int[] temp = q.poll();

			// 앞에서 넘겨받은 숫자
			int num = temp[0];
			// 버튼을 누른 카운트
			int count = temp[1];
			// 이전에 누른 버튼
			// 0 숫자 1곱하기 2계산
			int cate = temp[2];

			if (num > target) {
				continue;
			}

			int sum = 1;
			for (int i = 0; i < count; i++) {
				if (numbers[i] != 0) {
					sum *= numbers[i];
					System.out.println(sum);
				}
			}
			if (sum > target) {
				continue;
			}
			// =
			// 숫자뒤에만 올 수 있다.
			if (cate == 0) {
				if (sum == target) {
					res = count;
					break;
				}

			}

			// 숫자
			// 숫자뒤에 숫자
			if (cate == 0) {
				for (int i = 0; i < 10; i++) {
					// 버튼을 누를 수 있을 때.
					if (button[i] == 1) {
						q.offer(new int[] { num * 10 + i, count + 1, 0 });
					}
				}
			}
			// 곱하기뒤에 숫자
			if (cate == 1) {
				for (int i = 0; i < 10; i++) {
					// 버튼을 누를 수 있을 때.
					if (button[i] == 1) {
						q.offer(new int[] { i, count + 1, 0 });
					}
				}
			}

			// 곱하기
			// 숫자뒤에만 올 수 있다.
			if (cate == 0) {
				// 갖고있던 num을 현재 곱하기 위치의 인덱스에 집어 넣는다.
				numbers[count] = num;
				q.offer(new int[] { 0, count + 1, 1 });
			}

		}
	}

	static void dfs(int num, int count, int cate) {

		int sum = 1;
		for (int i = 0; i < count; i++) {
			if (numbers[i] != 0) {
				sum *= numbers[i];
						System.out.print(numbers[i]+" ");
			}
		}
		System.out.println();
		if (sum > target) {
			return;
		}
		// =
		// 숫자뒤에만 올 수 있다.
		if (cate == 0) {
//			System.out.println(sum);
			if (sum == target) {
				res = count;
				return;
			}

		}

		if (num > target) {
			return;
		}
		
		//이부분 count와 target에 들어가는 부분.
		// 숫자
		// 숫자뒤에 숫자
		if (cate == 0) {
			for (int i = 0; i < 10; i++) {
				// 버튼을 누를 수 있을 때.
				if (button[i] == 1) {
					if (num * 10 + i <= target && num * 10 + i != 0) {
						dfs(num * 10 + i, count+1, 3);
					}
				}
			}
		}
		// 곱하기뒤에 숫자
		if (cate == 1) {
			for (int i = 1; i < 10; i++) {
				// 버튼을 누를 수 있을 때.
				if (button[i] == 1) {
					if(num * i <= target) {						
						dfs(i, count + 1, 0);
					}
				}
			}
		}

		// 곱하기
		// 숫자뒤에만 올 수 있다.
		if (cate == 0) {
			// 갖고있던 num을 현재 곱하기 위치의 인덱스에 집어 넣는다.
			numbers[count] = num;
			dfs(num, count + 1, 1);
		}
		
		// 숫자뒤 숫자면
		if (cate == 3) {
			// 갖고있던 num을 현재 곱하기 위치의 인덱스에 집어 넣는다.
			numbers[count-1] = num;
			dfs(num, count + 1, 1);
		}

	}

}
