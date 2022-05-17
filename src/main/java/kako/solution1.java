package kako;

public class solution1 {
    public static void main(String[] args) {

    }

    public String solution(String[] survey, int[] choices) {
        String answer = "";

        int n = survey.length;
        int[] mbti = new int[26];

        for (int i = 0; i < n; i++) {
            if(choices[i] == 1){
                mbti[survey[i].charAt(0)-'A'] += 3;
            }else if(choices[i] == 2){
                mbti[survey[i].charAt(0)-'A'] += 2;
            }else if(choices[i] == 3){
                mbti[survey[i].charAt(0)-'A'] += 1;
            }else if(choices[i] == 4){
                continue;
            }else if(choices[i] == 5){
                mbti[survey[i].charAt(1)-'A'] += 1;
            }else if(choices[i] == 6){
                mbti[survey[i].charAt(1)-'A'] += 2;
            }else if(choices[i] == 7){
                mbti[survey[i].charAt(1)-'A'] += 3;
            }
        }
        for (int i = 0; i < 26; i++) {
            System.out.print(mbti[i] + " ");
        }

        if(mbti[17] < mbti[19]){
            answer += 'T';
        }else if(mbti[17] >= mbti[19]){
            answer += 'R';
        }

        if(mbti[2] < mbti[5]){
            answer += 'F';
        }else if(mbti[2] >= mbti[5]){
            answer += 'C';
        }

        if(mbti[9] < mbti[12]){
            answer += 'M';
        }else if(mbti[9] >= mbti[12]){
            answer += 'J';
        }

        if(mbti[0] < mbti[13]){
            answer += 'N';
        }else if(mbti[0] >= mbti[13]){
            answer += 'A';
        }



        return answer;
    }
}
