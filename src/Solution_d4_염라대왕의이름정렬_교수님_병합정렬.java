import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 정렬 - 우선순위
// 중복을 제거


public class Solution_d4_염라대왕의이름정렬_교수님_병합정렬 {
	
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt(); // 1~50
		
		for (int t = 1; t <= TC; t++) {
			int N = sc.nextInt(); // 이름의 개수 1~20,000
			
			String[] name = new String[N];
			
			for (int i = 0; i < N; i++) {
				name[i] = sc.next();
			}
			
			Arrays.sort(name,new Comparator<String>() {
				@Override
				public int compare(String pre, String next) {
					if(pre.length() != next.length()) { // 글자의 길이 짧은순서
						return pre.length() - next.length();
					}else { // 길이가 같으면, 사전순
						return pre.compareTo(next); // 오름차순
					}
				}
				
			});
			
			// 중복제거
			System.out.println("#"+t);
			String temp = null;
			for (int i = 0; i < name.length; i++) {
				if(!name[i].equals(temp)) {
					System.out.println(name[i]);
				}
				temp = name[i];
			}
		} // end of testCase
		
		
	}
	
	
	// 바꿔야 된다면, next가 앞으로가야한다면 양수를 리턴
	
	private static int compare(String pre, String next) {
		if(pre.length() != next.length()) { // 글자의 길이 짧은순서
			return pre.length() - next.length();
		}else { // 길이가 같으면, 사전순
			return pre.compareTo(next); // 오름차순
		}
	}

}// end of class
