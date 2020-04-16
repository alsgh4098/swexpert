package com.ssafy.edu;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1175_주사위던지기2 {

	static int N, M;
	static int[] nums;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String data = in.readLine();
		StringTokenizer st = new StringTokenizer(data);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		nums = new int[N];

		every(0, 0);

	}

	public static void every(int start, int count) {
		if (count == N) {
			int sum = 0;
			for (int i = 0; i < nums.length; i++) {
				sum += nums[i];
			}
			if (sum == M) {
				for (int i = 0; i < nums.length; i++) {
					System.out.print(nums[i] + " ");
				}
				System.out.println();
			}
			return;
		}
		for (int i = start; i < 6; i++) {
			nums[count] = i + 1;
			every(0, count + 1);
		}
	}
}
