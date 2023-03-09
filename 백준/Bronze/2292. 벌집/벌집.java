import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int cnt = 1;
		int minus = 6;
		while(true) {
			if(n <= 1)
				break;
			
			n -= minus;
			minus += 6;
			cnt++;
		}
		System.out.println(cnt);
	}
}