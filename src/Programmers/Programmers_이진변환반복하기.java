package Programmers;
import java.lang.*;

public class Programmers_이진변환반복하기 {

    class Solution {
        public int[] solution(String s) {
            int[] answer = new int[2];

            char arr[] = s.toCharArray();

            int cnt1 = 0;
            int cnt2 = 0;

            while(true){

                if(s.length() == 1)
                    break;

                int count1 = 0;
                for(int i=0; i<arr.length; i++){
                    if(arr[i] == '1')
                        count1++;
                }
                cnt2 += s.length() - count1;
                s = Integer.toBinaryString(count1);
                arr = s.toCharArray();

                cnt1++;

            }

            answer[0] = cnt1;
            answer[1] = cnt2;

            return answer;
        }
    }
}
