package BfsDfs;

import java.util.ArrayList;
import java.util.Collections;

public class programers {
}

class Solutionlv2_1 {
    int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        int cnt = 1;
        dfs(cnt , numbers , target , numbers[0]);
        dfs(cnt , numbers , target , -numbers[0]);
        return answer;
    }
    
    public  void dfs(int cnt , int[] numbers , int target , int result){
        if(cnt == numbers.length && result == target){
            answer++;
            return;
        }else if(cnt >= numbers.length){
            return;
        }else{
            dfs(cnt+1 , numbers , target , result + numbers[cnt]);
            dfs(cnt+1 , numbers , target , result - numbers[cnt]);
        }

    }

}

class Solutionlv3_1 {
    boolean[] check;
    int answer;
    public int solution(int n, int[][] computers) {
        answer = 0;
        check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!check[i])
                answer++;
            dfs(computers , i);
        }
        return answer;
    }

    private void dfs(int[][] computers, int i) {
        if(!check[i]){
            check[i] = true;
        }

        for (int j = 1; j < computers.length; j++) {
            if(j == i)
                continue;

            if(computers[i][j] == 1 && !check[j]){ //연결 되어있다면
                dfs(computers,j);
            }
        }
    }
}

class Solutionlv3_2 {
    boolean[] visit;
    int answer;
    int min;
    public int solution(String begin, String target, String[] words) {
        answer = 0;
        min = 0;
        visit = new boolean[words.length];
        dfs(begin , target , words , 0);

        return answer;
    }

    private void dfs(String begin, String target, String[] words, int cnt) {
        if(!begin.equals(target)){ //단어가 다를시 words 에서 글자하나만 다른걸로 변경
            for (int i = 0; i < words.length; i++) {
                int xnum=0;
                if(visit[i])
                    continue;

                for (int j = 0; j < words[0].length(); j++) {
                    if(begin.charAt(j) != words[i].charAt(j)){
                        xnum++;
                    }
                }
                if(xnum == 1){
                    visit[i] = true;
                    dfs(words[i] ,  target,  words, cnt +1);
                    visit[i] = false;
                }
            }
        }else{ // 단어가 같을시
            answer = cnt;
            return;
        }

    }
}

class Solutionlv3_3 {
    String[] answer;
    ArrayList<String> answers;
    boolean[] visit;

    public String[] solution(String[][] tickets) {

        visit = new boolean[tickets.length];
        answers = new ArrayList<>();

        dfs(0 , "ICN" , "ICN" , tickets);
        Collections.sort(answers);
        answer = answers.get(0).split(" ");

        return answer;
    }

    private void dfs(int cnt, String se, String result, String[][] tickets) {

        if(cnt == tickets.length){
            answers.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if(!visit[i] && tickets[i][0].equals(se)){
                visit[i] = true;
                dfs(cnt+1 , tickets[i][1] , result+" "+tickets[i][1] , tickets);
                visit[i] = false;
            }
        }
    }

}
