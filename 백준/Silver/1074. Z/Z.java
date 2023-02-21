import java.util.*;
import java.io.*;
public class Main {
	static int n,r,c;
	static int[][] map;
	static int cnt = 0;
	static boolean isContinue = true;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  =new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		map =new int[n][n];
		search(c, r,(int)Math.pow(2, n),0);
	}
	
	static void search(int x, int y,int n,int value) {
		if(n == 1) {
			System.out.println(value);
			return;
		}
		
		if(y < n/2 && x < n/2)
			search(x, y, n/2, value);
		else if(y < n/2 && n/2 <= x)
			search(x-n/2, y, n/2, value + (n*n/4));
		else if(n/2 <= y && x < n/2)
			search(x, y-n/2, n/2, value + (n*n/4*2));
		else 
			search(x-n/2, y-n/2, n/2, value + (n*n/4*3));
	}
}