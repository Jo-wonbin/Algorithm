package Programmers;

public class Programmers_타겟넘버 {

    class Solution {

        int result;

        public int solution(int[] numbers, int target) {
            int answer = 0;

            result = 0;

            find(0, numbers.length, numbers, target, 0);

            answer = result;
            return answer;
        }

        public void find(int cnt, int size, int[] num, int target, int now) {

            if (cnt == size) {

                if (now == target)
                    result++;

                return;
            }

            find(cnt + 1, size, num, target, now + num[cnt]);
            find(cnt + 1, size, num, target, now - num[cnt]);
        }
    }

}
