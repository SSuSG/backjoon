class Solution {
    static int[] p;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        p = new int[n];
        boolean[] isVisit = new boolean[n];
        make(n);
        for(int i = 0 ; i < computers.length ; i++){
            for(int j = 0 ; j < computers.length ; j++){
                if(computers[i][j] == 0) continue;
                union(i , j);   
            }
        }
        for(int i = 0 ; i < n ; i++)
            isVisit[find(i)] = true;
        for(int i = 0 ; i < n ; i++){
            if(isVisit[i])
               answer++;
        }
        
        return answer;
    }
    
    static void make(int n ){
        for(int i = 0 ; i < n ; i++)
            p[i] = i;
    }
    
    static boolean union(int a, int b){
        int aP = find(a);
        int bP = find(b);
        if(aP == bP) return false;
        p[bP] = aP;
        return true;
    }
    
    static int find(int a){
        if(p[a] == a) return a;
        return p[a] = find(p[a]);
    }
}