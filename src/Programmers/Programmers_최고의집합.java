package Programmers;

import java.util.*;

public class Programmers_최고의집합 {

    class Solution {

        public int[] solution(int n, int s) {

            if (n > s) {
                return new int[]{-1};
            }

            int[] answer = new int[n];

            for (int i = 0; i < answer.length; i++) {
                answer[i] = s / n;
            }

            for (int i = 0; i < s % n; i++) {
                answer[i]++;
            }

            Arrays.sort(answer);

            return answer;
        }
    }

}
