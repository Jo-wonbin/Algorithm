package Programmers;

public class Programmers_다음큰숫자 {
    class Solution {
        public int solution(int n) {
            int answer = 0;

            String temp = Integer.toBinaryString(n);

            int count = 0;
            for (int i = 0; i < temp.length(); i++) {
                if (temp.charAt(i) == '1')
                    count++;
            }
            answer = n + 1;
            while (true) {
                temp = Integer.toBinaryString(answer);
                int cnt = 0;
                for (int i = 0; i < temp.length(); i++) {
                    if (temp.charAt(i) == '1')
                        cnt++;
                }
                if (count == cnt) {
                    break;
                }
                answer++;
            }

            return answer;
        }
    }
}
