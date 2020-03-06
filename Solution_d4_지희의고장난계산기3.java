package swexpert2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_d4_지희의고장난계산기3 {

	static int[] button;

	static int[] numbers;

	static int target;
	
	static int res;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int TC = Integer.parseInt(br.readLine());

		for (int t = 1; t <= TC; t++) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			button = new int[10];
			res = -1;

			for (int i = 0; i < 10; i++) {
				button[i] = Integer.parseInt(st.nextToken());
			}

			target = Integer.parseInt(br.readLine());
			numbers = new int[target+1];
			Arrays.fill(numbers, Integer.MAX_VALUE);
			makeNum(0,0);
			numbers[0] = 0;
			if(target != 1) {				
				numbers[1] = 0;
			}
			bfs();
			
//			System.out.println(numbers[1000000]);

			System.out.println("#" + t + " " + ((res==Integer.MAX_VALUE)?-1:res));
		}

	}// end main

	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();

		q.offer(new int[] { target, 0 });

		while (!q.isEmpty()) {

			int[] temp = q.poll();

			// 앞에서 넘겨받은 숫자
			int num = temp[0];
			// 버튼을 누른 카운트
			int count = temp[1];
			
//			System.out.println(num);

			if (num == 1) {
				res = count;
//				System.out.println(res);
				if(numbers[target] != Integer.MAX_VALUE) {
					if( res!= 0) {
//						System.out.println(res);
						res = Math.min(numbers[target]+1, res);						
					}else {						
						res = numbers[target]+1;
					}
				}
				break;
			}
			
			for (int i = 2; i <= target; i++) {
					if(numbers[i] != Integer.MAX_VALUE && num%i == 0) {
						q.offer(new int[] {num/i,numbers[i]+count+1});
					}
				
			}
		}
	}
	
	static void makeNum(int num, int count) {
		
		if(numbers[num] > count ) {
//			System.out.println("cnt"+(count));
//			System.out.println();
			numbers[num] = count;
		}else {
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(button[i] != 0) {
					if( num*10+i <= target) {
//						System.out.println(num*10+i);
						makeNum(num*10 + i, count+1);
					}
			}
		}
	}


}
