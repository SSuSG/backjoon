package backtracking;

import java.util.Scanner;

public class backjoon9663 {
    static boolean[][] visit;
    static int[] arr;
    static int n,cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        visit = new boolean[n][n];
        arr = new int[n];
        dfs(0,0);
        System.out.println(cnt);
    }

    public static void dfs(int num, int row ){
        if(num == n){ //
            cnt++;
            return;
        }

        for (int j = 0; j < n; j++) {
            arr[num] = j;
            if(possibility(row,j)){  // i,j 에 놓을수 있다면
                visit[row][j] = true;
                dfs(num+1,row+1);
                visit[row][j] = false;
            }
        }

    }

    public static boolean possibility(int i , int j){
        if(visit[i][j] == true)
            return false;


        for (int k = 0; k < n; k++) {
            if(k == i ){ // 가로
                if(visit[i][j] == true)
                    return false;
            }
        }

        for (int k = 0; k < n; k++) {
            if(k == j ){ // 가로
                if(visit[i][j] == true)
                    return false;
            }
        }

        for (int k = 0; k < n; k++) {
            if(Math.abs(j - k) == Math.abs(arr[j] - arr[k])){ //대각
                return false;
            }
        }

        return true;
    }
}
