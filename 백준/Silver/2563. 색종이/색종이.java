import java.io.*;
import java.util.*;

public class Main{
	static int n,sum=0;
	static boolean[][] isVisit = new boolean[100][100];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			fulfill(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		calc();
		System.out.println(sum);
	}
	
	static void fulfill(int x, int y) {
		for (int i = y; i < y+10  ; i++) {
			for (int j = x; j < x+10 ; j++) {
				isVisit[i][j] = true;
			}
		}
	}
	
	static void calc() {
		for (int i = 0; i < 100  ; i++) {
			for (int j = 0; j < 100 ; j++) {
				if(isVisit[i][j])
					sum++;
			}
		}
	}
}