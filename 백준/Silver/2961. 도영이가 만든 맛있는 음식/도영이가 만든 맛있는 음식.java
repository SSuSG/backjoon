import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static Ingredient[] ingredients;
	static boolean[] isUsed;
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		ingredients = new Ingredient[n];
		isUsed = new boolean[n];
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			ingredients[i] = new Ingredient(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		}
		
		for (int i = 0; i < n; i++) 
			selectIngredient(0,i+1,0);
		
		System.out.println(min);
	}
	
	static void selectIngredient(int cnt , int targetCnt , int startIdx) {
		if(cnt == targetCnt) {
			int sSum = 1;
			int bSum = 0;
			for (int i = 0; i < n; i++) {
				if(!isUsed[i])
					continue;
				sSum *= ingredients[i].s;
				bSum += ingredients[i].b;
			}
			
			if(min > Math.abs(sSum-bSum) )
				min = Math.abs(sSum-bSum);
			return;
		}
		
		for (int i = startIdx; i < n; i++) {
			if(isUsed[i])
				continue;
			
			isUsed[i] = true;
			selectIngredient(cnt+1, targetCnt , i+1);
			isUsed[i] = false;
		}
		
	}
	
	static class Ingredient{
		int s;
		int b;

		public Ingredient(int s, int b) {
			this.s = s;
			this.b = b;
		}
	}
}