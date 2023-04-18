import java.util.*;
class Solution {
    static int[] Info;
    static List<Integer>[] childs;
    static int max = 0;
    public int solution(int[] info, int[][] edges) {
        Info = info;
        childs = new List[info.length];
        for(int i = 0 ; i < info.length ; i++){
            childs[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            childs[e[0]].add(e[1]);
        }
        List<Integer> l = new ArrayList<>();
        l.add(0);
        dfs(0,0,0,l);

        return max;
    }
    
    public void dfs(int idx , int sheepCnt , int wolfCnt , List<Integer> next){
        if(Info[idx] == 0) sheepCnt++;
        else wolfCnt++;
        if(wolfCnt >= sheepCnt) return;
        max = Math.max(max , sheepCnt);
        
        List<Integer> list = new ArrayList<>();
        list.addAll(next);
        list.remove(Integer.valueOf(idx));
        
        for(int child : childs[idx]){
            list.add(child);
        }
        for(int n : list){
            dfs(n,sheepCnt,wolfCnt,list);
        }
    }
    
}