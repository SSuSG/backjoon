import java.util.*;
import java.io.*;
public class Main {
	static String n;
	static int k,max=0;
	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		n = st.nextToken();
		k = Integer.parseInt(st.nextToken());
		dp = new int[k+1][1000001];
		 
		if(n.length() == 1)
			System.out.println(-1);
		else {
			dfs(1,Integer.parseInt(n),false);
			System.out.println(max == 0 ? -1 : max);
		}
	}
	
	static void dfs(int cnt,int num, boolean isStop) {
		if(cnt == k+1) {
			if(max < num)
				max = num;
			return;
		}
        
        if(isStop || dp[cnt][num] != 0)
			return;
        
		for (int i = 1; i < n.length() ; i++) {
			for (int j = i+1; j <= n.length(); j++) {
				int result;
				result = swap(i,j,num);
				if(result == 0) 
					dfs(cnt+1,result,true);
				else {
					dp[cnt][num]++;
					dfs(cnt+1,result,false);
				}
			}
		}
		
	}
	
	static int swap(int i,int j,int num) {
		int l = String.valueOf(num).length();
		
		if(num < 10)
			return 0;
		if(String.valueOf(num).charAt(l-i) == '0' && j == l)
			return 0;

		String temp = String.valueOf(num);
		char[] tempArr = temp.toCharArray();
		char cTemp = String.valueOf(num).charAt(l-i);
		tempArr[l-i] = tempArr[l-j];
		tempArr[l-j] = cTemp;
		
		return Integer.parseInt(String.valueOf(tempArr));
	}
}