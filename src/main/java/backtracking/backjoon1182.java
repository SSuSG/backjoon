package backtracking;

import java.util.Scanner;

public class backjoon1182 {
    static int[] arr;
    static int n,s,cnt=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        s = sc.nextInt();
        arr = new int[n];
        for (int i = 0 ; i < n ; i++){
            arr[i] = sc.nextInt();
        }

        dfs(0 , 0);
        if(s == 0 ){
            System.out.println(cnt-1);
        }else{
            System.out.println(cnt);
        }
    }

    private static void dfs(int depth , int sum) {
        if(depth == n){
            if (sum == s)
                cnt++;
            return;
        }
        dfs(depth +1 , sum+arr[depth]);
        dfs(depth+1 , sum);
    }

}
