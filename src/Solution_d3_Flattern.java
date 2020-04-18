
import java.util.Scanner;

public class Solution_d3_Flattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc=1; tc<=10; tc++) {
			int dump_count = sc.nextInt();
			
			int[] d_box_len = new int[100];
			
			
			// box_count를 받아서
			// 그 길이만큼 d_box_len arr에 넣어준다.
			for(int i=0; i<100; i++) {
				int box_count = sc.nextInt();
				
				d_box_len[i] = box_count;
			}
			
			while( dump_count != 0) {
				
				int max_index = max_val(d_box_len);
				int min_index = min_val(d_box_len);
				
				d_box_len[max_index] -= 1;
				d_box_len[min_index] += 1;
				
				dump_count--;
			}
			
			int max_index = max_val(d_box_len);
			int min_index = min_val(d_box_len);
			int high_min_low = d_box_len[max_index] - d_box_len[min_index];
			
			
			System.out.printf("#%d %d\n",tc,high_min_low);
			
		}

		
	}
	
	
	// 배열에서 가장큰 값을 갖는 인덱스를 리턴하는 함수
	public static int max_val(int[] arr) {
		int index = 0;
		int max = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				index = i;
			}
		}
		return index;
	}
	
	// 배열에서 가장 작은값을 갖는 인덱스를 리턴하는 함수
	public static int min_val(int[] arr) {
		int index = 0;
		int min = 101;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] < min) {
				min = arr[i];
				index = i;
			}
		}
		return index;
	}
}
