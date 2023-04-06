import java.util.*;
class Solution {
    static int answer = Integer.MAX_VALUE;
    static boolean[][] isFulfill,isVisit;
    static int[][] dirs = {
        {-1,-1},
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
    };
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        isFulfill = new boolean[102][102];
        isVisit = new boolean[102][102];
        for(int i = 0 ; i < rectangle.length ; i++){
            //좌측 하단 x, 좌측 하단 y, 우측 상단 x, 우측 상단 y
            for(int y1 = rectangle[i][1]*2 ; y1 <= rectangle[i][3]*2 ; y1++){
                for(int x1 = rectangle[i][0]*2 ; x1 <= rectangle[i][2]*2 ; x1++){
                    isFulfill[y1][x1] = true;
                }
            }
        }
        
        isVisit[characterY*2][characterX*2] = true;
        dfs(0,characterX*2,characterY*2,itemX*2,itemY*2);
        
        return answer/2;
    }
    
    static void dfs(int cnt ,int curX , int curY , int itemX, int itemY){
        if(answer < cnt) return;
        if(curX == itemX && curY == itemY){
            answer = Math.min(answer,cnt);
            return;
        }
        
        for(int d = 1 ; d < 8 ; d+=2){
            int ny = curY + dirs[d][0];
            int nx = curX + dirs[d][1];
            
            if(!isMove(nx,ny)) continue;
            isVisit[ny][nx] = true;
            dfs(cnt+1,nx,ny,itemX,itemY);
            isVisit[ny][nx] = false;
        }
        
    }
                    
    static boolean isMove(int x, int y){
        if(x < 1 || y < 1 || x > 100 || y > 100 || !isFulfill[y][x] || isVisit[y][x])
            return false;
        
        boolean isValid = false;
        for(int d = 0 ; d < 8 ; d++){
            if(!isFulfill[y+dirs[d][0]][x+dirs[d][1]]) isValid = true;
        }
        if(!isValid) return false;
        return true;
    }
}