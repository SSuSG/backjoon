package programmersLV1;

public class 키패드누르기 {

    public String solution(int[] numbers, String hand) {
        String answer = "";
        int left = 10;
        int right = 12;
        int left_dis;
        int right_dis;
        StringBuilder sb = new StringBuilder();

        for(int num : numbers){
            left_dis = 0;
            right_dis = 0;
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                left = num;
            }else if (num == 3 || num == 6 || num == 9){
                sb.append("R");
                right = num;
            }else{
                if(num == 0 ){
                    num += 11;
                }

                left_dis = (Math.abs(left-num)/3) +(Math.abs(left-num)%3);
                right_dis = (Math.abs(right-num)/3) +(Math.abs(right-num)%3);


                if(left_dis == right_dis){
                    if(hand.equals("left")){

                        sb.append("L");
                        left = num;
                    }else{
                        sb.append("R");
                        right = num;
                    }
                }else if (left_dis > right_dis){
                    sb.append("R");
                    right = num;
                }else {
                    sb.append("L");
                    left = num;
                }
            }
        }

        return sb.toString();
    }

}
