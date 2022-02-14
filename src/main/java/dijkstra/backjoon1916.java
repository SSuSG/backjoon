package dijkstra;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class backjoon1916 {
    static class Node{
        int idx; //노드의 현위치
        int cost; //해당 노드까지의 비용

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static int n ,m,startPoint,endPoint;
    static int[] dist;
    static boolean[] visit;
    static ArrayList<ArrayList<Node>> graph;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        dist = new int[n+1];
        visit = new boolean[n+1];

        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(start).add(new Node(end,cost));
        }
        st = new StringTokenizer(br.readLine());
        startPoint = Integer.parseInt(st.nextToken());
        endPoint = Integer.parseInt(st.nextToken());

        //dist[i] -> 출발지점에서 i까지의 최소비용
        for (int i = 1; i < n+1; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        //출발 지점 0
        dist[startPoint] = 0;

        //방문하지 않은 노드들(if문 사용)중 !!가장 비용이 적은 노드!!를 선택하기 위한 큐
        PriorityQueue<Node> queue = new PriorityQueue<>( (o1,o2) -> Integer.compare(o1.cost,o2.cost));
        //시작지점
        queue.offer(new Node(startPoint,0));

        while (!queue.isEmpty()){
            //현재 노드
            Node curNode = queue.poll();
            int cur = curNode.idx;

            //현재 노드를 방문한적이 없다면
            if(!visit[cur]){
                visit[cur] = true;
                //현재 노드로 부터 갈수있는 Node들을 꺼내어
                for (Node node : graph.get(cur)) {
                    //만약 현재 노드로 부터 갈수있는 노드가 방문한적없고 , 갈수있는 노드의 최소비용 > 현재 노드의 최소비용 + 현재노드와 갈수있는 노드사이의 비용
                    if(!visit[node.idx] && dist[node.idx] > dist[cur] + node.cost){
                        //해당 노드로 부터 갈수있는 노드들의 최소비용 갱신
                        dist[node.idx] = dist[cur] + node.cost;
                        //갱신해야 하는 주변 노드의수 = 우선 순위큐에 들어가는 노드의 수
                        queue.offer(new Node(node.idx, dist[node.idx]));
                    }
                }
            }

        }
        System.out.println(dist[endPoint]);

    }
}
