package Programmers;

public class Programmers_H_Index {

    class Solution {
        public int solution(int[] citations) {
            int answer = 0;

            int max = citations.length;
            int h = 1;
            while (h <= 1000) {

                int countMax = 0;

                for (int i = 0; i < citations.length; i++) {
                    if (citations[i] >= h) {
                        countMax++;
                    }

                }
                if (h <= countMax) {
                    answer = Math.max(answer, h);
                }
                h++;
            }


            return answer;
        }
    }

}
