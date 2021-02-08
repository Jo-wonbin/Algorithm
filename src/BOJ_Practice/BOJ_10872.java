package BOJ_Practice;

import java.util.Scanner;

public class BOJ_10872 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		System.out.println(factorial(n));
		sc.close();
	}

	
	static int factorial(int n) {
		if(n==0)
			return 1;	
		else if(n < 2)
			return n;
		else
			return factorial(n-1)*n;
		
	}
}
