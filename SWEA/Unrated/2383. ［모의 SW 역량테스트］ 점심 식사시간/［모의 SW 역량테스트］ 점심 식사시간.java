import java.io.*;
import java.util.*;
public class Solution {
	static List<int[]> people;
	static List<int[]> stair;
	static int n,min;
	static int[][] map;
	//특정 사람이 선택한 계단
	static int[] output;
	//특정 사람이 계단까지 가고 계단에서 나가기 까지의 시간
	//사람과 계단사이의 거리 + 계단의 값 + 1
	static int[] time;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb  = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		
		for (int tc = 1; tc <= t; tc++) {
			min = Integer.MAX_VALUE;
			people = new ArrayList<>();
			stair = new ArrayList<>();
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(map[i][j] == 1) {
						people.add(new int[] {i,j});
					}else if(map[i][j] > 1) {
						stair.add(new int[] {i,j,map[i][j]});
					}
				}
			}
			output = new int[people.size()];
			comb(0,0);
			sb.append("#" + tc + " " + min + "\n");
		}
		System.out.println(sb);
	}
	
	//모든 사람이 모든 계단에 대해 갈수있는 경우의수 체크(중복조합)
	static void comb(int cnt , int start) {
		if(cnt == people.size()) {
			time = new int[people.size()];
			int max = 0;
			List<int[]> list = new ArrayList<>();
			List<ArrayDeque<Integer>> stairQ = new ArrayList<>();
			for (int j = 0; j < stair.size(); j++) {
				stairQ.add(new ArrayDeque<>());
			}
			for (int i = 0; i < output.length; i++) {
				//계단까지의 거리가 짧은순으로 정렬?
				//짧은순서로 먼저 계단에 들어가고 
				// 몇번째사람인지 , 몇번째 계단인지 , 계단까지의 거리
				list.add(new int[] {i,output[i],Math.abs(people.get(i)[0]-stair.get(output[i])[0]) + Math.abs(people.get(i)[1]-stair.get(output[i])[1])});
			}
			Collections.sort(list , new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					//같은 계단이라면
					if(o1[1] == o2[1]) {
						//거리 짧은 순서로
						return o1[2]-o2[2];
					}
					return o1[1] - o2[1];
				}
			});
			for (int[] tmp : list) {
				int p = tmp[0];
				int s = tmp[1];
				int d = tmp[2];
				
				ArrayDeque<Integer> q = stairQ.get(s);
				if(q.size() < 3) {
					q.offer(d + stair.get(s)[2] + 1);
				}else if(q.size() == 3){
					int endTime = q.peek();
					if(endTime > d ) {
						q.poll();
						q.offer(endTime+stair.get(s)[2]);
					}else {
						q.poll();
						q.offer(d + stair.get(s)[2]+1);
					}
				}
			}
			
			for (ArrayDeque<Integer> tq : stairQ) {
				while(!tq.isEmpty()) {
					max = Math.max(max, tq.poll());
				}
			}
			min = Math.min(min, max);
			return;
		}
		
		
		for (int i = start; i < stair.size(); i++) {
			//cnt번째 사람은 i번째 계단을 선택하겠다.
			output[cnt] = i;
			comb(cnt+1,start);
		}
	}
}