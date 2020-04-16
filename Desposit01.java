package com.ssafy.edu;

import java.util.Scanner;

public class Desposit01 {

	static int Y;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Y = sc.nextInt();
		double sum = 0;
		double a = 800000;
		double rr = 2.0;
		double r = rr / 100 / 12;
		for (int i = 0; i < Y * 12; i++) {
			sum += a * (1 + r);
			a *= (1 + r);
		}
		System.out.println(String.format("%.0f", sum));
	}

}
