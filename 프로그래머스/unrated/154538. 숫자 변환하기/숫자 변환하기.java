import java.util.*;

class Solution {
    
    static class Count{
        int num, cnt;
        
        public Count(int num, int cnt){
            this.num = num;
            this.cnt = cnt;
        }
    } 
    
    public int solution(int x, int y, int n) {
        int answer = 0;
        
        answer = find(x, y, n);
        
        return answer;
    }
    
    public int find(int x, int y, int n){
        
        Queue<Count> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(new Count(x, 0));
        
        while(!q.isEmpty()){
            Count now = q.poll();
            if(now.num == y){
                return now.cnt;
            }
            
            if(set.contains(now.num)){
               continue; 
            }else{
                set.add(now.num);
            }
            
            if(now.num + n <= 1000000){
                q.add(new Count(now.num + n, now.cnt+1));
            }
            if(now.num * 2 <= 1000000){
                q.add(new Count(now.num*2, now.cnt+1));
            }
            if(now.num * 3 <= 1000000){
                q.add(new Count(now.num*3, now.cnt+1));
            }
            
        }
        
        return -1;
    }
}