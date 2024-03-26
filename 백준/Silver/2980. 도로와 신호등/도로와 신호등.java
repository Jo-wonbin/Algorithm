import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class TrafficLight {
        int dis, red, green;

        TrafficLight(int dis, int red, int green) {
            this.dis = dis;
            this.red = red;
            this.green = green;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        TrafficLight lights[] = new TrafficLight[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lights[i] = new TrafficLight(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        int time = 0;
        int nowDis = 0;

        for (int i = 0; i < N; i++) {
            time += lights[i].dis - nowDis;
            nowDis = lights[i].dis;

            int temp = time % (lights[i].red + lights[i].green);
            if (temp < lights[i].red) {
                time += lights[i].red - temp;
            }
        }
        time += L - nowDis;
        System.out.println(time);
        br.close();
    }

}