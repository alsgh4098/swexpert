import java.util.Arrays;
import java.util.Scanner;import com.sun.org.apache.xml.internal.serializer.ToHTMLSAXHandler;

public class R04_BooleanArrayPermuTest {
	
	static int N,R;
	static int[] input,number;
	static boolean[] isSelected;
	static int totalCnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		
		input = new int[N];
		isSelected = new boolean[N];
		number = new int[R];
		
		
		// N개의 숫자중에 R개를 뽑아 만들 수 있는 경우의 수
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		
		permu(0);
		System.out.println("총 경우의 수"+totalCnt);
	}
	
	static void permu(int cnt) {
		if(cnt == R) {
			totalCnt++;
			System.out.println(Arrays.toString(number));
			return;
		}
		for (int i = 0; i < N; i++) {
			if(isSelected[i]) continue;
			number[cnt] = input[i];
			isSelected[i] = true;
			permu(cnt+1);
			isSelected[i] = false;
		}
	}
	
	static void permu2(int cnt) {
		if(cnt == R) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if(number[cnt] != 0) continue;
			number[cnt] = input[i];
			permu(cnt+1);
			number[cnt] = 0;
		}
	}
}
