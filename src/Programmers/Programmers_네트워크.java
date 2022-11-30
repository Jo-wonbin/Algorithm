package Programmers;

import java.util.*;

public class Programmers_네트워크 {

    class Solution {

        boolean visited[];

        public int solution(int n, int[][] computers) {
            int answer = 0;

            visited = new boolean[n + 1];

            for (int i = 0; i < n; i++) {
                if (!visited[i + 1]) {
                    bfs(computers, n, i + 1);
                    answer++;
                }
            }

            return answer;
        }

        public void bfs(int[][] computers, int n, int num) {
            Queue<Integer> q = new LinkedList<>();
            q.add(num);
            while (!q.isEmpty()) {
                int temp = q.poll();
                for (int i = 0; i < n; i++) {
                    int now = computers[temp - 1][i];
                    if (now == 0)
                        continue;
                    if (visited[i + 1])
                        continue;
                    q.add(i + 1);
                    visited[i + 1] = true;
                }
            }

        }
    }
}
