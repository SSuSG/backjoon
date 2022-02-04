package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon14889 {
    static int[][] s;
    static int min = Integer.MAX_VALUE;
    static int n;
    static boolean[] enter;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        s = new int[n+1][n+1];
        enter = new boolean[n+1];

        for (int i = 1 ; i <=n  ; i++ ){
            st =  new StringTokenizer(br.readLine());
            for (int j = 1 ; j <= n ; j++){
                s[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        check(1,0);
        System.out.println(min);
    }

    private static void check(int idx , int enterNum) {
        if(enterNum == n/2){
            // 최솟값 찾기
            diff();
            return;
        }

        for (int i = idx ; i <= n ; i++){
            if(!enter[i]){
                enter[i] = true;
                check(i+1 , enterNum + 1);
                enter[i] = false;
            }
        }
    }

    private static void diff() {
        int start = 0 ;
        int link = 0;

        for (int i = 1 ; i < n ; i++){
            for (int j = i+1; j <= n ; j++){
                if(enter[i] == true && enter[j] == true){
                    start += s[i][j];
                    start +=  s[j][i];
                }else if(enter[i] == false && enter[j] == false){
                    link += s[i][j];
                    link +=  s[j][i];
                }
            }
        }
        int val = Math.abs(start - link);
        if(val == 0){
            System.out.println(val);
            System.exit(0);
        }

        min = Math.min(val , min);
    }
}
