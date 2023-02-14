import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int[] tower;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		tower = new int[n+1];
		Stack<int[]> s = new Stack<>();
		
		st = new StringTokenizer(br.readLine());
		int idx = 1;
		for (int i = 1; i <= n; i++) {
			int var = Integer.parseInt(st.nextToken());

			while(!s.isEmpty()) {
				if(s.peek()[0] >= var) {
					sb.append(s.peek()[1] + " ");
					break;
				}
				s.pop();
			}
			if(s.isEmpty()) 
				sb.append(0 + " ");
			
			s.push(new int[] {var,idx++});
			
		}
		System.out.println(sb);
	}
	
}