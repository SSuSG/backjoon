import java.io.*;
import java.util.*;

public class Main {
	static int n,m,result;
	static int[] output = new int[3];
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		input = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) 
			 input[i] = Integer.parseInt(st.nextToken());
		
		comb(0,0);
		System.out.println(result);
	}
	
	static void comb(int cnt , int startIdx) {
		if(cnt == 3) {
			int sum = 0;
			for (int i = 0; i < output.length; i++) 
				sum += output[i];
			if(sum <= m && Math.abs(sum-m) < Math.abs(result-m) )
				result = sum;
			return;
		}
		
		for (int i = startIdx; i < n; i++) {
			output[cnt] = input[i];
			comb(cnt+1,i+1);
		}
	}
}