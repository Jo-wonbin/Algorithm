import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        
        String temp = String.valueOf(n);
        
        char arr[] = temp.toCharArray();
        
        Arrays.sort(arr);
        
        StringBuilder sb = new StringBuilder();
        for(int i=arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }

        answer = Long.parseLong(sb.toString());
        
        return answer;
    }
}