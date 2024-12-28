import java.util.Arrays;

public class SalesmanTraveling {
    private static final int INF = 100000000;

    public static int tsp(int[][] graph, int visited, int current, int n, int[][] dp) {
        if (visited == (1 << n) - 1) {
            return graph[current][0];
        }

        if (dp[visited][current] != -1) {
            return dp[visited][current];
        }

        int minCost = INF;

        for (int next = 0; next < n; next++) {
            if ((visited & (1 << next)) == 0) {
                int cost = graph[current][next] + tsp(graph, visited | (1 << next), next, n, dp);
                minCost = Math.min(minCost, cost);
            }
        }

        dp[visited][current] = minCost;
        return minCost;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] graph = {
                {0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}
        };

        int[][] dp = new int[1 << n][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        int minCost = tsp(graph, 1, 0, n, dp);
        System.out.println("Minimum cost of traveling: " + minCost);
    }
}