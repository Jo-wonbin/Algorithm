package Programmers;

public class Programmers_여행경로 {

    static boolean check[];
    static StringBuilder airportList = new StringBuilder();
    static String result = "J";

    public String[] solution(String[][] tickets) {

        check = new boolean[tickets.length];

        airportList.append("ICN ");
        dfs(tickets, 0, "ICN");

        String[] answer = result.split(" ");

        return answer;
    }

    static void dfs(String[][] tickets, int cnt, String airport) {
        if (cnt == tickets.length) {
            result = (result.compareTo(airportList.toString()) > 0) ? airportList.toString() : result;
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (check[i])
                continue;
            if (!airport.equals(tickets[i][0]))
                continue;
            airportList.append(tickets[i][1]).append(" ");
            check[i] = true;
            dfs(tickets, cnt + 1, tickets[i][1]);
            check[i] = false;
            airportList.setLength(airportList.length() - 4);
        }
    }
}
