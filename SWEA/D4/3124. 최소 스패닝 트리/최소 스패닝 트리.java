import java.io.*;
import java.util.*;

public class Solution {
	 public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            ArrayList<Node>[] list = new ArrayList[n+1];
            boolean[] v = new boolean[n+1];

            for(int i = 0 ; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                list[from].add(new Node(to,weight));
                list[to].add(new Node(from,weight));
            }

            long result = 0; int cnt =0;
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.offer(new Node(1,0)); 	//정점,가중치

            while(!pq.isEmpty()) {
                Node cur = pq.poll();

                if(v[cur.v]) continue;

                v[cur.v] = true;
                result += cur.weight;

                if(cnt++ == n-1)
                    break;

                //가장 가까운 정점에서 주변으로 가는값들 최소값으로 초기화
                for(int i = 0; i < list[cur.v].size(); i++) {
                    Node next = list[cur.v].get(i);
                    if(v[next.v] == true) 
                        continue;
                    pq.add(next);
                }
            }
            sb.append("#" + tc + " " + result + "\n");
        }
        System.out.println(sb);
    }
    
    static class Node implements Comparable<Node>{
        int v;
        int weight;

        public Node(int x, int weight) {
            this.v = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.weight , o.weight);
        }

    }
}