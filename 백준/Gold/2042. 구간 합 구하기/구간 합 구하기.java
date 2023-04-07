import java.util.*;
import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		long arr[] = new long[n+1];
		long tree[] = new long[n+1];
		
		for (int i = 1; i <= n; i++) {
			arr[i] = Long.parseLong(br.readLine());
			update(tree,i,arr[i]);
		}
		m += k;
		while(m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			//b(1 ≤ b ≤ N)번째 수를 c로 바꾸고
			if(a == 1) {
				long diff = c-arr[b];
				arr[b] = c;
				//누적된 배열 truee에 diff만큼 더해준다.
				update(tree,b,diff);
				
			}else if(a == 2) {
			//b(1 ≤ b ≤ N)번째 수부터 c(b ≤ c ≤ N)번째 수까지의 합을 구하여 출력
				sb.append(sum(tree,(int)c) - sum(tree,b-1) + "\n");
			}
		}
		System.out.println(sb);
	}
	
	// ex : 5~15의 구간합
	// 8 + 12 + 14 + 15 - 4
	// 1000 + 1100 + 1110 + 1111 - 100
	//1이 있는 가장 오른쪽(최하위 비트)가 0으로 바꾼다
	//0보다 크면 계속 더한다.
	//arr 의 1~i 까지의 구간합을 구해준다.
	static long sum(long[] tree , int i) {
		long answer =  0;
		while(i > 0) {
			answer += tree[i];
			i -= (i & -i); //최하위 비트 지우기
		}
		return answer;
	}
	
	//1번 인덱스를 업데이트 하려면 1, 1-2, 1-4, 1-8, 1-16의 부분을 업데이트
	// -> 1 , 10 , 100 , 1000 , 10000 
	//1이 있는 가장 오른쪽 최하위 비트에 1을 더해가면 update가 가능하다.
	//ex : 5번 인덱스에 diff 10이 들어온다면
	//101 -> 110 -> 1100 -> 10000 에 업데이트가 일어난다.
	//업데이트가 일어나는 인덱스에 값이 누적된다.
	static void update(long[] tree , int i , long diff) {
		while(i < tree.length) {
			tree[i] += diff;
			i += (i & -i);
		}
	}
}