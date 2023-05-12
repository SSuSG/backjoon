import java.util.*;
class Solution {
    static List<Integer> answer;
    static char[][] map;
    static List<int[]> l;
    static int[][] dirs = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    
    public List<Integer> solution(String[][] places) {
        answer = new ArrayList<>();
        
        for(int k = 0 ; k < 5 ; k++){
            map = new char[5][5];
            l = new ArrayList<>();
            for(int i = 0 ; i < 5 ; i++){
                for(int j = 0 ; j < 5 ; j++){
                    map[i][j] = places[k][i].charAt(j);
                    if(map[i][j] == 'P') l.add(new int[]{i,j});
                }
            }
            
            answer.add(solve());
        }
        return answer;
    }
    static int solve(){
        for(int[] p : l){
            boolean[][] isVisit = new boolean[5][5];
            isVisit[p[0]][p[1]] = true;
            
            ArrayDeque<int[]> q = new ArrayDeque<>();
            q.add(new int[]{p[0],p[1],0,0});
            
            while(!q.isEmpty()){
                int[] cur = q.poll();
                
                if(cur[2] == 1 && map[cur[0]][cur[1]] == 'P') return 0;
                if(cur[2] == 2 && map[cur[0]][cur[1]] == 'P' && cur[3] == 1) return 0;
                if(cur[2] == 2 ) continue;
                
                for(int[] dir : dirs){
                    int ny = cur[0] + dir[0];
                    int nx = cur[1] + dir[1];
                    
                    if(!isArea(nx,ny) || isVisit[ny][nx]) continue;
                    isVisit[ny][nx] = true;
                    if(map[ny][nx] == 'O'){
                        q.add(new int[]{ny,nx,cur[2]+1,1});
                    }else{
                        q.add(new int[]{ny,nx,cur[2]+1,cur[3]});
                    }
                }
            }
        }
        return 1;
    }
    
    static boolean isArea(int x, int y){
        if(x < 0 || y < 0 || x >= 5 || y >= 5) return false;
        return true;
    }
}