import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String arr[] = br.readLine().split("-");

        int result = 0;
        for(int i=0; i<arr.length; i++){
            String []temp = arr[i].split("\\+");
            int now = 0;
            for(int j=0; j<temp.length; j++){
                now += Integer.parseInt(temp[j]);
            }
            if(i == 0){
                result += now;
            }else{
                result -= now;
            }
        }

        System.out.println(result);

        br.close();
    }
}