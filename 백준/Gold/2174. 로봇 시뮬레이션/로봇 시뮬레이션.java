import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Robot {
        int x, y, dir;

        public Robot(int x, int y, int dir) {
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

    }

    static class Order {
        int index, times;
        char ord;

        public Order(int index, char ord, int times) {
            this.index = index;
            this.ord = ord;
            this.times = times;
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        int numOfRobot = Integer.parseInt(st.nextToken());
        int order = Integer.parseInt(st.nextToken());

        ArrayList<Robot> robots = new ArrayList<>();
        for (int i = 0; i < numOfRobot; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            char temp = st.nextToken().charAt(0);
            int dir = 0;
            if (temp == 'N') {
                dir = 1;
            } else if (temp == 'E') {
                dir = 2;
            } else if (temp == 'S') {
                dir = 3;
            }
            robots.add(new Robot(x, y, dir));
        }

        int dx[] = {-1, 0, 1, 0};
        int dy[] = {0, 1, 0, -1};
        ArrayList<Order> orders = new ArrayList<>();
        for (int i = 0; i < order; i++) {
            st = new StringTokenizer(br.readLine());
            orders.add(new Order(Integer.parseInt(st.nextToken()) - 1, st.nextToken().charAt(0), Integer.parseInt(st.nextToken())));
        }
        for (int i = 0; i < order; i++) {

            int nowRobot = orders.get(i).index;
            char ord = orders.get(i).ord;
            int times = orders.get(i).times;

            for (int j = 0; j < times; j++) {
                Robot now = robots.get(nowRobot);
                if (ord == 'L') {
                    now.dir = (now.dir + 3) % 4;
                } else if (ord == 'R') {
                    now.dir = (now.dir + 1) % 4;
                } else {
                    int nx = now.x + dx[now.dir];
                    int ny = now.y + dy[now.dir];
                    if (nx < 1 || ny < 1 || nx > N || ny > M) {
                        System.out.println("Robot " + (nowRobot + 1) + " crashes into the wall");
                        return;
                    }
                    for (int z = 0; z < robots.size(); z++) {
                        Robot temp = robots.get(z);
                        if (z != nowRobot && temp.x == nx && temp.y == ny) {
                            System.out.println("Robot " + (nowRobot + 1) + " crashes into robot " + (robots.indexOf(temp) + 1));
                            return;
                        }
                    }
                    robots.remove(nowRobot);
                    robots.add(nowRobot, new Robot(nx, ny, now.dir));
                }
            }

        }

        System.out.println("OK");

        br.close();
    }

}