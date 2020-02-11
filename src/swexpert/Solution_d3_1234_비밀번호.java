package swexpert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Solution_d3_1234_비밀번호 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		for (int t = 1; t <= 10; t++) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());

			String number = st.nextToken();
			System.out.println(number);

			char[] chr_arr = number.toCharArray();

			Stack<Character> stck = new Stack<>();
			Stack<Character> stck2 = new Stack<>();

			for (int i = 0; i < chr_arr.length; i++) {
				stck.push(chr_arr[i]);
			}

			for (int i = 0; i < N; i++) {
				if (stck.size() >= 1) {
					char chr = ' ';
					if (i == 0) {
						chr = stck.pop();
						stck2.add(chr);
					} else {
						chr = stck.pop();
						if (stck.size() >= 1 && chr == stck.peek()) {
							stck.pop();
						} else {
							if (stck2.size() >= 1 && chr == stck2.peek()) {
								stck2.pop();
							} else {
								stck2.add(chr);
							}
						}
					}
				}

			}

			int len = stck2.size();

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < len; i++) {
				sb.append(stck2.pop());
			}

			System.out.printf("#%d %s\n", t, sb.toString());

		}

	}

}
