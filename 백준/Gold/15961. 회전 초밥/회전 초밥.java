import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int max = 0;
		
		int[] arr = new int[n+1];
		HashMap<Integer,Integer> sushi = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		int left = 1;
		int right = k;
		for (int i = 1; i <= k; i++) 
			sushi.put(arr[i], sushi.getOrDefault(arr[i], 0)+1);
		if(sushi.containsKey(c))
			max = sushi.size();
		else
			max = sushi.size()+1;
		
		int count = right;
		right++;
		while(count < n+k) {
			if(right>n)
				right = 1;
			
			if(right - left == k || n-left+right == k) { 
				if(sushi.get(arr[left]) == 1) 
					sushi.remove(arr[left]);
				else 
					sushi.put(arr[left], sushi.get(arr[left])-1);
				
				left++;
			}
			sushi.put(arr[right], sushi.getOrDefault(arr[right], 0)+1);
			right++;
			count++;
			
			if(sushi.containsKey(c))
				max = Math.max(max, sushi.size());
			else
				max = Math.max(max, sushi.size()+1);
			
		}
		
		System.out.println(max);
	}
}