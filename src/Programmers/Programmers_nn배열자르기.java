package Programmers;

import java.util.*;

public class Programmers_nn배열자르기 {

    class Solution {
        public int[] solution(int n, long left, long right) {
            int size = (int) (right - left);
            int[] answer = new int[size + 1];

            long ln1 = left / n;
            long ln2 = left % n;
            long rn1 = right / n;
            long rn2 = right % n;


            boolean flag = false;
            int cnt = 0;
            Loop1:
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (ln1 == i && ln2 == j) {
                        flag = true;
                    }
                    if (flag) {
                        answer[cnt++] = Math.max(i, j) + 1;
                    }
                    if (rn1 == i && rn2 == j) {
                        flag = false;
                        break Loop1;
                    }
                }
            }

            return answer;
        }
    }
}
