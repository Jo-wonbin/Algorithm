package Programmers;

public class Programmers_피로도 {
    class Solution {

        int max;
        int[] arr;
        boolean[] visited;

        public int solution(int k, int[][] dungeons) {
            int answer = -1;

            max = 0;
            arr = new int[dungeons.length];
            visited = new boolean[dungeons.length];

            Permutation(0, k, dungeons.length, dungeons);

            answer = max;

            return answer;
        }

        public void Permutation(int cnt, int k, int size, int[][] d) {
            if (cnt == size) {
                int temp = k;
                int count = 0;
                for (int i = 0; i < size; i++) {
                    if (temp < d[arr[i]][0])
                        continue;
                    temp -= d[arr[i]][1];
                    count++;
                }

                max = Math.max(max, count);

                return;
            }

            for (int i = 0; i < size; i++) {
                if (visited[i])
                    continue;
                arr[cnt] = i;
                visited[i] = true;
                Permutation(cnt + 1, k, size, d);
                visited[i] = false;
            }
        }
    }
}
