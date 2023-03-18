import java.util.*;
class Solution {
    static int n,m;
    static char[][] map;
    static boolean[][] isVisit;
    static int[][] dirs = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    
    public int solution(String[] maps) {
        int answer = -1;
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        int[] start = new int[]{0,0};
        int[] lever = new int[]{0,0};
        int[] end = new int[]{0,0};
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S')
                    start = new int[]{i,j};
                if(map[i][j] == 'E')
                    end = new int[]{i,j};
                if(map[i][j] == 'L')
                    lever = new int[]{i,j};
            }
        }
        
        int startToLever = bfs(start,lever);
        if(startToLever != 0){
            int leverToEnd = bfs(lever,end);
            if(leverToEnd != 0)
                answer += startToLever + leverToEnd + 1;
        }
        return answer;

    }
    
    static int bfs(int[] start , int[] end){
        isVisit = new boolean[n][m];
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1,o2) -> o1[2]-o2[2]);
        pq.offer(new int[]{start[0],start[1],0});
        isVisit[start[0]][start[1]] = true;
        int cnt = 0;
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            
            if(cur[0] == end[0] && cur[1] == end[1]){
                cnt += cur[2];
                break;
            }
            
            for(int[] dir : dirs){
                int ny = cur[0] + dir[0];
                int nx = cur[1] + dir[1];
                
                if(nx >= 0 && ny >= 0 && nx < m && ny < n && !isVisit[ny][nx] && map[ny][nx] != 'X'){
                    pq.offer(new int[]{ny,nx,cur[2]+1});
                    isVisit[ny][nx] = true;
                }
            }
        }
        return cnt;
    }
    
}