import java.io.*;
import java.util.*;
public class Main {
	static int n;
	static boolean isEnd = false;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 1; i <= 3; i++) {
			dfs(i+"");
		}
	}
	
	static void dfs(String s) {
		if(isEnd) return;
		
		if(s.length() == n) {
			System.out.println(s);
			isEnd = true;
			return;
		}
		
		for (int i = 1; i <= 3 ; i++) {
			if(isValid(s+i)) 
				dfs(s+i);
		}
	}
	
	static boolean isValid(String s) {
		for (int i = 1; i <= s.length()/2; i++) {
			String front = s.substring(s.length()-i-i, s.length()-i);
			String back = s.substring(s.length()-i);
			if(front.equals(back))
				return false;
		}
		return true;
	}
}