package programmersLV1;

import java.util.HashSet;

public class 로또의_최고_순위와_최저순위 {
    public static void main(String[] args) {

    }

    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        HashSet<Integer> lotto = new HashSet<>();

        for (int i = 0; i < lottos.length; i++) {
            if(lottos[i] != 0){
                lotto.add(lottos[i]);
            }
        }

        int correctNum = 0;
        for (int i = 0; i < win_nums.length; i++) {
            if(lotto.contains(win_nums[i])){
                correctNum++;
            }
        }

        if(correctNum == 6){
            answer[1] = 1;
        }else if(correctNum == 5){
            answer[1] = 2;
        }else if(correctNum == 4){
            answer[1] = 3;
        }else if(correctNum == 3){
            answer[1] = 4;
        }else if(correctNum == 2){
            answer[1] = 5;
        }else if(correctNum == 1 || correctNum == 0){
            answer[1] = 6;
        }

        if(lotto.size() == 6){
            if(correctNum == 6){
                answer[0] = 1;
            }else if(correctNum == 5){
                answer[0] = 2;
            }else if(correctNum == 4){
                answer[0] = 3;
            }else if(correctNum == 3){
                answer[0] = 4;
            }else if(correctNum == 2){
                answer[0]= 5;
            }else if(correctNum == 1 || correctNum == 0){
                answer[0] = 6;
            }
        }else if(lotto.size() == 5){
            if(correctNum == 5){
                answer[0] = 1;
            }else if(correctNum == 4){
                answer[0] = 2;
            }else if(correctNum == 3){
                answer[0] = 3;
            }else if(correctNum == 2){
                answer[0]= 4;
            }else if(correctNum == 1 ){
                answer[0] = 5;
            }else if(correctNum == 0){
                answer[0] = 6;
            }
        }else if(lotto.size() == 4){
            if(correctNum == 4){
                answer[0] = 1;
            }else if(correctNum == 3){
                answer[0] = 2;
            }else if(correctNum == 2){
                answer[0] = 3;
            }else if(correctNum == 1){
                answer[0]= 4;
            }else if(correctNum == 0 ){
                answer[0] = 5;
            }
        }else if(lotto.size() == 3){
            if(correctNum == 3){
                answer[0] = 1;
            }else if(correctNum == 2){
                answer[0] = 2;
            }else if(correctNum == 1){
                answer[0] = 3;
            }else if(correctNum == 0){
                answer[0]= 4;
            }
        }else if(lotto.size() == 2){
            if(correctNum == 2){
                answer[0] = 1;
            }else if(correctNum == 1){
                answer[0] = 2;
            }else if(correctNum == 0){
                answer[0] = 3;
            }
        }else if(lotto.size() == 1){
            if(correctNum == 1){
                answer[0] = 1;
            }else if(correctNum == 0){
                answer[0] = 2;
            }
        }else if(lotto.size() == 0){
            answer[0] = 1;
        }

        return answer;
    }
}
