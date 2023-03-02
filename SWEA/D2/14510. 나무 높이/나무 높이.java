import java.io.*;
import java.util.*;
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        
        for (int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int max = 0;
			int oneCnt = 0; 
			int twoCnt = 0;
			int [] tree = new int[n];
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				tree[i] = Integer.parseInt(st.nextToken());
				if(max < tree[i])
					max = tree[i];
			}
			
			for (int i = 0; i < n; i++) {
				oneCnt += (max-tree[i])%2;
				twoCnt += (max-tree[i])/2;
			}
			
			while(twoCnt - oneCnt > 1) {
				twoCnt -= 1;
				oneCnt += 2;
			}
			
			if(twoCnt == oneCnt)
				sb.append("#" + tc + " " + (twoCnt + oneCnt) +"\n");
			else if(twoCnt > oneCnt)
				sb.append("#" + tc + " " + (twoCnt*2) +"\n");
			else if(twoCnt < oneCnt)
				sb.append("#" + tc + " " + (oneCnt*2-1) +"\n");
			
		}
        System.out.println(sb);
	}
}