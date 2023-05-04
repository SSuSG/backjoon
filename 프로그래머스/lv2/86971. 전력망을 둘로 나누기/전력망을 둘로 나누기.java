import java.util.*;
class Solution {
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        map = new int[n+1][n+1];

        for(int i = 0 ; i < wires.length ; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            map[from][to] = 1;
            map[to][from] = 1;
        }
        
        for(int i = 0 ; i < wires.length ; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            
            //선 하나 끊고
            map[from][to] = 0;
            map[to][from] = 0;
            
            //송전탑 개수 차이 세고
            bfs(n, from);
            
            //선 다시 연결
            map[from][to] = 1;
            map[to][from] = 1;
        }
        
        return min;
    }
    
    static void bfs(int n,int start){
        boolean[] isVisit = new boolean[n+1];
        
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(start);
        isVisit[start] = true;
        
        while(!q.isEmpty()){
            int cur = q.poll();
            
            for(int i = 1 ; i <= n ; i++){
                if(isVisit[i]) continue;
                if(map[cur][i] == 0) continue;
                
                q.offer(i);
                isVisit[i] = true;
            }
        }
        
        int sum = 0;
        for(int i = 1 ; i<=n ; i++){
            if(isVisit[i]) sum++;
        }
        int diff = Math.abs(sum - (n-sum));
        min = Math.min(min,diff);
    }
}