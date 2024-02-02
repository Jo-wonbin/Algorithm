class Solution {
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        boolean checked[] = new boolean[n+1];
        long temp = 1;
        int num = n;
        int cnt = 0;
        while(num > 0){
            temp = factorial(num-1);
            for(int i=1; i<=num; i++){
                if(k <= temp*i){
                    int value = check(i, checked, n);
                    checked[value] = true;
                    answer[cnt++] = value;
                    k -= temp*(i-1);
                    break;
                }
            }
            num--;
        }
        return answer;
    }
    
    public int check(int index, boolean visited[], int n){
        int result = 0;
        for(int i=1; i<=n; i++){
            if(!visited[i]){
                index--;
            }
            if(index == 0){
                result = i;
                break;
            }
        }
        return result;
    }
    
    public long factorial(long n){
        if(n == 1 || n == 0){
            return 1;
        }
        return n * factorial(n-1);  
    }
}