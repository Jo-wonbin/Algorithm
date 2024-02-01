import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        
        int requirement = -1;
        int orderBy = -1;
        
        if(ext.equals("code")){
            requirement = 0;
        }else if(ext.equals("date")){
            requirement = 1;
        }else if(ext.equals("maximum")){
            requirement = 2;
        }else{
            requirement = 3;
        }
        
        if(sort_by.equals("code")){
            orderBy = 0;
        }else if(sort_by.equals("date")){
            orderBy = 1;
        }else if(sort_by.equals("maximum")){
            orderBy = 2;
        }else{
            orderBy = 3;
        }
        
        ArrayList<int[]> dataList = new ArrayList<>();
        
        for(int i=0; i<data.length; i++){
            if(data[i][requirement] < val_ext){
                dataList.add(data[i]);
            }
        }
        final int order = orderBy;
        Collections.sort(dataList, (o1, o2) -> {
            return o1[order]-o2[order];
        });
        int answer[][] = new int[dataList.size()][4];
        for(int i=0; i<answer.length; i++){
            answer[i] = dataList.get(i);
        }
        
        return answer;
    }
    
    
}