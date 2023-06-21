import java.util.*;

class Solution {
    
    static StringBuilder sb = new StringBuilder();
    
    public String solution(int n) {
        String answer = "";
        
        Stack<Integer> stack = new Stack<>();
        while(n > 0){
            // if(n == 0){
            //     stack.push(1);
            //     break;
            // }
            if(n % 3 == 0){
                stack.push(4);
                n = (n/3) - 1;
            }else{
                stack.push(n%3);
                n = (n/3);
            }
        }
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        answer = sb.toString();
        return answer;
    }
}