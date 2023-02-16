import java.io.*;
import java.util.*;

public class Main {
	static int n,k,max = 0;
	static int[] input;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		input = new int[n];
		
		int sum = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, input[i]);
			sum += input[i];
			
		}
		k = Integer.parseInt(br.readLine());
		
		if(sum <= k) 
			System.out.println(max);
		else 
			System.out.println(upperBound(1, max));
		
	}
	
	static int upperBound(int low , int high) {
		while(low < high) {
			int mid = (low+high)/2;
			int sum = 0;
			for (int i = 0; i < n; i++) {
				if(input[i] <= mid)
					sum += input[i];
				else
					sum += mid;
			}
			
			if(sum <= k) {
				low = mid + 1;
			}else {
				high = mid;
			}
		}
		return low-1;
	}
}