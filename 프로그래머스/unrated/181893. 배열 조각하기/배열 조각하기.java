import java.util.*;

class Solution {
    public int[] solution(int[] arr, int[] query) {
        int[] answer = {};
        
        for(int i=0; i<query.length; i++){
            int temp = query[i];
            if(i % 2 == 0){
                arr = Arrays.stream(arr, 0, temp+1).toArray();
            }else{
                arr = Arrays.stream(arr, temp, arr.length).toArray();
            }
        }
        
        return arr;
    }
}