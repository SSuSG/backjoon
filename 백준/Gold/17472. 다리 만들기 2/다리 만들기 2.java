import java.io.*;
import java.util.*;

public class Main {
	static int n,m;
	static int islandCount = 2;		//map[y][x] == 1인 경우는 땅이므로 섬 번호는 2번 부터 시작 
	static int[][] map;
	static boolean[][] isVisit;
	static int min = Integer.MAX_VALUE;
	static List<Bridge> bridgeList = new ArrayList<>();
	static int[][] dirs = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
    };
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        map = new int[n][m];
        
        for (int i = 0; i < n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //맵 넘버링 , 섬 번호는 2부터 시작 
        mapNumbering();

        //모든 가능한 다리 구하기 -> 섬인곳에서 동,서,남,북으로 진행해서 다른 섬이 있는지 확인
        //시작과 끝이 같으면 같은 다리 -> equals정의
        getBridgeList();

        //가능한 다리중 선택을 해서 모든 섬이 연결되는 경우를 구하고
        // 최소 n-1개 선택 ~ 최대 만들어진 다리수 만큼 선택
        selectBridge();
        
        //모두 연결될 경우 이때 다리 길이의 합을 구해서 최솟값을 구한다.
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}
	
	//모든 가능한 다리 구하기
	static void getBridgeList() {
		for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
            	if(map[i][j] >= 2) {
            		getBridge(j,i);
            	}
            }
        }
	}
	
	static void getBridge(int x , int y) {
		//동,서,남,북 체크
		for (int[] dir : dirs) {
			int ny = y + dir[0];
			int nx = x + dir[1];
			if(!isArea(nx,ny))
				continue;
			
			int cnt = 0;
			
			while(map[ny][nx] == 0) {
				cnt++;
				ny += dir[0];
				nx += dir[1];
				if(!isArea(nx,ny))
					break;
				
				if(map[ny][nx] >= 2) {
					if(cnt < 2)
						break;
					Bridge bridge = new Bridge(cnt, new int[] {y,x}, new int[] {ny,nx} ,map[y][x], map[ny][nx]);
					if(!bridgeList.contains(bridge))
						bridgeList.add(bridge);
					break;
				}
			}
		}
	}
	
	//다리 선택 
	static void selectBridge() {
		//i개를 선택하겠다 , 모든 섬을 연결하려면 최소한 섬갯수-1(=islandCount-3)의 다리는 필요함
		for (int i = islandCount-3; i <= bridgeList.size(); i++) {
			int[] output = new int[i];
			comb(0,i,0,output);
		}
	}
	
	//사용할 다리 선택
	static void comb(int cnt , int selectBridgeNum, int startIdx , int[] output) {
		if(selectBridgeNum == cnt) {
			ArrayList<List<Integer>> bridgeConnectionList = new ArrayList<>();
			for (int i = 0; i < islandCount-2; i++) 
				bridgeConnectionList.add(new ArrayList<>());
			
			//선택한 다리를 놓고 섬을 연결
			for (int i = 0; i < output.length; i++) {
				Bridge bridge = bridgeList.get(output[i]);
				bridgeConnectionList.get(bridge.startIsland-2).add(bridge.endIsland-2);
				bridgeConnectionList.get(bridge.endIsland-2).add(bridge.startIsland-2);
			}
			
			boolean[] islandVisit = new boolean[islandCount-2];
			isLandConnection(bridgeConnectionList ,0,islandVisit);
			
			for (int i = 0; i < islandVisit.length; i++) {
				if(!islandVisit[i])
					return;
			}

			//모든 섬이 연결되었으면 다리길이 합 구해서 최솟값인지 확인
			int bridgeLengthSum = 0;
			for (int i = 0; i < output.length; i++) {
				Bridge bridge = bridgeList.get(output[i]);
				bridgeLengthSum += bridge.length;
			}
			
			if(min > bridgeLengthSum)
				min = bridgeLengthSum;
			return;
		}
		
		for (int i = startIdx; i < bridgeList.size(); i++) {
			output[cnt] = i;
			comb(cnt+1,selectBridgeNum,i+1,output);
		}
		
	}
	
	static void isLandConnection(ArrayList<List<Integer>> bridgeConnectionList , int start , boolean[] islandVisit) {
		islandVisit[start] = true;
		
		for (int destination : bridgeConnectionList.get(start)) {
			if(islandVisit[destination])
				continue;
			isLandConnection(bridgeConnectionList,destination,islandVisit);
		}
		
	}
	
	static boolean isArea(int x, int y) {
		if(x >= 0 && y >= 0 && y < n && x < m)
			return true;
		return false;
	}
	
	static void mapNumbering() {
		isVisit = new boolean[n][m];
		
		for (int i = 0; i < n;i++) {
            for (int j = 0; j < m; j++) {
            	if(map[i][j] == 1)
            		numberingIsland(j,i);
            }
        }
	}
	
	static void numberingIsland(int x , int y) {
		Queue<int[]> q = new LinkedList<int[]>();
		q.add(new int[] {y,x});
		isVisit[y][x] = true;
		map[y][x] = islandCount;
		
		while(!q.isEmpty()) {
			int[] curPoint = q.poll();
			
			for (int[]	dir : dirs) {
				int ny = curPoint[0] + dir[0];
				int nx = curPoint[1] + dir[1];
				
				if(ny >= 0 && nx >= 0 && ny < n && nx < m && map[ny][nx] == 1 && !isVisit[ny][nx]) {
					q.add(new int[] {ny,nx});
					isVisit[ny][nx] = true;
					map[ny][nx] = islandCount;
				}
			}
			
		}
		islandCount++;
	}
	
	static class Bridge{
		int length;
		int[] startPoint;
		int[] endPoint;
		int startIsland;
		int endIsland;
		
		
		public Bridge(int length, int[] startPoint, int[] endPoint, int startIsland, int endIsland) {
			this.length = length;
			this.startPoint = startPoint;
			this.endPoint = endPoint;
			this.startIsland = startIsland;
			this.endIsland = endIsland;
		}

		//다리의 출발점과 끝점이 같으면 같은 다리
		@Override
		public boolean equals(Object o) {
			if(o != null && o instanceof Bridge) {
				if(this.startPoint[0] == ((Bridge)o).startPoint[0] && this.startPoint[1] == ((Bridge)o).startPoint[1])
					if(this.endPoint[0] == ((Bridge)o).endPoint[0] && this.endPoint[1] == ((Bridge)o).endPoint[1])
						return true;
				
				if(this.startPoint[0] == ((Bridge)o).endPoint[0] && this.startPoint[1] == ((Bridge)o).endPoint[1])
					if(this.endPoint[0] == ((Bridge)o).startPoint[0] && this.endPoint[1] == ((Bridge)o).startPoint[1])
						return true;
			}

			return false;
		}	
	}
}