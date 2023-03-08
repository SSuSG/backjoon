import java.util.*;
import java.io.*;
public class Main {
	static int n,k,max=0;
	static int[] def = {0,2,8,13,19};
	static boolean[] alpha;
	static String[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		alpha = new boolean[26];
		arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = br.readLine();
		}
		
		if(k < 5) {
			System.out.println(0);
			return;
		}
		for (int i = 0; i < 5; i++) {
			alpha[def[i]] = true;
		}
		comb(5,0);
		System.out.println(max);
	}
	
	static void comb(int cnt,int start) {
		if(cnt == k) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				boolean isRead = true;
				String cur = arr[i];
				cur = cur.substring(4, cur.length()-4);
				
				for (int j = 0; j < cur.length(); j++) {
					if(!alpha[cur.charAt(j)-'a']) {
						isRead = false;
						break;
					}
				}
				if(isRead)
					sum++;
			}
			max = Math.max(max, sum);
			return;
		}
		
		for (int i = start; i < 26; i++) {
			if(alpha[i]) continue;
			
			alpha[i] = true;
			comb(cnt+1,i+1);
			alpha[i] = false;
		}
	}
}