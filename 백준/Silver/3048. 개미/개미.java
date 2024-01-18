import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Ant {
        char name;
        int dir;

        Ant(char name, int dir) {
            this.name = name;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String ant1 = br.readLine();
        String ant2 = br.readLine();

        Ant arrNow[] = new Ant[ant1.length() + ant2.length()];

        for (int i = 0; i < ant1.length(); i++) {
            char name = ant1.charAt(ant1.length() - 1 - i);
            arrNow[i] = new Ant(name, 1);
        }

        for (int i = 0; i < ant2.length(); i++) {
            arrNow[N + i] = new Ant(ant2.charAt(i), -1);
        }
        int T = Integer.parseInt(br.readLine());
        for (int z = 0; z < T; z++) {
            for (int i = 0; i < arrNow.length - 1; i++) {
                if (arrNow[i].dir == 1 && arrNow[i + 1].dir == -1) {
                    char name = arrNow[i + 1].name;
                    arrNow[i + 1].name = arrNow[i].name;
                    arrNow[i].name = name;
                    arrNow[i].dir *= -1;
                    arrNow[i + 1].dir *= -1;
                    i++;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrNow.length; i++) {
            sb.append(arrNow[i].name);
        }
        System.out.println(sb);
        br.close();
    }
}