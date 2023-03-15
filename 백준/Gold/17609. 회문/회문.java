import java.io.*;
import java.util.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int result = solve(br.readLine());
			if(result == 0)
				sb.append(0+"\n");
			else if(result == 1)
				sb.append(1+"\n");
			else
				sb.append(2+"\n");
		}
		System.out.println(sb);
	}
	
	static int solve(String s) {
		int left = 0;
		int right = s.length()-1;
		
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) {
				String temp1 = s.substring(0,left) + s.substring(left+1);
				String temp2 = s.substring(0,right) + s.substring(right+1);
				if(isPalindrom(temp1) || isPalindrom(temp2))
					return 1;
				else if(!isPalindrom(temp1) || !isPalindrom(temp2))
					return 2;
			}
			left++;
			right--;
		}
		
		return 0;
	}
	
	static boolean isPalindrom(String s) {
		int left = 0;
		int right = s.length()-1;
		
		while(left < right) {
			if(s.charAt(left) != s.charAt(right)) 
				return false;
			
			left++;
			right--;
		}
		
		return true;
	}
}