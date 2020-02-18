

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_d3_1229_암호문2 {

	static int T = 10;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<String> ps_list = new ArrayList<>();

		for (int i = 1; i <= 10; i++) {
			ps_list.clear();

			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				ps_list.add(st.nextToken());
			}

			int C = Integer.parseInt(br.readLine());

			StringTokenizer ct = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {

				String cmd = ct.nextToken();
				if (cmd.equals("I")) {
					int index = Integer.parseInt(ct.nextToken());
					int count = Integer.parseInt(ct.nextToken());

					for (int k = index; k < index+count; k++) {
						String num = ct.nextToken();
						ps_list.add(k, num);
					}

				} else if (cmd.equals("D")) {
					int index = Integer.parseInt(ct.nextToken());
					int count = Integer.parseInt(ct.nextToken());

					for (int k = 0; k < count; k++) {
						ps_list.remove(index);
					}
				}
			}
			System.out.printf("#%d ", i);
			for (int k = 0; k < 10; k++) {
				System.out.print(ps_list.get(k) + " ");
			}
			System.out.println();
		}
	}
}
