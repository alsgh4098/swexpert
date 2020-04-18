import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Soultion_d2_1959_두개의숫자열 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int tc = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			int N1 = Integer.parseInt(st.nextToken());
			int N2 = Integer.parseInt(st.nextToken());
			
			
			int[] arr1 = new int[N1];
			int[] arr2 = new int[N2];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr1.length; i++) {
				arr1[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < arr2.length; i++) {
				arr2[i] = Integer.parseInt(st.nextToken());
			}
			
			int sum ;
			int max = 0;
			
			if(arr1.length < arr2.length) {
				for (int i = 0; i < arr2.length-arr1.length+1; i++) {
					sum = 0;
					int[] arr3 = Arrays.copyOfRange(arr2, i, i+arr1.length+1);
					for (int j = 0; j < arr1.length; j++) {
						sum += arr1[j] * arr3[j];
					}
					if(max < sum) {
						max = sum;
					}
				}
			}else {
				for (int i = 0; i < arr1.length-arr2.length+1; i++) {
					sum = 0;
					int[] arr3 = Arrays.copyOfRange(arr1, i, i+arr2.length+1);
					for (int j = 0; j < arr2.length; j++) {
						sum += arr2[j] * arr3[j];
					}
					if(max < sum) {
						max = sum;
					}
				}
			}
			
			System.out.printf("#%d %d\n",t,max);
		
		}
	}
}	
