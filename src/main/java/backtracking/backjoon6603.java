package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class backjoon6603 {
    static boolean[] visit;
    static int[] arr;
    static StringBuilder sb;
    static int k;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        sb = new StringBuilder();
        while(true){

            st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;

            arr = new int[k];
            visit = new boolean[k];
            for (int i = 0 ; i < k ; i ++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            bt(0 , 0 );
            sb.append('\n');
        }

        System.out.println(sb);
    }

    private static void bt(int idx , int val) {
        if(val == 6 ){
            for (int i = 0 ; i < k ; i++){
                if(visit[i]){
                    sb.append(arr[i]+" ");
                }
            }
            sb.append('\n');
        }

        for (int i = idx ; i < k ; i++){
            if(!visit[i]){
                visit[i] = true;
                bt(i+1 , val+1);
                visit[i] = false;
            }

        }
    }
}
