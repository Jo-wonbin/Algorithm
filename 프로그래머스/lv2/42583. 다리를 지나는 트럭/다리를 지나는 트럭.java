import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int temp : truck_weights){
            trucks.add(temp);
        }
        
        for(int i=0; i<bridge_length; i++){
            bridge.add(0);
        }
        
        int nowWeight = 0;
        
        while(!bridge.isEmpty()){
            int firstTruck = 0;
            if(!trucks.isEmpty()){
                firstTruck = trucks.peek();
                nowWeight -= bridge.poll();
                if(firstTruck + nowWeight <= weight){
                    bridge.add(trucks.poll());
                    nowWeight += firstTruck;
                }else{
                    bridge.add(0);
                }
            }else{
                bridge.poll();
            }
            
            answer++;
            
        }
        return answer;
    }
}