package Programmers;

import java.util.*;

public class Programmers_주차요금계산 {


    class Solution {
        public int[] solution(int[] fees, String[] records) {

            int[] list = new int[10000];
            int[] temp = new int[10000];
            boolean in[] = new boolean[10000];
            StringTokenizer st;

            for (int i = 0; i < records.length; i++) {
                st = new StringTokenizer(records[i]);
                String time = st.nextToken();
                String t[] = time.split(":");
                int hour = Integer.parseInt(t[0]);
                int minute = Integer.parseInt(t[1]);

                int carNum = Integer.parseInt(st.nextToken());

                if (st.nextToken().equals("IN")) {

                    in[carNum] = true;
                    temp[carNum] += (hour * 60) + minute;

                } else {

                    in[carNum] = false;
                    int now = (hour * 60) + minute;
                    list[carNum] += now - temp[carNum];
                    temp[carNum] = 0;

                }

            }

            for (int i = 0; i < 10000; i++) {
                if (!in[i])
                    continue;
                int now = (23 * 60) + 59;
                list[i] += now - temp[i];
                temp[i] = 0;
            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 0; i < 10000; i++) {
                if (list[i] == 0)
                    continue;
                if (list[i] <= fees[0]) {
                    q.add(fees[1]);
                } else {
                    int tmp = (list[i] - fees[0]) / fees[2];
                    if (((list[i] - fees[0]) % fees[2]) != 0) {
                        tmp++;
                    }

                    q.add(fees[1] + tmp * fees[3]);
                }
            }
            int size = q.size();
            int[] answer = new int[size];
            for (int i = 0; i < size; i++) {
                answer[i] = q.poll();
            }

            return answer;
        }
    }

}
