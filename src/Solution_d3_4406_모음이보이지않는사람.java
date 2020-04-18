
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_d3_4406_모음이보이지않는사람 {
	
	static String vowel = "aoeiuyw";

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= TC; t++) {
			
			String str = br.readLine();
			
			str = str.replace("a", "");
			str = str.replace("e", "");
			str = str.replace("i", "");
			str = str.replace("o", "");
			str = str.replace("u", "");
			
			System.out.printf("#%d %s\n",t,str);
			
		}

	}

}
