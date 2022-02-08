package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class backjoon1946 {
    static int[][] rank;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int result =0;


            rank = new int[n][2];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                rank[j][0] = Integer.parseInt(st.nextToken());
                rank[j][1] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(rank, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[0] - o2[0];
                }
            });

            int prev = rank[0][1];
            result++;
            for (int j = 1; j < n; j++) {
                if(rank[j][1] < prev){
                    prev = rank[j][1];
                    result++;
                }
            }
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }
}
