package Programmers;

import java.util.*;

public class Programmers_프린터 {

    class Solution {

        public int solution(int[] priorities, int location) {
            int answer = 1;

            Queue<Integer> q = new LinkedList<>();
            Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

            for (int i = 0; i < priorities.length; i++) {
                q.add(i);
                pq.add(priorities[i]);
            }


            while (!q.isEmpty()) {
                int now = q.poll();
                int max = pq.peek();
                if (priorities[now] < max) {
                    q.add(now);
                } else if (priorities[now] == max) {
                    if (now == location) {
                        break;
                    } else {
                        pq.poll();
                        answer++;
                    }
                }
            }


            return answer;
        }
    }
}
