package BfsDfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class backjoon1707_memory_over {

    static int v,e;
    static ArrayList<ArrayList<Integer>> graph;
    static int[] color;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        graph = new ArrayList<>();
        int t = Integer.parseInt(st.nextToken());

        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            color = new int[v];

            for (int j = 0; j < v; j++) {
                graph.add(new ArrayList<>());
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int x= Integer.parseInt(st.nextToken())-1;
                int y= Integer.parseInt(st.nextToken())-1;

                graph.get(x).add(y);
                graph.get(y).add(x);

            }

            for (int j = 0; j < v; j++) {
                if(color[j]==0){
                    boolean bfs = bfs(j);
                    if(!bfs)
                        break;
                }
            }

        }
        System.out.println(sb);
    }

    private static boolean bfs(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(node);
        color[node] = 1;

        while(!queue.isEmpty()){
            Integer temp = queue.poll();

            for (Integer n : graph.get(temp)) {
                if(color[n]==0){
                    queue.offer(n);
                    if(color[temp]==-1){
                        color[n] = 1;
                    }else{
                        color[n] = -1;
                    }
                }else if(color[n]==color[temp]){
                    sb.append("NO"+"\n");
                    return false;
                }
            }
        }
        sb.append("YES"+"\n");
        return true;
    }


}
