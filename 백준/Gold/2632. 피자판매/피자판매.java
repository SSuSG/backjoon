import java.io.*;
import java.util.*;

public class Main {
	static int[] pizzaA,pizzaB;
	static int m,n,size;
	static List<Integer> subSumA = new ArrayList<>();
	static List<Integer> subSumB = new ArrayList<>();
	static boolean[] isVisit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());	
		
		size = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());	
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		
		pizzaA = new int[m];
		pizzaB = new int[n];
		
		for (int i = 0; i < m; i++) 
			pizzaA[i] = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) 
			pizzaB[i] = Integer.parseInt(br.readLine());
		
		//피자  A,B부분합 구하기 
		for (int i = 0; i < m; i++) {
			isVisit = new boolean[m];
			isVisit[i] = true;
			getSubSum(pizzaA[i] , i , i+1 , pizzaA,subSumA);
		}
		for (int i = 0; i < n; i++) {
			isVisit = new boolean[n];
			isVisit[i] = true;
			getSubSum(pizzaB[i] , i , i+1 , pizzaB,subSumB);
		}
		
		subSumA.add(0);
		subSumB.add(0);
		
		Collections.sort(subSumA);
		Collections.sort(subSumB);
		
		int aIdx = 0;
		int bIdx = subSumB.size()-1;
		int cnt = 0;
		while(aIdx < subSumA.size() &&  bIdx >= 0) {
			int aValue = subSumA.get(aIdx);
			int bValue = subSumB.get(bIdx);
			
			if(aValue + bValue == size) {
				int aCnt = 0;
				int bCnt = 0;
				
				while(aIdx < subSumA.size() && subSumA.get(aIdx) == aValue) {
					aIdx++;
					aCnt++;
				}
				
				while(bIdx >= 0 && subSumB.get(bIdx) == bValue) {
					bIdx--;
					bCnt++;
				}
				
				cnt += aCnt * bCnt;
			}else if(aValue + bValue < size) {
				aIdx++;
			}else {
				bIdx--;
			}
		}
		System.out.println(cnt);
	}
	
	//start ~ target-1 까지의 부분합 담기
	static void getSubSum(int sum , int startIdx , int targetIdx , int[] pizza , List subSum) {
		if(targetIdx == pizza.length)
			targetIdx = 0;
		
		subSum.add(sum);
		
		//start ~ target까지 부분합 구하기 
		if(!isVisit[targetIdx] && targetIdx != startIdx-1 && sum <= size) {
			isVisit[targetIdx] = true;
			getSubSum(sum + pizza[targetIdx] , startIdx , targetIdx+1 , pizza,subSum);
		}else {
			return;
		}
	}
}
