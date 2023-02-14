import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	public static int arr[];
    public static boolean isVisit[];
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isVisit = new boolean[n];

        dfs(0);
        System.out.println(sb);

    }

    private static void dfs(int depth) {
        if(m == depth){
            for (int i : arr) 
                sb.append(i +" ");
            sb.append("\n");
            return;
        }

        for(int i = 0; i < n ; i++){
            if(isVisit[i] == false){
            	isVisit[i] = true;
                arr[depth] = i+1;
                dfs(depth+1);
                isVisit[i] = false;
            }
        }
    }
}