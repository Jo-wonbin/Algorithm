import java.util.stream.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        
        if(arr.length <= 1){
            return answer;
        }else{
            int min = Integer.MAX_VALUE;
            int index = 0;
            for(int i=0; i<arr.length; i++){
                if(min > arr[i]){
                    min = arr[i];
                    index = i;
                }
            }
            Integer MIN = min;
            IntStream stream = Arrays.stream(arr);
            answer = stream.filter(s -> s != MIN).toArray();
            
        }
        
        return answer;
    }
}