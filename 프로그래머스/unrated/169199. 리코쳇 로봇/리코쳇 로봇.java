import java.util.*;
class Solution {
    static char[][] map;
    static int[] start;
    static int[][] dirs = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    public int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        for(int i = 0 ; i < board.length ; i++){
            String temp = board[i];
            for(int j = 0 ; j < board[0].length() ; j++){
                map[i][j] = temp.charAt(j);
                if(map[i][j] == 'R') 
                    start = new int[]{i,j}; 
            }
        }
          
        return bfs();
    }
    
    static int bfs(){
        boolean[][] isVisit = new boolean[map.length][map[0].length];
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{start[0],start[1],0});
        isVisit[start[0]][start[1]] = true;
        
        //bfs돌려서 goal에 도착한게 최소시간
        while(!q.isEmpty()){
            int[] cur = q.poll();
            
            if(map[cur[0]][cur[1]] == 'G')
                return cur[2];
            
            for(int[] dir : dirs){
                int ny = cur[0] + dir[0];
                int nx = cur[1] + dir[1];
                
                //벽이나 장애물을 만날때까지
                while(isArea(nx,ny)){
                    ny += dir[0];
                    nx += dir[1];
                }
                ny -= dir[0];
                nx -= dir[1];
                
                if(isVisit[ny][nx]) continue;
                isVisit[ny][nx] = true;
                q.offer(new int[]{ny,nx,cur[2]+1});
            }
        }
        return -1;
    }
    static boolean isArea(int x, int y){
        if(x < 0 || y < 0 || x >= map[0].length || y >= map.length || map[y][x] == 'D') return false;
        return true;
    }
}