class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int cnt = 2;
        while(true){
            if(n % cnt == 1){
                answer = cnt;
                break;
            }
            cnt++;
        }
        return answer;
    }
}