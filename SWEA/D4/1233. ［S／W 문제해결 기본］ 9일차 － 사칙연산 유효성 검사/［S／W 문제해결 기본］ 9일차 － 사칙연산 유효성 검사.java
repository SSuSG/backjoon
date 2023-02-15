import java.io.*;
import java.util.*;
class Solution
{
	public static void main(String args[]) throws Exception
	{
		//System.setIn(new FileInputStream("res/input_d4_사칙연산.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;	
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= 10; tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			boolean check = true;
			sb.append("#" + tc + " ");
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				int nodeNum = Integer.parseInt(st.nextToken());
				char node = st.nextToken().charAt(0);
				
				if(st.hasMoreTokens()) {
					if( '0' <= node && node <= '9') 
						check = false;
					
				}else {
					if( node < '0' || node > '9') 
						check = false;
				}					
			}
			if(check)
				sb.append(1 + "\n");
			else
				sb.append(0 + " \n");		
		}
		System.out.println(sb);
	}
}