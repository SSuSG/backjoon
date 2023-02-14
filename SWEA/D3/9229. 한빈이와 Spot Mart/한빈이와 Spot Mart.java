import java.io.*;
import java.util.*;

class Solution
{
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/input_d3_과자.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(st.nextToken());
		
		for (int tc = 0; tc < t; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int[] snack = new int[n];
			int max = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				snack[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(snack[i] + snack[j] <= m&& max < snack[i] + snack[j])
						max = snack[i] + snack[j];
				}
			}
			
			sb.append("#" + (tc+1) + " " + (max == 0 ? -1 : max) + "\n");
		}
		System.out.println(sb);
	}
}