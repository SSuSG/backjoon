import java.io.*;
import java.util.*;

public class Solution {
	static int n,min;
	static int[][] map;
	static boolean[] isVisit;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		//System.setIn(new FileInputStream("res/input_요리사.txt"));
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;	
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			min = Integer.MAX_VALUE;
			map = new int[n+1][n+1];
			isVisit = new boolean[n+1];
			for (int j = 1; j <= n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 1; k <= n; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			selectFood(0,1);
			sb.append("#" + i + " " + min + "\n");
		}
		
		System.out.println(sb);
	}
	//재료 선택
	static void selectFood(int cnt , int idx) {
		if(cnt == n/2) {
			int aSum =0;
			int bSum =0;
			for (int i = 1; i <= n; i++) {
				for (int j = i+1; j <= n; j++) {
					if(isVisit[i] && isVisit[j])
						aSum += (map[i][j] + map[j][i]);
					if(!isVisit[i] && !isVisit[j])
						bSum += (map[i][j] + map[j][i]);
					
				}
			}
			int diff = Math.abs(aSum-bSum);
			//음식 맛의 차이
			if(min > diff)
				min = diff;
			
			return;
		}
		
		for (int i = idx; i <= n; i++) {
			if(isVisit[i])
				continue;
			
			isVisit[i] = true;
			selectFood(cnt+1 , i+1);
			isVisit[i] = false;
		}
	}
}