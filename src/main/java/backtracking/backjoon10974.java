package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class backjoon10974 {
    static int n;
    static int arr[];
    static boolean visit[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        arr = new int[n];
        bt(0);

    }

    private static void bt(int depth) {
        if(depth == n){
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }

        for (int i = 0; i < n ; i++) {
            if(!visit[i]){
                visit[i] = true;
                arr[depth] = i+1;
                bt(depth+1);
                visit[i] = false;
            }
        }
    }
}
