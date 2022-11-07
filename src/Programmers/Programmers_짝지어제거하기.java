package Programmers;
import java.util.*;

public class Programmers_짝지어제거하기 {

    class Solution {
        public int solution(String s) {
            int answer = 1;
            Stack<Character> stack = new Stack<>();

            char alpa[] = s.toCharArray();

            for (int i = 0; i < alpa.length; i++) {
                if (stack.empty()) {
                    stack.push(alpa[i]);
                    continue;
                }

                char now = stack.peek();
                if (now == alpa[i]) {
                    stack.pop();
                } else {
                    stack.push(alpa[i]);
                }
            }

            if (stack.size() != 0)
                answer = 0;

            return answer;
        }
    }
}
