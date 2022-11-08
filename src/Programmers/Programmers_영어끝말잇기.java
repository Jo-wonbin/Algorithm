package Programmers;

import java.util.*;

public class Programmers_영어끝말잇기 {

    class Solution {
        public int[] solution(int n, String[] words) {
            int[] answer = {0, 0};

            Set<String> s = new HashSet<>();
            int player[] = new int[n];
            char temp = words[0].charAt(0);

            for (int i = 0; i < words.length; i++) {

                player[i % n]++;

                if (words[i].length() <= 1 || temp != words[i].charAt(0) || s.contains(words[i])) {
                    answer[0] = (i % n) + 1;
                    answer[1] = player[i % n];
                    break;
                }


                temp = words[i].charAt(words[i].length() - 1);
                s.add(words[i]);
            }


            return answer;
        }
    }
}
