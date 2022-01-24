package backtracking;

import java.util.Scanner;

public class backjoon9663 {
    static int[] arr;
    static int n,cnt=0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        dfs(0);
        System.out.println(cnt);
    }

    public static void dfs(int depth){
        if(depth == n){
            cnt++;
            return;
        }

        for (int i=0 ; i<n ; i++){
            arr[depth] = i;
            if(possibility(depth)){
                dfs(depth+1);
            }
        }
    }

    private static boolean possibility(int col) {
        for (int i = 0 ; i< col ; i++){
            if(arr[col] == arr[i]){//같은 행에 있을경우
                return false;
            } else if(Math.abs(col-i) == Math.abs( arr[col] - arr[i] )){//대각선에 있는경우
                return false;
            }
        }
        return true;
    }

}
