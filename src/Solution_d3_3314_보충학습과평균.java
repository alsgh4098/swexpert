
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_d3_3314_보충학습과평균 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for (int t = 1; t <= TC; t++) {
			
			int[] student = new int[5];
			
			int sum = 0;
			
			for (int i = 0; i < student.length; i++) {
				student[i] = sc.nextInt();
				
				student[i] = (student[i]<40)?40:student[i];
				
				sum += student[i];
			}
			
			System.out.printf("#%d %d\n",t,sum/5);
			
		}

	}

}
