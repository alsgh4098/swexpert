

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_3307_최장증가부분수열 {

	static int T;
	static int L;
//	static int max;
	static int []count;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for (int t = 1; t <= T; t++) {
            L = sc.nextInt();
            int[] nums = new int[L];
            for (int l = 0; l < L; l++) {
                nums[l] = sc.nextInt();
            }
//            max = 0;
            count = new int[L];
            Arrays.fill(count, 1);
            for (int i = 0; i <nums.length; i++) {
                for (int j = i+1; j < nums.length; j++) {
                    if (nums[i] < nums[j] && count[i]+1 > count[j]) {
                        count[j]++;
                    }
                }
            }
            Arrays.sort(count);
            System.out.println("#" + t + " " + count[L-1]);
        }
    }
}

//public static void dfs(int index, int sc, int[] nums) {
//	if (index == L - 1) {
//		max = Math.max(max, sc);
//		return;
//	}
//	int add = 0;
//	if (nums[index] <= nums[index + 1]) {
//		add = 1;
//	}
//	dfs(index + 1, sc + add, nums);
//	dfs(index + 1, sc, nums);
//	return;
//}