
import java.util.Scanner;

public class Solution_d3_7272_안경이없어 {

	static char[] char_0 = new char[] { 'C', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'S', 'T', 'U', 'V', 'W',
			'S', 'X', 'Y', 'Z' };
	static char[] char_1 = new char[] { 'A', 'D', 'O', 'P', 'Q', 'R' };
	static char[] char_2 = new char[] { 'B' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int tc = sc.nextInt();
		
		sc.nextLine();
		
		for (int t = 1; t <= tc; t++) {
			String str = sc.next();
			String str2 = sc.next();
			
			String res = alpha_check(str,str2);
			
			System.out.printf("#%d %s\n",t,res);
		}

	}

	public static String alpha_check(String str, String str2) {
		String res = "SAME";
		
		char[] chr_arr = str.toCharArray();
		char[] chr_arr2 = str2.toCharArray();

		if (str.length() != str2.length()) {
			res = "DIFF";
			return res;
		}

		for (int i = 0; i < chr_arr.length; i++) {
			if (	!(( (arr_contain(char_0, chr_arr[i])) && (arr_contain(char_0, chr_arr2[i])))
					|| ( (arr_contain(char_1, chr_arr[i])) && (arr_contain(char_1, chr_arr2[i]))) 
					|| ( (arr_contain(char_2, chr_arr[i])) && (arr_contain(char_2, chr_arr2[i]))) ) ){
				 res = "DIFF";
				 return res;
			}
		}

		return res;
	}

	public static boolean arr_contain(char[] chr_arr, char chr) {
		for (char ch_chck : chr_arr) {
//			System.out.println(ch_chck +&quot; &quot;+ chr);
			if (ch_chck == chr) {
				return true;
			}
		}

		return false;
	}

}