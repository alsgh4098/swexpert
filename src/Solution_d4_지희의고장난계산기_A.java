import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_지희의고장난계산기_A {

	static boolean[] btn;

	static int X;
	
	static int min;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			btn = new boolean[10];
			min = Integer.MAX_VALUE;
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int num;
			for (int i = 0; i < 10; i++) {
				num = Integer.parseInt(st.nextToken());
				if(num == 1) {
					btn[i] = true;
				}
			}

			X = Integer.parseInt(br.readLine());
			find(X,0);
			
			min = min == Integer.MAX_VALUE ? -1:min;

			System.out.println("#" + t + " " + min);
		}

	}// end main

	private static int find(int x, int cnt) {
		// TODO Auto-generated method stub
		if(isMake(x+"")) {
			
			if(cnt == 0) {
				// cnt는 주어진 수를 바로 계산할수 있는지 확인하기 위해 사용
				// cnt가 0이라면 처음 주어진 값을 바로 버튼을 각각 눌러 계산하는 경우다.
				// 이 경우엔 그 숫자만큼 누르고 =버튼만 누르면 된다.
				min = len(x) + 1;
			}
			// x/i가 숫자버튼만을 눌러서 만들수 있다면, len2에 담긴다.
			return len(x)+1;
		}
		int result = -1;
		
		// 약수생성
		// i가 약수.
		for (int i = 2, end = (int)Math.sqrt(x)+1; i < end; i++) {
			if( x%i==0 && isMake(i+"")) {
				// 구하고자 하는 값 x의 약수들을 위의 for문을 통해서 뽑는다.
				// 1과 자기자신을 제외한 약수의 범위는 2~sqrt(자신)과 같고
				// 이 for문을 통해서 약수 i와 x/i을 구할 수 있다.
				// len1은 약수 i와 곱하기 버튼을 누른 횟수
				// len2는 x/i를 다시 재귀를 통해 구한 함수.
				int len1 = len(i)+1;
				
				int len2 = find(x/i,cnt+1);
				
				// len2 즉, 약수 x/i의 값이 -1라면 약수들의 곱이나, 숫자키를 눌러서 x/i의 값을 만들지 못하는것이다.
				// 따라서 -1이상일때만 min값을 result로 만들어준다.
				if(len2>-1) {
					result = len1+len2;
					// 구하고자하는 값 X에 도달했을경우 최솟갑을 계산해준다.
					// 
					if(result < min && x == X) {
						min = result;
					}
				}
			}
		}
		
		// 이 리턴값은 len2에 담기게된다.
		// x/i가 계산이 되는값이라면 계산된 그 값이 담길 것 이고
		// 아니라면 -1이 담길것이다.
		return result;
		
	}
	
	// 자릿수확인	
	private static int len(int x) {
		return (int)(Math.log10(x)+1);
	}

	// 눌려지는 버튼인지 확인
	private static boolean isMake(String x) {
		for(char c : x.toCharArray()) {
			if( !btn[c-'0']) {
				return false;
			}
		}
		return true;
	}


}
