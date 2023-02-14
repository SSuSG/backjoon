import java.io.*;
import java.util.*;

public class Main {
	static int r,c,k;
	static int time = 0;
	static int rowCount = 3, colCount = 3;
	static int[][] map = new int[101][101];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		r = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		for (int i = 1; i <= 3;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= 3; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		while(time <= 100) {
			if(checkResult()) {
				System.out.println(time);
				return;
			}
			
			if(rowCount >= colCount)
				rCalc();
			else
				cCalc();
			
			
			time++;
		}
		System.out.println(-1);
		
		
	}
	
	public static void rCalc() {
		//모든 행에 대해서 정렬
		List<MyMap> mapList;
		int maxColCount = 0;
		for (int i = 1; i <= rowCount; i++) {
			int[] count = new int[101];
			boolean[] check = new boolean[101];
			mapList = new ArrayList<>();
			for (int j = 1; j <= colCount; j++) {
				count[map[i][j]]++;
			}
			for (int j = 1; j <= colCount ; j++) {
				if(map[i][j] > 0 && !check[map[i][j]]) {
					check[map[i][j]] = true;
					mapList.add(new MyMap(map[i][j], count[map[i][j]]));
				}
			}
			Collections.sort(mapList);
			
			int k = 1;
			for (int j = 0; j < mapList.size(); j++) {
				MyMap temp = mapList.get(j);
				map[i][k++] = temp.key;
				map[i][k++] = temp.count;
				if(k >= 101)
					break;
			}
			for (int j = mapList.size()*2 + 1; j < 101; j++) {
				map[i][j] = 0;
			}
			
			if(maxColCount < k-1)
				maxColCount = k-1;
		}
		
		colCount = maxColCount;
	}
	
	public static void cCalc() {
		//모든 열에 대해서 정렬
		List<MyMap> mapList;
		int maxRowCount = 0;
		for (int i = 1; i <= colCount; i++) {
			int[] count = new int[101];
			boolean[] check = new boolean[101];
			mapList = new ArrayList<>();
			for (int j = 1; j <= rowCount; j++) {
				count[map[j][i]]++;
			}
			for (int j = 1; j <= colCount ; j++) {
				if(map[j][i] > 0 && !check[map[j][i]]) {
					check[map[j][i]] = true;
					mapList.add(new MyMap(map[j][i], count[map[j][i]]));
				}
			}
			Collections.sort(mapList);
			
			int k = 1;
			for (int j = 0; j < mapList.size(); j++) {
				MyMap temp = mapList.get(j);
				map[k++][i] = temp.key;
				map[k++][i] = temp.count;
				if(k >= 101)
					break;
			}
			
			for (int j = mapList.size()*2 + 1; j < 101; j++) {
				map[j][i] = 0;
			}
			
			if(maxRowCount < k-1)
				maxRowCount = k-1;
		}
		
		rowCount = maxRowCount;
	}
	
	public static boolean checkResult() {
		if(map[r][c] == k)
			return true;
		return false;
	}
	
	
	public static class MyMap implements Comparable<MyMap>{
		int key;
		int count;

		public MyMap(int key, int count) {
			this.key = key;
			this.count = count;
		}

		@Override
		public int compareTo(MyMap o) {
			if(this.count == o.count)
				return this.key - o.key;
			return this.count - o.count;
		}
	}
}