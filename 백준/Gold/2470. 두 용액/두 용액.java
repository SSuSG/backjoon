import java.util.*;
import java.io.*;
public class Main {
	static int n,left,right;
	static int result=Integer.MAX_VALUE,resultLeft,resultRight;
	static int[] input;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		input = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		left = 0;
		right = n-1;

		while(left < right) {
			int sum = input[left] + input[right];
			if(result > Math.abs(sum)) {
				result = Math.abs(sum);
				resultLeft = input[left];
				resultRight = input[right];
			}
			
			if(sum > 0)
				right--;
			else
				left++;
		}
		
		System.out.println(resultLeft + " " + resultRight);
	}
}