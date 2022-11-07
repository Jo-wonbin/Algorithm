package Programmers;

public class Programmers_짝지어제거하기 {
    class Solution
    {
        public int solution(String s)
        {
            int answer = 0;
            int size = 0;
            while(size != s.length()){

                size = s.length();

                char alpa[] = s.toCharArray();
                int count = 1;

                for(int i=1; i < alpa.length; i++){
                    if(alpa[i-1] == alpa[i]){
                        count++;
                    }

                    if(count == 2){
                        alpa[i-1] = '0';
                        alpa[i] = '0';
                        count = 0;
                    }
                }
                String a = alpa.toString();
                String[] temp = alpa.toString().split("0");
                StringBuilder sb = new StringBuilder();
                for(int i=0; i<temp.length; i++){
                    sb.append(temp[i]);
                }
                s = sb.toString();
                System.out.println(s);

            }

            if(s.length() > 1){
                answer = 1;
            }else{
                answer = 0;
            }

            return answer;
        }
    }
}
