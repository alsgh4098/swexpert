
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_5356_의석이의세로로말해요 {

	static int T;
	static int N = 5;
	static char[][] board;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			int max = 0;
			board = new char[5][];
			for (int i = 0; i < N; i++) {
				String input = sc.next();
				board[i] = new char[input.length()];
				for (int j = 0; j < input.length(); j++) {
					board[i][j] = input.charAt(j);
				}
//				board[i] = input.toCharArray();
//				System.arraycopy(tmp,0,board[i],0,tmp.length);
				if (max < input.length()) {
					max = input.length();
				}
			}
			
			String[] str = new String[max];
			Arrays.fill(str, "");
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					str[j] += board[i][j];
				}
			}
			System.out.print("#"+t+" ");
			//StringBuffer sb = new StringBuffer();
			// => sb.toString();
			for (int i = 0; i < str.length; i++) {
				System.out.print(str[i]);
			}
			System.out.println();
		}

	}

}
