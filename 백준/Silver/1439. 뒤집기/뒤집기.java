import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] arr = br.readLine().toCharArray();

        int cnt0 = 0;
        int cnt1 = 0;

        char now = arr[0];
        if(now == '0'){
            cnt0++;
        }else{
            cnt1++;
        }
        for(int i=1; i<arr.length; i++){
            if(now != arr[i]){
                if(now == '0'){
                    cnt1++;
                    now = '1';
                }else{
                    cnt0++;
                    now = '0';
                }
            }
        }
        int result = cnt0 >= cnt1 ? cnt1 : cnt0;
        System.out.println(result);
        br.close();
    }

}