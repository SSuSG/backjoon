package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon1987 {
    static int r,c,max;
    static char[][] board;
    static boolean[] alpha;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        max =0;
        alpha = new boolean[26];
        board = new char[r][c];
        for (int i = 0 ; i < r ; i++){
            st  = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for (int  j = 0 ; j < c ; j++){
                board[i][j] = s.charAt(j);
            }
        }
        check(0,0 , 1);
        System.out.println(max);

    }

    private static void check(int i , int j , int walk) {
        if (i >= r || j >= c || i < 0 || j < 0)
            return;

        //만약 방문한적이 없는 알파벳이라면
        if(alpha[board[i][j]-65] == false){
            alpha[board[i][j]-65] = true;
            check(i+1,j ,walk+1);
            check(i-1,j ,walk+1);
            check(i,j-1 ,walk+1);
            check(i,j+1,walk+1);
            alpha[board[i][j]-65] = false;
        }else{
            if(max < walk-1)
                max = walk-1;
        }

    }
}
