package binaryTreeSearch;


import java.util.*;

class Prim {

    public static List<int[]> prim(int n, List<int[]>[] graph, int start) {
        boolean[] visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        List<int[]> mst = new ArrayList<>();

        pq.add(new Edge(start, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            if (visited[current.node]) {
                continue;
            }
            visited[current.node] = true;

            for (int[] neighbor : graph[current.node]) {
                int nextNode = neighbor[0];
                int weight = neighbor[1];
                if (!visited[nextNode]) {
                    pq.add(new Edge(nextNode, weight));
                }
            }

            if (current.weight != 0) {
                mst.add(new int[]{start, current.node, current.weight});
            }
        }

        return mst;
    }

    public static void main(String[] args) {
        int n = 9;
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[0].add(new int[]{1, 4});
        graph[0].add(new int[]{7, 8});
        graph[1].add(new int[]{0, 4});
        graph[1].add(new int[]{7, 11});
        graph[1].add(new int[]{2, 8});
        graph[2].add(new int[]{1, 8});
        graph[2].add(new int[]{8, 2});
        graph[2].add(new int[]{5, 4});
        graph[2].add(new int[]{3, 7});
        graph[3].add(new int[]{2, 7});
        graph[3].add(new int[]{5, 14});
        graph[3].add(new int[]{4, 9});
        graph[4].add(new int[]{3, 9});
        graph[4].add(new int[]{5, 10});
        graph[5].add(new int[]{4, 10});
        graph[5].add(new int[]{3, 14});
        graph[5].add(new int[]{2, 4});
        graph[5].add(new int[]{6, 2});
        graph[6].add(new int[]{5, 2});
        graph[6].add(new int[]{7, 1});
        graph[6].add(new int[]{8, 6});
        graph[7].add(new int[]{0, 8});
        graph[7].add(new int[]{1, 11});
        graph[7].add(new int[]{8, 7});
        graph[7].add(new int[]{6, 1});
        graph[8].add(new int[]{2, 2});
        graph[8].add(new int[]{7, 7});
        graph[8].add(new int[]{6, 6});

        List<int[]> mst = prim(n, graph, 0);
        for (int[] edge : mst) {
            System.out.println(edge[0] + " - " + edge[1] + ": " + edge[2]);
        }
    }

    static class Edge implements Comparable<Edge> {
        int node;
        int weight;

        Edge(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge other) {
            return Integer.compare(this.weight, other.weight);
        }
    }
}