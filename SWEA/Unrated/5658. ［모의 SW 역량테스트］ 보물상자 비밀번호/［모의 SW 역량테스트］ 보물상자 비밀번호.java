import java.util.*;
import java.io.*;
public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
 
        for (int tc = 1; tc <= t; tc++) {
        	int result =0;
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			String[] input = br.readLine().split("");
			TreeSet<String> ts = new TreeSet<>(Collections.reverseOrder());
			for (int i = 0; i < n/4; i++) {
				//시계방향 회전
				String temp = input[n-1];
				for (int j = n-1; j > 0 ; j--) {
					input[j] = input[j-1];
				}
				input[0] = temp;
				
				for (int j = 0; j < n; j+=n/4) {
					StringBuilder tsb = new StringBuilder();
					for (int j2 = j; j2 < j+n/4; j2++) {
						tsb.append(input[j2]);
					}
					ts.add(tsb.toString());
				}
			}
			Iterator<String> it = ts.iterator();
			int cnt = 1;
			while(it.hasNext()) {
				if(cnt == k) {
					result = Integer.parseInt(it.next(),16);
					break;
				}
				it.next();
				cnt++;
			}
			
        	sb.append("#" + tc + " " + result + "\n");
		}
        System.out.println(sb);
	}
}