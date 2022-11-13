package Programmers;

import java.util.*;

public class Programmers_주식가격 {


    class Solution {

        class Pair {
            int index, price;

            Pair(int index, int price) {
                this.index = index;
                this.price = price;
            }
        }

        public int[] solution(int[] prices) {
            int[] answer = new int[prices.length];

            Stack<Pair> st = new Stack<>();
            for (int i = 0; i < prices.length; i++) {
                if (st.empty()) {
                    st.push(new Pair(i, prices[i]));
                    continue;
                }
                Pair now = st.peek();

                while (!st.empty()) {
                    now = st.peek();
                    if (now.price <= prices[i])
                        break;
                    now = st.pop();
                    answer[now.index] = i - now.index;
                }
                st.push(new Pair(i, prices[i]));

            }

            while (!st.empty()) {
                Pair now = st.pop();
                answer[now.index] = prices.length - 1 - now.index;
            }

            return answer;
        }
    }
}
