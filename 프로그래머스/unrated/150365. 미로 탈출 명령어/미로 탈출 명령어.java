import java.util.*;
class Solution {
    static boolean[][][] isVisit;
    static int[][] dirs = {
        {1,0},
        {0,-1},
        {0,1},
        {-1,0}
    };
    static List<String> answers = new ArrayList<>();
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        isVisit = new boolean[n+1][m+1][k+2];
        bfs(n,m,x,y,r,c,k);
        if(answers.size() == 0 ) return "impossible";
        return answers.get(0);
    }
    static void bfs(int n, int m, int x, int y, int r, int c, int k){
        ArrayDeque<command> q = new ArrayDeque<>();
        q.offer(new command(y,x,0,new StringBuilder("")));
        isVisit[x][y][0] = true;
        
        while(!q.isEmpty()){
            command cur = q.poll();
            if(cur.cnt> k) continue;
            if(cur.y == r && cur.x == c && cur.cnt == k){
                answers.add(cur.cmd.toString());
                return;
            }
            
            for(int d = 0 ; d < 4 ; d++){
                int ny = cur.y + dirs[d][0];
                int nx = cur.x + dirs[d][1];
                
                if(!isArea(n,m,nx,ny)) continue;
                if(isVisit[ny][nx][cur.cnt+1]) continue;
                isVisit[ny][nx][cur.cnt+1] = true;
                q.offer(new command(nx,ny,cur.cnt+1,new StringBuilder(cur.cmd).append(convertDir(d)) ));
            }
        }
    }
    static boolean isArea(int n, int m, int x, int y){
        if(x < 1 || y < 1 || x > m || y > n) return false;
        return true;
    }
    static char convertDir(int d) {
        if (d == 0) return 'd';
        if (d == 1) return 'l';
        if (d == 2) return 'r';
        return 'u';
    }
    static class command{
        int x;
        int y;
        int cnt;
        StringBuilder cmd;
        public command(int x , int y, int cnt, StringBuilder cmd){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.cmd = cmd;
        }
    }
}