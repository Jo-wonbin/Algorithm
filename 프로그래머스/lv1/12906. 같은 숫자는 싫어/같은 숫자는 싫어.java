import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Stack<Integer> stack = new Stack<>();
        
        for(int temp : arr){
            if(stack.isEmpty()){
                stack.push(temp);
            }else if(stack.peek() != temp){
                stack.push(temp); 
            }
        }
        List<Integer> list = new ArrayList<>();

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }
        
        Collections.reverse(list);
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}