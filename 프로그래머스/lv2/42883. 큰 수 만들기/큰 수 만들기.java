import java.util.*;

class Solution {
    public String solution(String number, int k) {
        String answer = "";
        
        char temp[] = number.toCharArray();
        int index = 0;
        
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<temp.length; i++){
            if(stack.empty() || k == 0){
                stack.push(temp[i]);
                continue;
            }
            
            if(stack.peek() < temp[i]){
                while(!stack.empty()){
                    if(stack.peek() < temp[i] && k > 0){
                        stack.pop();
                        k--;
                    }else{
                        break;
                    }
                }
            }
            stack.push(temp[i]);
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(k > 0){
            stack.pop();
            k--;
        }
        
        while(!stack.empty()){
            sb.append(stack.pop());
        }
        
        answer = sb.reverse().toString();
        return answer;
    }
}