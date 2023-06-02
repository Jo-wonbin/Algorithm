import java.util.*;

class Solution {
    
    static ArrayList<Integer> list[];
    static ArrayList<Integer> abs = new ArrayList<>();
    static boolean visited[];
    static Queue<Integer> q = new LinkedList<>();
    static int result;
    
    public int solution(int n, int[][] wires) {
        int answer = -1;        
        
        int cnt=0;
        result = Integer.MAX_VALUE;
        while(cnt < wires.length){
            
            list = new ArrayList[n+1];
            for(int j=1; j<=n; j++){
                list[j] = new ArrayList<>();
            }
            for(int i=0; i<wires.length; i++){
                if(cnt == i){
                    continue;
                }
                    
                list[wires[i][0]].add(wires[i][1]);
                list[wires[i][1]].add(wires[i][0]); 
            }
            
            visited = new boolean[n+1];
            for(int i=1; i<=n; i++){
                if(visited[i])
                    continue;
                q.clear();
                abs.add(bfs(i));
            }
            result = Math.min(result, Math.abs(abs.get(0) - abs.get(1)));
            cnt++;
            abs.clear();
        }
        
        answer = result;
        return answer;
    }
    
    static int bfs(int index){
        q.add(index);
        visited[index] = true;
        int cnt = 1;
        while(!q.isEmpty()){
            int now = q.poll();
            
            for(int i=0; i<list[now].size(); i++){
                int temp = list[now].get(i);
                if(visited[temp])
                    continue;
                visited[temp] = true;
                q.add(temp);
                cnt++;
            }
        }
        
        return cnt;
    }
}