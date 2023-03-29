import java.util.*;
import java.io.*;
public class Main {
	static int[][] map;
	static int n,min=Integer.MAX_VALUE;
	static boolean[] isVisit;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n= Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int[n+1][n+1];
		isVisit = new boolean[n+1];
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 1 ; i <= n ; i++) {
			isVisit[i] = true;
			dfs(i,i,0,1);
			isVisit[i] = false;
		}
		System.out.println(min);
	}
	
	static void dfs(int now , int end , int sum , int cnt) {
		if(cnt == n) {
			if(map[now][end] > 0) {
				min = Math.min(min, sum + map[now][end]);
			}
		}
		
		
		for (int i = 1; i <= n; i++) {
			if(!isVisit[i] && map[now][i] > 0) {
				isVisit[i] = true;
				dfs(i,end,sum + map[now][i] , cnt+1);
				isVisit[i] = false;
			}	
		}
		
	}
}