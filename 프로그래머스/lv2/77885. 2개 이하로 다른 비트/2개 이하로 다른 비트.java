import java.util.*;

class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = {};
        
        List<Long> list = new ArrayList<>();
    
        for(int i=0; i < numbers.length; i++){
            
            if(numbers[i] % 2 == 0){
                list.add(numbers[i]+1);
                continue;
            }
            
            long temp = numbers[i];
            String binary = Long.toBinaryString(temp);
            int index = binary.length()-1;
            int cnt = 0;
            for(int j = binary.length()-1; j >= 0; j--){
                if(binary.charAt(j) == '1'){
                    cnt++;
                }else{
                    break;
                }
            }
            
            list.add(numbers[i] + (long)Math.pow(2, cnt) - (long)(Math.pow(2, cnt-1)));
            
        }
        
        answer = list.stream().mapToLong(Long::longValue).toArray();
        
        return answer;
    }
}