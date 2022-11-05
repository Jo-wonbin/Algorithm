package Programmers;

public class Programmers_숫자의표현 {

    class Solution {
        public int solution(int n) {
            int answer = 1;

            for (int i = 1; i <= n - 1; i++) {
                int temp = i;

                for (int j = i + 1; j <= n; j++) {
                    temp += j;
                    if (temp > n)
                        break;
                    if (temp == n) {
                        answer++;
                        break;
                    }
                }
            }

            return answer;
        }
    }
}
