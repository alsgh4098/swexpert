import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1169_주사위던지기1 {

	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = in.readLine();
		StringTokenizer st = new StringTokenizer(data);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];

		if (M == 1) {
			every(0, 0);
		} else if (M == 2) {
			combi(0, 0);
		} else {
			perm(0, 0);
		}
	}

	public static void every(int start, int count) {
		if (count == N) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < 6; i++) {
			nums[count] = i + 1;
			every(0, count + 1);
		}
	}

	public static void combi(int start, int count) {
		if (count == N) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		}
		for (int i = start; i < 6; i++) {
			nums[count] = i + 1;
			combi(i, count + 1);
		}
	}

	public static void perm(int flag, int count) {
		if (count == N) {
			for (int i = 0; i < nums.length; i++) {
				System.out.print(nums[i] + " ");
			}
			System.out.println();
			return;
		} else {
			for (int i = 0; i < 6; i++) {
				if ((flag & (1 << i)) != 0) {
					continue;
				} else {
					nums[count] = i + 1;
					perm(flag | (1 << i), count + 1);
				}
			}
		}
	}
}
