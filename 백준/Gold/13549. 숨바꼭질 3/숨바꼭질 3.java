import java.io.*;
import java.util.*;

public class Main {
	static int n,k,min=Integer.MAX_VALUE;
	static int[] distance = new int[100001];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        boolean[] isVisit = new boolean[100001];
        
        PriorityQueue<int[]> pq = new PriorityQueue<>( (o1,o2) -> o1[1] - o2[1]);
        pq.offer(new int[] {n,0});
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	isVisit[cur[0]] = true;
        	
        	if(cur[0] == k) {
        		min = Math.min(min, cur[1]);
        		break;
        	}
        	if(cur[0]*2 <= 100000 && !isVisit[cur[0]*2]){
                 pq.add(new int[]{cur[0]*2,cur[1]});
            }
        	if(cur[0] > 0 && !isVisit[cur[0]-1]){
                pq.add(new int[]{cur[0]-1,cur[1]+1});
            }
            if(cur[0] < 100000 && !isVisit[cur[0]+1]){
                pq.add(new int[]{cur[0]+1,cur[1]+1});
            }
        }
        System.out.println(min);
	}
}