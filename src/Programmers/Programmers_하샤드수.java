package Programmers;

public class Programmers_하샤드수 {
    class Solution {
        public boolean solution(int x) {

            String temp = Integer.toString(x);
            int size = temp.length();

            int n = 0;
            for (int i = 0; i < size; i++) {
                int tp = temp.charAt(i) - '0';
                n += tp;
            }

            if (x % n == 0) {
                return true;
            } else {
                return false;
            }

        }
    }
}
