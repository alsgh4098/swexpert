
import java.util.Arrays;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class Solution_d2_1966_숫자를정렬하자 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			// 배열의 길이 입력
			int len = sc.nextInt();
			
			int[] arr = new int[len];
			
			for(int j=0; j<len; j++) {
				arr[j] = sc.nextInt();
			}
			
			bubble_sort_arr(arr);
			
			StringBuilder sb = new StringBuilder();
			
			
			for(int j=0; j<len; j++) {
				sb.append(arr[j]+" ");
			}
			sb.deleteCharAt(sb.length()-1);
			
			System.out.printf("#%d %s\n",i,sb.toString());
			
		}

	}
	
	public static int[] bubble_sort_arr(int[] arr) {
		for(int i=0; i<arr.length; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) {
					int temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}
		return arr;
	}

}
