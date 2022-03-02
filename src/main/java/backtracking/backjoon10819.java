package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class backjoon10819 {
    static int n;
    static int arr[];
    static int temp[];
    static boolean visited[];
    static int max =0;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        temp = new int[n];
        visited = new boolean[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bfs(0);
        System.out.println(max);
    }

    private static void bfs(int depth) {
        if(depth == n){
            int sum = 0;
            for (int i = 0; i < n-1; i++) {
                sum += Math.abs(temp[i+1]-temp[i]);
            }
            if(max < sum)
                max = sum;
        }

        for (int i = 0; i < n; i++) {
            if(!visited[i]){
                visited[i] = true;
                temp[depth] = arr[i];
                bfs(depth+1);
                visited[i] = false;
            }
        }
    }
}
