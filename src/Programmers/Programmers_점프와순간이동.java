package Programmers;

public class Programmers_점프와순간이동 {

    public class Solution {
        public int solution(int n) {
            int ans = 0;

            int temp = n;

            while (true) {
                if (temp == 1) {
                    ans++;
                    break;
                }

                if (temp % 2 == 1) {
                    ans++;
                }
                temp /= 2;
            }

            return ans;
        }
    }
}
