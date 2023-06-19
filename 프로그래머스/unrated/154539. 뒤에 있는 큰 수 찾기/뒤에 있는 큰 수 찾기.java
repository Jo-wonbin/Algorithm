import java.util.*;

class Solution {
    
    static class Point{
        int num, index;
        
        Point(int num, int index){
            this.num=num;
            this.index = index;
        }
    }
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        
        Stack<Point> stack = new Stack<>();
        
        for(int i=0; i<numbers.length; i++){
            
            while(!stack.empty()){
                if(stack.peek().num < numbers[i]){
                    Point now = stack.pop();
                    answer[now.index] = numbers[i];
                }else{
                    break;
                }
            }
            stack.push(new Point(numbers[i], i));
        }
        
        while(!stack.empty()){
            Point now = stack.pop();
            answer[now.index] = -1;
        }
        
        
        return answer;
    }
}