import java.util.*;
import java.io.*;
public class Main {
	static int[][] ining;
	static int n,max=0;
	static int[] select = new int[10];
	static boolean[] isVisit = new boolean[10];
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        ining = new int[n+1][10];
        for (int i = 1; i <= n ; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j = 1; j <= 9 ; j++) {
				ining[i][j] = Integer.parseInt(st.nextToken());
			}
		}
        isVisit[1] = true;
        select[4] = 1;
		
        perm(1);
        System.out.println(max);
	}
	
	static void perm(int cnt) {
		if(cnt == 4) {
			perm(cnt+1);
			return;
		}
		
		if(cnt == 10) {
			//1이닝 부터 야구 시작
			baseball(1,1,0);
			return;
		}
		
		for (int i = 2; i <= 9; i++) {
			if(isVisit[i]) 
				continue;
			isVisit[i] = true;
			select[cnt] = i;
			perm(cnt+1);
			isVisit[i] = false;
		}
	}
	
	static void baseball(int ini , int idx,int sum) {
		if(ini == n+1) {
			if(max < sum) 
				max = sum;
			return;
		}
		
		int out = 3;
		int one = 0;
		int two = 0;
		int three = 0;
		int batter;
		
    	while(out > 0) {  
    		batter = select[idx++];
    		
    		//1 or 2 or 3 or 홈런 or 아웃
    		int result = ining[ini][batter];
    		if(result == 0) {
    			out--;
    		}else if(result == 1) {
    			sum += three;
    			three = 0;
    			three = two;
    			two = 0;
    			two = one;
    			one = 0;
    			one++;
    			
    		}else if(result == 2) {
    			sum += (three+two);
    			three = 0;
    			two = 0;
    			three = one;
    			one = 0;
    			two++;
    			
    		}else if(result == 3) {
    			sum += (one+two+three);
    			three = 0;
    			two = 0;
    			one = 0;
    			three++;
    			
    		}else if(result == 4) {
    			sum += (one+two+three+1);
    			three = 0;
    			two = 0;
    			one = 0;
    		}
    		if(idx == 10)
				idx = 1;
    	}
    	
    	baseball(ini+1, idx, sum);
	}
}