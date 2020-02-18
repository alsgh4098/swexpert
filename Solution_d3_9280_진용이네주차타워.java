

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Solution_d3_9280_진용이네주차타워 {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		
		int tc = sc.nextInt();
		
		for(int i=1; i<=tc; i++) {
			//주차공간 n개
			int n = sc.nextInt();
			//차량 m개
			int m = sc.nextInt();
			
			// 주차장 어레이리스트
			int[] park_lot = new int[n];
			ArrayList<Integer> wait = new ArrayList<>();
			
			//주차공간마다 정해진 요금 n가지
			int[] fee = new int[n];
			//차량마다 다른 무게  m가지
			int[] weight = new int[m];
			
			for(int j=0; j<n; j++) {
				fee[j] = sc.nextInt();
			}
			
			for(int j=0; j<m; j++) {
				weight[j] = sc.nextInt();
			}
			
			int sum = 0;
			
			for(int j=0; j<m*2; j++) {
				int index = 0;
				int car_number = sc.nextInt();
				if(car_number > 0) {
					if(arr_space(park_lot)) {
						arr_add(park_lot, car_number);
						index = arr_find(park_lot,car_number);
//						System.out.println("i"+index);
						sum += fee[index]*weight[car_number-1];
					}else {
						wait.add(car_number);
					}
				}else{
					car_number = Math.abs(car_number);
					index = arr_find(park_lot,car_number);
					arr_del(park_lot, index);
					
					if(!wait.isEmpty()) {
						int wait_car = wait.get(0);
//						System.out.println("w"+wait_car);
						wait.remove(0);
						arr_add(park_lot, wait_car);
						index = arr_find(park_lot,wait_car);
//						System.out.println(index);
						sum += fee[index]*weight[wait_car-1];
					}
				}
			}
			
			System.out.printf("#%d %d\n",i,sum);
			
		}

	}
	
	public static void arr_add(int[] arr,int number) {
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				arr[i] = number;
				break;
			}
		}
	}
	
	public static void arr_del(int[] arr,int index) {
		if(index < arr.length) {
			arr[index] = 0;
		}
	}
	
	public static int arr_find(int[] arr,int number) {
		int index = 0;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == number) {
				index = i;
			}
		}
		return index;
	}
	
	public static boolean arr_space(int[] arr) {
		int count = 0;
		boolean res = false;
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 0) {
				count++;
				res = true;
			}
		}
		
		return res;
	}

}