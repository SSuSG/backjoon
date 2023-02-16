import java.io.*;
import java.util.*;
public class Solution {
	static  int n,l,max;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input_햄버거.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for (int tc = 1; tc <= t; tc++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
			max = 0;
			arr = new int[n][2];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 1; i <= n ; i++) {
				comb(0,0,i);
			}
			
			
			sb.append("#" + tc + " " + max + "\n");
		}
		System.out.println(sb);
	}
	
	static void comb(int cnt , int jumsu , int cal) {
		if(cnt == n) {
			if(cal <= l && max < jumsu)
				max = jumsu;
			return;
		}
		if(cal+arr[cnt][1] <= l)
			comb(cnt+1,jumsu+arr[cnt][0],cal+arr[cnt][1]);
		comb(cnt+1,jumsu,cal);
	}
}