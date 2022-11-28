package Programmers;

import java.util.*;

public class Programmers_구명보트 {

    class Solution {
        public int solution(int[] people, int limit) {
            int answer = 0;

            Arrays.sort(people);

            ArrayDeque<Integer> dq = new ArrayDeque<>();

            for (int i : people) {
                dq.add(i);
            }

            while (!dq.isEmpty()) {
                int weight = dq.pollLast();
                if (!dq.isEmpty() && limit - weight >= dq.peek()) {
                    dq.pollFirst();
                }
                answer++;
            }

            return answer;
        }
    }
}
