package Programmers;

public class Programmers_N개의최소공배수_완전탐색 {

    class Solution {

        int[] temp;
        long min = Long.MAX_VALUE;

        public long solution(int[] arr) {
            long answer = 0;

            for (int i = arr.length; i >= 1; i--) {
                temp = new int[i];
                comb(0, 0, i, arr);
            }
            answer = min;

            return answer;
        }

        public void comb(int cnt, int now, int cut, int[] arr) {
            if (cnt == cut) {

                long size = 1L;
                for (int i = 0; i < temp.length; i++) {
                    size *= temp[i];
                }

                boolean flag = true;
                for (int i = 0; i < arr.length; i++) {
                    long a = size % arr[i];
                    if (a == 0) {
                        continue;
                    }
                    flag = false;
                    break;
                }

                if (flag) {
                    min = Math.min(min, size);
                }

                return;
            }

            for (int i = now; i < arr.length; i++) {
                temp[cnt] = arr[i];
                comb(cnt + 1, i + 1, cut, arr);
            }
        }
    }
}
