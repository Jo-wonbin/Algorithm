package Programmers;

import java.util.*;

public class Programmers_야근지수 {

    class Solution {
        public long solution(int n, int[] works) {
            long answer = 0;
            int size = works.length;

            PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

            for (int i = 0; i < size; i++) {
                pq.add(works[i]);
            }

            while (true) {
                if (n == 0)
                    break;
                int temp = pq.poll();
                if (n > 0) {
                    pq.add(temp - 1);
                }
                n--;
            }
            while (!pq.isEmpty()) {
                int temp = pq.poll();
                if (temp > 0)
                    answer += (temp * temp);
            }

            return answer;
        }
    }
}
