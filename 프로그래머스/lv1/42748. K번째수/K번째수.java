import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {0};
        List<Integer> list = new ArrayList<>();
        for(int []temp : commands){
            int i = temp[0];
            int j = temp[1];
            int k = temp[2];
            int arr[] = Arrays.stream(array, i-1, j).toArray();
            Arrays.sort(arr);
            list.add(arr[k-1]);
        }
        
        answer = list.stream().mapToInt(Integer::intValue).toArray();
        
        return answer;
    }
}