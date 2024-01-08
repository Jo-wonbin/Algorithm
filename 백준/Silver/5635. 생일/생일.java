import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Age implements Comparable<Age>{
        String name;
        int day;
        int month;
        int year;

        public Age(String name, int day, int month, int year){
            this.name=name;
            this.day=day;
            this.month=month;
            this.year=year;
        }


        @Override
        public int compareTo(Age o) {
            if(this.year == o.year){
                if(this.month == o.month){
                    return this.day-o.day;
                }
                return this.month - o.month;
            }
            return this.year-o.year;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        List<Age> ageList = new ArrayList<>();

        StringTokenizer st;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            ageList.add(new Age(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(ageList);

        System.out.println(ageList.get(N-1).name);
        System.out.println(ageList.get(0).name);

        br.close();
    }
}