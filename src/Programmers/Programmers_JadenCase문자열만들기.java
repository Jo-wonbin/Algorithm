package Programmers;

public class Programmers_JadenCase문자열만들기 {
    class Solution {
        public String solution(String s) {
            String answer = "";

            char[] charArr = s.toCharArray();
            boolean flag = true;
            for(int i=0; i<charArr.length; i++){
                int temp = charArr[i] - '0';

                if(charArr[i] == ' '){ // 공백이면
                    flag = true;
                    continue;
                }
                if(flag){ // 첫 글자일 때
                    if(temp >= 97 ||  temp <= 122){ // 소문자면
                        String first = Character.toString(charArr[i]);
                        first = first.toUpperCase();
                        charArr[i] = first.charAt(0);
                    }
                }else{ // 첫 글자가 아닐 때
                    if(temp >= 65 ||  temp <= 90){ // 대문자면
                        String first = Character.toString(charArr[i]);
                        first = first.toLowerCase();
                        charArr[i] = first.charAt(0);
                    }
                }
                flag = false;
            }

            answer = String.valueOf(charArr);


            return answer;
        }
    }

}
