import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<clothes.length; i++){
            set.add(clothes[i][1]);
        }
        
        int size[] = new int[set.size()];
        int cnt = 0;
        
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            
            String temp = it.next();
            
            for(int i=0; i<clothes.length; i++){
                if(clothes[i][1].equals(temp)){
                    size[cnt]++;
                }
            }
            
            cnt++;
        }
        
        for(int i=0; i<size.length; i++){
                answer *= size[i]+1;
        }

        // 아무것도 안 입는 경우 -1
        answer--;
        
        return answer;
    }
}