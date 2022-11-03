package Programmers;

import java.util.*;

class Programmers_디스크컨트롤러 {

    class Solution {

        public int solution(int[][] jobs) {
            int answer = 0;
            int size = jobs.length;

            Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

            PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

            int count = 0;
            int end = 0;
            int jobsIdx = 0;

            while (count < size) {

                // 작업 중에 작업 시간 끝나기 전 들어오는 모든 작업을 큐에 넣어줌
                while (jobsIdx < size && jobs[jobsIdx][0] <= end) {
                    pq.add(jobs[jobsIdx]);
                    jobsIdx++;
                }

                // 큐가 비었다면 들어올 작업이 있으므로 작업 시간 갱신
                if (pq.isEmpty()) {
                    end = jobs[jobsIdx][0];

                    // 작업 시간 중 들어온 작업 모두 처리
                } else {
                    int[] temp = pq.poll();
                    answer += temp[1] + end - temp[0];
                    end += temp[1];
                    count++;
                }

            }

            return answer / size;
        }
    }
}