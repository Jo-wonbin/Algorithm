class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        double dd = Math.pow(d, 2);
        
        for(int i=0; i<=1000000; i++){
            if(i*k > d){
                break;
            }
            double temp = Math.sqrt(dd - Math.pow(i*k, 2));
            long cnt = (long)temp;
            answer += (cnt/k) + 1;
        }         
        return answer;
    }
}