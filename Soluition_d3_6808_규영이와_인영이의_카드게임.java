

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Soluition_d3_6808_규영이와_인영이의_카드게임 {

	static int T;
	static int kyu;
	static int ji;
	static int[] kyu_card_arr;
	static int[] ji_card_arr;
	static int[] new_ji_card_arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());
		StringTokenizer st;


		for (int t = 1; t <= T; t++) {
			kyu = 0;
			ji = 0;
			kyu_card_arr = new int[9];
			ji_card_arr = new int[9];
			new_ji_card_arr = new int[9];

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < kyu_card_arr.length; i++) {
				kyu_card_arr[i] = Integer.parseInt(st.nextToken());
//				System.out.println(kyu_card_arr[i] );
			}

			for (int i = 1; i <= 18; i++) {
				if (!arr_contains(kyu_card_arr, i)) {
					arr_add(ji_card_arr, i);
				}
			}
			
//			for (int i = 0; i < ji_card_arr.length; i++) {
//				System.out.println(ji_card_arr[i] );
//			}
			
			Perm(0, 0);

			System.out.printf("#%d %d %d\n", t, kyu, ji);
		}

	}

	

	public static void Perm(int flag, int count) {
		int kyu_sum = 0;
		int ji_sum = 0;

		if (9 == count) {
			for (int i = 0; i < new_ji_card_arr.length; i++) {
//				System.out.println(kyu_card_arr[i]);
				if (new_ji_card_arr[i] < kyu_card_arr[i]) {
					kyu_sum += kyu_card_arr[i] + new_ji_card_arr[i];
				} else if  (new_ji_card_arr[i] > kyu_card_arr[i]){
					ji_sum += new_ji_card_arr[i] + kyu_card_arr[i];
				}
			}
//			System.out.println(kyu_sum);
			if (kyu_sum > ji_sum) {
				kyu++;
			} else {
				ji++;
			}
			return;
		}

		for (int i = 0; i < 9; i++) {
			//표시가 있냐없냐
			if ((flag & 1 << i) != 0) {
				continue;
			} else {
				//없는경우 넣어줌.
				new_ji_card_arr[count] = ji_card_arr[i];
				Perm(flag | (1 << i), count + 1);
			}
		}
	}

	public static boolean arr_contains(int[] arr, int number) {
		for (int t = 0; t < arr.length; t++) {
			if (arr[t] == number) {
				return true;
			}
		}

		return false;
	}

	public static void arr_add(int[] arr, int number) {
		for (int t = 0; t < arr.length; t++) {
			if (arr[t] == 0) {
				arr[t] = number;
				break;
			}
		}
	}

}
