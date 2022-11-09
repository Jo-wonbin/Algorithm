package Programmers;

import java.util.*;

public class Programmers_N개의최소공배수 {

    class Solution {

        public int solution(int[] arr) {

            Arrays.sort(arr);
            int answer = arr[0];

            for (int i = 01; i < arr.length; i++) {
                answer = LCM(answer, arr[i]);
            }

            return answer;
        }


        public int LCM(int a, int b) {
            return a * b / GCD(a, b);
        }

        public int GCD(int a, int b) {
            if (b == 0)
                return a;
            return GCD(b, a % b);
        }
    }
}
