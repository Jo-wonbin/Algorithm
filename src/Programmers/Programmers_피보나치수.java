package Programmers;

public class Programmers_피보나치수 {

    class Solution {
        public long solution(int n) {
            long answer = 0L;

            long fn[] = new long[100001];

            fn[1] = 1L;
            fn[2] = 1L;

            if (n >= 3) {
                for (int i = 3; i <= n; i++) {
                    fn[i] = (fn[i - 2] + fn[i - 1]) % 1234567L;
                }
            }
            answer = fn[n];

            return answer;
        }
    }

}
