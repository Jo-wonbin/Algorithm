import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        
        int cnt = 0;
        for(int i=1; i <= order.length; i++){
            
            if(order[cnt] == i){
                answer++;
                cnt++;
            }else{
                while(!stack.empty() && stack.peek() == order[cnt]){
                    stack.pop();
                    answer++;
                    cnt++;
                }
                stack.push(i);
            }
        }
        
        while(!stack.empty() && stack.peek() == order[cnt]){
            stack.pop();
            cnt++;
            answer++;
        }
        
        return answer;
    }
}