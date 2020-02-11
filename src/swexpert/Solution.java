package swexpert;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution{

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int t=1; t<=tc; t++) {
			
			int N = sc.nextInt();
			
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			ArrayList<Integer> list = new ArrayList<>();
			
			Stack<Integer> stack =new Stack<>();
			
			int chai = 0;
			int min = Integer.MAX_VALUE;
			int min_index = 0;
			int count = 0;
			int count_max = Integer.MIN_VALUE;
			int i = 0; 
			for(int z=0; z<N; z++) { // 1 3 2 5 4
				chai = 0;
				count = 0;
				min_index = 0;
				min = Integer.MAX_VALUE;
				for(int x=min_index; x<N; x++) {
					for(int y=x+1; y<N; y++) {
						if(arr[x] < arr[y]) {
							chai = arr[y]-arr[x];
						}
						if(chai < min) {
							min = chai;
							System.out.println(min);
							min_index = y;
						}
					}
//					System.out.println(min_index);
//					System.out.println(arr[x]);
					count++;
				}
				System.out.println();
				if(count_max < count) {
					count_max = count;
				}
			}
			
			System.out.printf("#%d %d\n",t,count_max);
			
		}

	}

}
