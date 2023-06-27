import java.util.*;

class Solution {
    
    static class Room{
        int start, end;
        
        Room(String start, String end){
            this.start = Integer.parseInt(start.split(":")[0]) * 60 + Integer.parseInt(start.split(":")[1]) * 1;
            this.end = Integer.parseInt(end.split(":")[0]) * 60 + Integer.parseInt(end.split(":")[1]) * 1 + 10;
        }
    }
    
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Room> pq = new PriorityQueue<>((o1, o2) -> {

            if(o1.start == o2.start){
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        for(String[] temp : book_time){
            pq.add(new Room(temp[0], temp[1]));
        }
        PriorityQueue<Room> pq2 = new PriorityQueue<>(Comparator.comparingInt(o -> o.end));
        pq2.add(pq.poll());
        
        while(!pq.isEmpty()){
            Room now = pq.poll();
            Room next = pq2.peek();
            
            if(next.end <= now.start){
                pq2.poll();
            }
            
            pq2.add(now);
        }
        answer = pq2.size();
        return answer;
    }
}