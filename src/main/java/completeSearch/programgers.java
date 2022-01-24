package completeSearch;

public class programgers {
}

class Solution_lv2_1 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int result = brown + yellow;
        int row = 1; // 가로
        int col; //세로
        while(true){
            col = 1;
            while(row != col){
                if(row * col == result){
                    answer[0] = row;
                    answer[1] = col;
                    return answer;
                }

                col++;
            }
            row++;
            if(row * col == result){
                answer[0] = row;
                answer[1] = col;
                break;
            }
        }

        return answer;
    }
}