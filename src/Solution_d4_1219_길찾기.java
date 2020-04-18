import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d4_1219_길찾기 {
	
	static int N;
	static int[] arr;
	static int[] arr2;
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int t = 1; t <=10; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr = new int[100];
			arr2 = new int[100];
			int drop = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			Arrays.fill(arr, -1);
			Arrays.fill(arr2, -1);
			String numbers = br.readLine();
			st = new StringTokenizer(numbers);
			for (int i = 0; i < N; i++) {
				int index = Integer.parseInt(st.nextToken());
				int value = Integer.parseInt(st.nextToken());
				
				if(arr[index] == -1) {
					arr[index] = value;
				}else {
					arr2[index] = value;
				}
				
			}
			res = 0;
			solution(0);
			System.out.printf("#%d %d\n",t,res);
			
//			for (int i = 0; i < arr.length; i++) {
//				System.out.println(arr[i]);
//			}
			
		}

	}
	
	public static void solution(int x) {
		if(arr[x] == 99
		||arr2[x] == 99) {
			res = 1;
			return;
		}
		
		if(arr[x] != -1) {
			int value = arr[x];
			solution(value);
		}
		
		if(arr2[x] != -1) {
			int value = arr2[x];
			solution(value);
		}
	}

}
