import java.util.*;
class Solution {
    static int[] p;
    static int bridgeCnt;
    static boolean[] isVisit;
    
    static class Edge{
        int from;
        int to;
        int w;
        
        public Edge(int from, int to ,int w){
            this.from = from;
            this.to = to;
            this.w = w;
        }  
    }
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        bridgeCnt = costs.length;
        p = new int[n+1];
        Edge[] edges = new Edge[costs.length];
        for(int i = 0 ; i < costs.length ; i++){
            edges[i] = new Edge(costs[i][0] , costs[i][1] , costs[i][2]);
        }
        Arrays.sort(edges , (e1,e2) -> e1.w - e2.w );
        make(n);
        //최소 가중치
        int result =0 ;
        //연결한 섬의 수
        int cnt = 0;
        for(Edge edge : edges){
            if(union(edge.from , edge.to)){
                result += edge.w;
                if(++cnt == n-1)
                    break;
            }
        }
        return result;
    }
    
    
    static void make(int n){
        for(int i = 1 ; i <= n ; i++){
            p[i] = i;
        }
    }
    static boolean union(int a,int b){
        int aP = find(a);
        int bP = find(b);
        
        if(aP == bP) return false;
        p[bP] = aP;
        return true;
    }
    static int find(int a){
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }
}