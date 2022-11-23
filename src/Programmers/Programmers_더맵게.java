package Programmers;

import java.util.*;

public class Programmers_더맵게 {

    class Solution {
        public int solution(int[] scoville, int K) {
            int answer = 0;

            PriorityQueue<Long> pq = new PriorityQueue<>();

            for (int i = 0; i < scoville.length; i++) {
                pq.add((long) scoville[i]);
            }

            int cnt = 0;
            while (pq.size() > 1) {

                if (pq.peek() >= K)
                    break;

                long lowest = pq.poll();
                long lowest2 = pq.poll();

                pq.add(lowest + (lowest2 * 2));

                cnt++;


            }

            if (pq.peek() < K) {
                answer = -1;
            } else {
                answer = cnt;
            }

            return answer;
        }
    }
}
