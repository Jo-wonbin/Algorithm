package Programmers;

import java.util.*;

public class Programmers_괄호회전하기 {

    class Solution {
        public int solution(String s) {
            int answer = 0;

            int size = s.length();

            for (int i = 0; i < size; i++) {

                if (check(s))
                    answer++;

                String temp1 = s.substring(s.length() - 1);
                String temp2 = s.substring(0, s.length() - 1);
                s = "";
                s += temp1 + temp2;

            }

            return answer;
        }

        public boolean check(String s) {
            Stack<Character> st = new Stack<>();

            for (int i = 0; i < s.length(); i++) {
                if (st.empty()) {
                    if (s.charAt(i) == '}' || s.charAt(i) == ']' || s.charAt(i) == ')')
                        return false;
                    st.add(s.charAt(i));
                    continue;
                }

                if (st.peek() == '{' && s.charAt(i) == '}') {
                    st.pop();
                    continue;
                }

                if (st.peek() == '[' && s.charAt(i) == ']') {
                    st.pop();
                    continue;
                }

                if (st.peek() == '(' && s.charAt(i) == ')') {
                    st.pop();
                    continue;
                }

                st.add(s.charAt(i));
            }

            if (!st.empty())
                return false;

            return true;
        }
    }
}
