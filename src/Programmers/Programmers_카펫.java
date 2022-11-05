package Programmers;

public class Programmers_카펫 {
    class Solution {
        public int[] solution(int brown, int yellow) {
            int[] answer = {3, 3};

            int size = brown + yellow;

            for (int i = brown; i >= 3; i--) {

                for (int j = i; j >= 3; j--) {

                    if (i < j)
                        continue;

                    if (i * j != size)
                        continue;

                    if ((i - 2) * (j - 2) != yellow)
                        continue;

                    if (((i * 2) + (j * 2) - 4) != brown)
                        continue;

                    answer[0] = i;
                    answer[1] = j;

                    break;
                }
            }

            return answer;
        }
    }
}
