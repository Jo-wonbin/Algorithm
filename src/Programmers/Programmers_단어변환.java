package Programmers;

public class Programmers_단어변환 {
    class Solution {

        boolean visited[];
        int min;

        public int solution(String begin, String target, String[] words) {

            min = words.length + 1;
            visited = new boolean[words.length];

            dfs(0, begin, target, words);

            if (min == words.length + 1) {
                return 0;
            } else {
                return min;
            }
        }

        public void dfs(int cnt, String now, String target, String[] words) {
            if (now.equals(target)) {
                min = Math.min(min, cnt);

                return;
            }

            for (int i = 0; i < words.length; i++) {

                if (visited[i])
                    continue;
                int count = 0;
                for (int j = 0; j < now.length(); j++) {
                    if (now.charAt(j) != words[i].charAt(j)) {
                        count++;
                    }
                }
                if (count == 1) {
                    visited[i] = true;
                    dfs(cnt + 1, words[i], target, words);
                    visited[i] = false;
                }
            }
        }
    }
}
