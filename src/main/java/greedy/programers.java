package greedy;

import java.util.*;

public class programers {
}

class Solution_lv2_1 {
    public int solution(String name) {
        int answer = 0;
        int min = name.length()-1;
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) >= 'N'){
                int temp = 'Z' - name.charAt(i)+1;
                answer += temp;
            }else{
                int temp2 = name.charAt(i) - 'A';
                answer += temp2;
            }
        }

        for (int i = 0; i < name.length(); i++) {
            int nextIndex = i+1;

            while(nextIndex < name.length() && name.charAt(nextIndex)=='A'){
                nextIndex++;
            }
            min = Math.min(min, i + i + name.length() - nextIndex);
        }
        answer += min;
        
        return answer;
    }
}

class Solutionlv2_2 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int comp = 0;
        for(int i=0; i<number.length()-k; i++){
            comp = 0;
            for(int j=idx; j<=i+k; j++){
                if(comp < number.charAt(j)-'0'){
                    comp = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(comp);
        }
        return answer.toString();
    }
}

class Solutionlv2_3 {
    public static int solution(int[] people, int limit) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        for(int x : people) list.add(x);
        Collections.sort(list);

        boolean[] check = new boolean[people.length];

        int chk = 0;
        int sum=0;
        int pp = 0;
        int now=0;
        int nowi=0;

        while(chk < people.length){
            sum=0;
            pp = 0;
            now=0;
            nowi=0;
            for (int i = 0; i < people.length; i++) {
                if(check[i] == false){
                    if(sum + people[i] <= limit && pp < 2){
                        sum += people[i];
                        now = people[i];
                        nowi = i;
                        check[i] = true;
                        chk++;
                        pp++;
                    }else{
                        if(sum-now+people[i] <=limit && pp == 2){
                            sum -= now;
                            check[nowi] =false;
                            now = people[i];
                            sum += now;
                            nowi = i;
                            check[i] = true;
                        }
                    }
                }
            }
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = {100,500,500,900,950};
        int limit = 1000;
        int solution = solution(people, limit);
        System.out.println("solution = " + solution);
    }
}

class Solutionlv2_4 {
    public class Node{
        int s;
        int e;
        int w;

        public Node(int s, int e, int w) {
            this.s = s;
            this.e = e;
            this.w = w;
        }
    }

    int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Node> list = new ArrayList<>();
        for (int[] cost : costs) {
            list.add(new Node(cost[0] , cost[1] , cost[2]));
        }
        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.w-o2.w;
            }
        });

        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (Node node : list) {
            if(checkParent(node.s, node.e)){ // 부모가 다를경우
                answer += node.w;
                unionParent(node.s, node.e);
            }
        }

        return answer;
    }

    public int getParent(int x){ // 부모 찾기
        if(parent[x] == x){
            return x;
        }else{
            return getParent(parent[x]);
        }
    }

    public void unionParent(int s, int e){ //부모 합치기
        int a = getParent(s);
        int b = getParent(e);

        if(a < b){
            parent[b] = a;
        }else{
            parent[a] = b;
        }

    }
    public boolean checkParent(int s, int e){ // 부모 같은지 체크 , 사이클이 형성되나 안되나
        int a = getParent(s);
        int b = getParent(e);

        if(a == b){ //부모가 같을경우
            return false;
        }else{ //부모가 다를경우
            return true;
        }
    }
}

class Solutionlv3_1 {
    public class road{
        int s;
        int e;

        public road(int s, int e) {
            this.s = s;
            this.e = e;
        }
    }
    public int solution(int[][] routes) {
        int answer = 0;
        ArrayList<road> list = new ArrayList<>();
        for (int[] route : routes) {
            list.add(new road(route[0],route[1]));
        }

        Collections.sort(list, new Comparator<road>() {
            @Override
            public int compare(road o1, road o2) {
                return o1.e-o2.e;
            }
        });

        int min = Integer.MIN_VALUE;
        for (road road : list) {
            if(min < road.s){
                min = road.e;
                answer++;
            }
        }

        return answer;
    }
}
