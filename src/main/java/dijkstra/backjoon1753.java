package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjoon1753 {

    static class Edge implements Comparable<Edge>{
        int end , cost;

        public Edge(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost-o.cost;
        }
    }

    static int v,e,k;
    static int[] dist;
    static ArrayList<Edge>[] adjList;
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        visit = new boolean[v+1];
        dist = new int[v+1];
        for (int i = 1; i <= v; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        adjList = new ArrayList[v+1];
        for (int i = 1; i <= v; i++) {
            adjList[i] = new ArrayList<Edge>();
        }

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[start].add(new Edge(end,weight));
        }

        dijkstra(k);
        StringBuilder sb = new StringBuilder();
        // 5. 전체 출력
        for (int i=1; i<=v; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                sb.append("INF\n");
            }
            else {
                sb.append(dist[i]+"\n");
            }
        }


    }

    private static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.add(new Edge(start,0));

        while (!pq.isEmpty()){
            Edge curEdge = pq.poll();
            int now = curEdge.end;

            if(!visit[now]){
                visit[now] = true;
                for (Edge edge : adjList[now]) {
                    if(dist[edge.end] > dist[now] + edge.cost){
                        dist[edge.end] = dist[now] + edge.cost;
                        pq.add(new Edge(edge.end, dist[edge.end]));

                    }
                }


            }



        }

    }
}
