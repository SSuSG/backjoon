package brutforce;

import java.util.LinkedList;
import java.util.Queue;

public class asd {
    static char[][] grid = {
            { '1' , '0' , '1' , '1' , '0'},
            { '1' , '1' , '0' , '0' , '0'},
            { '0' , '1' , '1' , '0' , '0'},
            { '0' , '0' , '0' , '1' , '1'}
    };

    static int[][] dirs = {
            { -1 ,0 },
            { 1 , 0 },
            { 0 , -1},
            { 0 , 1}
    };
    static int m , n , max=0;
    public static void main(String[] args) {


        m = grid.length;
        n= grid[0].length;


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int temp = 0;
                if(grid[i][j]=='1'){
                    temp = bfs(grid, i, j, temp);
                    if(max < temp)
                        max = temp;
                }
            }
        }
        System.out.println("max = " + max);
    }

    private static int bfs(char[][] grid , int x , int y , int temp) {
        grid[x][y] = 'X';
        temp++;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,y});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            for (int[] dir : dirs) {
                int x1 = cur[0] + dir[0];
                int y1 = cur[1] + dir[1];

                if(x1 >=0 && y1 >=0 && x1 < m && y1 < n &&grid[x1][y1] == '1'){
                    grid[x1][y1] = 'X';
                    temp++;
                    queue.offer(new int[] {x1,y1});
                }
            }

        }
        return temp;

    }
}
