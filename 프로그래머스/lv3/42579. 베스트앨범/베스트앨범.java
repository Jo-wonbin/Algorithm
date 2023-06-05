import java.util.*;

class Solution {
    
    static class Genre implements Comparable<Genre>{
        int play;
        int num;
        
        public Genre(int play, int num){
            this.play = play;
            this.num = num;
        }
        
        @Override
        public int compareTo(Genre genre){
            if(genre.play < play){
                return -1;
            }else if(genre.play == play){
                if(genre.num < num){
                    return 1;
                }
            }
            return 0;
        }
    }
    
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        
        Map<String, List<Genre>> map = new HashMap<>();
        Map<String, Integer> score = new  HashMap<>();
        
        for(int i=0; i<genres.length; i++){
            if(map.containsKey(genres[i])){
                List<Genre> list = map.get(genres[i]);
                list.add(new Genre(plays[i], i));
                map.replace(genres[i], list);
                
                score.replace(genres[i], score.get(genres[i]) + plays[i]);
            }else{
                List<Genre> list = new ArrayList<Genre>();
                list.add(new Genre(plays[i], i));
                map.put(genres[i], list);
                score.put(genres[i], plays[i]);
            }
        }
        
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(score.entrySet());
        
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        
        List<Integer> result = new ArrayList<>();
        
        for (Map.Entry<String, Integer> entry : entries) {
            List<Genre> temp = map.get(entry.getKey());
            Collections.sort(temp);
            if(temp.size() < 2){
                result.add(temp.get(0).num);
            }else{
                for(int i=0; i<2; i++){
                    result.add(temp.get(i).num);
                }
            }
        }
        
        answer = result.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}