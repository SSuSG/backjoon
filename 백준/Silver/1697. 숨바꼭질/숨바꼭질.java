import java.io.*;
import java.util.*;

public class Main {
    static int n,k,min=Integer.MAX_VALUE;
    static boolean[] isVisit = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        bfs();
        System.out.println(min);
    }
    static void bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{n,0});
        isVisit[n] = true;

        while(!q.isEmpty()){
            int[] x = q.poll();
            if(x[0] == k)
                min = Math.min(min,x[1]);
            if(min < x[1])
                continue;

            if(x[0] > 0 && !isVisit[x[0]-1]){
                q.add(new int[]{x[0]-1,x[1]+1});
                isVisit[x[0]-1] = true;
            }
            if(x[0] < 100000 && !isVisit[x[0]+1]){
                q.add(new int[]{x[0]+1,x[1]+1});
                isVisit[x[0]+1] = true;
            }
            if(x[0]*2 <= 100000 && !isVisit[x[0]*2]){
                q.add(new int[]{x[0]*2,x[1]+1});
                isVisit[x[0]*2] = true;
            }

        }

    }
}