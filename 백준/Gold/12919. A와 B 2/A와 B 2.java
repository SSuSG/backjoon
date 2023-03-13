import java.util.*;
import java.io.*;
public class Main {
	static boolean doit;
	static String s,t;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		s = br.readLine();
		t = br.readLine();
		dfs(new String(t));
		System.out.println(doit ? 1 : 0);
	}
	
	static void dfs(String k) {
		if(doit) return;
		if(k.length() == s.length()) {
			if(k.equals(s)) 
				doit = true;
			return;
		}

		if(k.charAt(0) == 'B') {
			String temp = k.substring(1);
			StringBuilder sb = new StringBuilder(temp);
			dfs(sb.reverse().toString());
		}
		
		if(k.charAt(k.length()-1) == 'A') {
			String temp = k.substring(0,k.length()-1);
			dfs(temp);
		}
	}
}