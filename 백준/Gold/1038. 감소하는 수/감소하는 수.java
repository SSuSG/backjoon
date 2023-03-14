import java.io.*;
import java.util.*;
public class Main {
	static int n,cnt=0;
	static long result=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		if(n > 9) {
			bfs();
			System.out.println(result);
		}else {
			System.out.println(n);
		}
	}
	
	static void bfs() {
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for (int i = 1; i <= 9; i++) {
			pq.offer((long) i);
		}
		
		while(!pq.isEmpty()) {
			long cur = pq.poll();
			cnt++;
			if(cnt == n) {
				result = cur;
				return;
			}
			
			String s = String.valueOf(cur);
			for (int i = 0; i < s.charAt(s.length()-1)-'0'; i++) {
				pq.offer(Long.parseLong(s+i));
			}
		}
		result = -1;
	}
}