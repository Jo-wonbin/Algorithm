package BOJweek7;

import java.util.Scanner;

public class BOJ_2839_설탕배달 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		if (n == 4 || n == 7) {
			System.out.println(-1);
		} else if (n % 5 == 0) {
			System.out.println(n / 5);
		} else if (n % 5 == 1 || n % 5 == 3) {
			System.out.println((n / 5) + 1);
		} else if (n % 5 == 2 || n % 5 == 4) {
			System.out.println((n / 5) + 2);
		}

	}

}
