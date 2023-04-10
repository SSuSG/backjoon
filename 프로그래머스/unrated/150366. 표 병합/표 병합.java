import java.util.*;
class Solution {
    static int[] p = new int[2501];
    static String[] v = new String[2501];
    public String[] solution(String[] commands) {
        List<String> answer = new ArrayList<>();
        make();
        //"UPDATE r c value" -> r,c의 셀의 값을 변경
        //"UPDATE value1 value2" -> 모든 셀을 확인하면서 value값을 변경 ? 또는 value값을 hashmap에??
        //"MERGE r1 c1 r2 c2" -> cell의 point를 추가?? 
        //"UNMERGE r c" -> r,c는 기존 값을 가지고 나머지 셀은 empty , 
        for(String command : commands){
            String[] s = command.split(" ");
            if("UPDATE".equals(s[0])){
                if(s.length == 4){
                    //"UPDATE r c value"
                    int r = Integer.parseInt(s[1]);
                    int c = Integer.parseInt(s[2]);
                    v[find((r-1)*50+c)] = s[3];
                    
                }else if(s.length == 3){
                    //"UPDATE value1 value2"
                    String value1 = s[1];
                    String value2 = s[2];
                    for(int i = 0 ; i<= 2500 ; i++){
                        if(value1.equals(v[i]))
                            v[i] = value2;
                    }                   
                }            
            }else if("MERGE".equals(s[0])){
                
                //"MERGE r1 c1 r2 c2"
                int r1 = Integer.parseInt(s[1]);
                int c1 = Integer.parseInt(s[2]);
                int r2 = Integer.parseInt(s[3]);
                int c2 = Integer.parseInt(s[4]);
                int root1 = find((r1-1)*50+c1);
                int root2 = find((r2-1)*50+c2);
                
                String rootString = v[root1].isBlank() ? v[root2] : v[root1];
                v[root1] = "";
                v[root2] = "";
                v[root1] = rootString;
                union((r1-1)*50+c1 ,(r2-1)*50+c2);

            }else if("UNMERGE".equals(s[0])){
                //"UNMERGE r c"
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                int parent  = find((r-1)*50+c);
                String temp = v[parent];
                v[parent] = "";
                v[(r-1)*50+c] = temp;
                
                List<Integer> deleteList = new ArrayList<>();
                for (int i = 0; i <= 2500; i++) {
                    if (find(i) == parent)
                        deleteList.add(i);
                }
                for (Integer t : deleteList)
                    p[t] = t;
       
            }else if("PRINT".equals(s[0])){
                int r = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                int parent  = find((r-1)*50+c);
                answer.add(v[find(parent)].isBlank() ? "EMPTY" : v[find(parent)]);
            }
        }
        
        
        return answer.toArray(new String[0]);
    }
    
    static void make(){
        for(int i = 0 ; i <= 2500 ; i++){
            p[i] = i;
            v[i] = "";   
        }
        
    }
    //a가 중심이 되겠다
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