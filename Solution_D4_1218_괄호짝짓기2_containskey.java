package ssafyalgo0130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Stack;


public class Solution_D4_1218_괄호짝짓기2_containskey {
	static HashMap<Character, Character> map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char []ch1 = {'(','<','{','['};
		char []ch2 = {')','>','}',']'};
		map = new HashMap<>();
		map.put(ch1[0], ch2[0]);
		map.put(ch1[1], ch2[1]);
		map.put(ch1[2], ch2[2]);
		map.put(ch1[3], ch2[3]);
		for (int t = 1; t <= 10; t++) {
			int L = Integer.parseInt(in.readLine());
			String data = in.readLine();
			Stack<Character> team = new Stack<>();
			boolean isTrue = true;
			int check=1;
			for(int i=0; i<L; i++) {
				char input = data.toCharArray()[i];
				team.push(input);
				for(char c: ch2) {
					if(c==input) {
						team.pop();
						char a = team.pop();
						if(map.get(a) != c) {
							isTrue = false;
							break;
						}
					}
				}
				if(!isTrue) {
					break;
				}
			}
			if(!isTrue || !team.isEmpty()) {
				check= 0;
			}
			System.out.println("#" + t + " " + check);
		}
	}
}
