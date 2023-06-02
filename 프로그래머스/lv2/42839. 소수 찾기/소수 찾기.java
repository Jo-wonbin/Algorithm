import java.util.*;

class Solution {
    
    static char[] num;
    static boolean[] visited;
    static Set<Integer> set = new HashSet();
    static int result;
    
    public int solution(String numbers) {
        int answer = 0;
        
        num = numbers.toCharArray();
        result = 0;
        for(int i=1; i<=numbers.length(); i++){
            visited = new boolean[numbers.length()];
            StringBuilder sb = new StringBuilder();
            dfs(0, i, sb);
        }
        
        answer = result;
        return answer;
    }
    
    static void findPrimeNum(StringBuilder list){
        
        
        String temp = list.toString();
        
        int value = Integer.valueOf(temp).intValue();
        if(set.contains(value) || value < 2){
            return;
        }else{
            set.add(value);
        }
        
        int cnt=0;
        for(int i=1; i <= value; i++){
            if(value % i == 0)
                cnt++;
            if(cnt == 3){
                return;
            }
        }
        if(cnt == 2){
            result++;
        }
        
    }
    
    static void dfs(int cnt, int size, StringBuilder list){
        if(cnt == size){
            
            findPrimeNum(list);
            
            return;
        }
        
        for(int i=0; i<num.length; i++){
            if(visited[i]){
                continue;
            }
            visited[i] = true;
            list.append(num[i]);
            dfs(cnt+1, size, list);
            list.setLength(list.length()-1);
            visited[i] = false;
        }
        
    }
    
    
    
}