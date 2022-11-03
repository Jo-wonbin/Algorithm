package BOJ.BOJ_Practice;

import java.util.Scanner;

public class BOJ_10870 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(fibonacci(n));
		sc.close();
	}
	
	
	static int fibonacci(int n) {
		if(n <= 1)
			return n;
		else
			return fibonacci(n-2)+fibonacci(n-1);
		}
}
