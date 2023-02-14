import java.util.*;
import java.io.*;
public class Main {
	static int n;
	static int[] prime = {2,3,5,7};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        n = Integer.parseInt(st.nextToken());
        
        for (int i = 0; i < 4; i++)
        	findPrime(prime[i],1);
        System.out.println(sb);
	}
	
	static void findPrime(int prime,int cnt) {
		if(cnt == n) {
			sb.append(prime + "\n");
			return;
		}
		
		for (int i = 0; i < 10; i++) {
			if(i == 0 | i == 2 || i == 4 || i == 6 || i == 8)
				continue;
			if(isPrime(prime*10 + i))
				findPrime(prime*10 + i, cnt+1);
		}
	}
	
	static boolean isPrime(int num) {
		for (int i = 2; i < num/2; i++) {
			if(num%i == 0)
				return false;
		}
		return true;
		
	}
}