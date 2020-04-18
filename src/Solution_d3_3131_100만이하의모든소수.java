import java.util.ArrayList;
import java.util.Arrays;

//아리토스테네스의체
//인덱스를 값으로
//boolean으로 그 값이 소수인지 아닌지 여부.

public class Solution_d3_3131_100만이하의모든소수 {

	static boolean[] arr = new boolean[1000001];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Arrays.fill(arr, true);
		
		arr[1] = false;
		
		for (int i = 2; i < 1000000; i++) {
			
			if( arr[i] == true) {
				for (int j = 2; j*i < 1000000; j++) {
						arr[i*j] = false;						
				}				
			}
			
		}
		
		for (int i = 2; i < 1000000; i++) {
			if(arr[i] == true) {
				System.out.printf("%d ",i);
			}
		}
	}

}
