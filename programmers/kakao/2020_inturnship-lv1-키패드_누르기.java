import java.util.*;
class Solution {
    public String solution(int[] numbers, String hand) {
        ArrayList<String> result = new ArrayList<>();
        // int[][] keypad = {{1,2,3},{4,5,6},{7,8,9},{-10,0,-10}}; 인덱스 사용이 어렵다 .. 
        HashMap<Integer,String> map = new HashMap<>();
        // 키패드 좌표를 map에 저장
        map.put(1,"0,0");
        map.put(2,"0,1");
        map.put(3,"0,2");
        map.put(4,"1,0");
        map.put(5,"1,1");
        map.put(6,"1,2");
        map.put(7,"2,0");
        map.put(8,"2,1");
        map.put(9,"2,2");
        map.put(-3,"3,0");
        map.put(0,"3,1");
        map.put(-4,"3,0");
        
        String answer = "";
        // 문자열을 추가하면 복잡해지니 임의로 초기화
        int l = -3; // *
        int r = -4; // #
        for(int i=0; i<numbers.length; i++) {
            // System.out.println(numbers[i]);
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                l = numbers[i];
                result.add("L");
                answer = answer+"L";
            } else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                r = numbers[i];
                result.add("R");
                answer = answer+"R";
            } else {
//                 System.out.println("n="+numbers[i]);
//                 System.out.println("l="+l);
//                 System.out.println("r="+r);
//                 System.out.println(map.get(numbers[i]));
                // 각 좌표 구하기
                int nx = Integer.parseInt(map.get(numbers[i]).split(",")[0]);
                int ny = Integer.parseInt(map.get(numbers[i]).split(",")[1]);
                int lx = Integer.parseInt(map.get(l).split(",")[0]);
                int ly = Integer.parseInt(map.get(l).split(",")[1]);
                int rx = Integer.parseInt(map.get(r).split(",")[0]);
                int ry = Integer.parseInt(map.get(r).split(",")[1]);
                // System.out.println(nx);
                // System.out.println(ny);
                int gap_l = Math.abs(nx-lx)+Math.abs(ny-ly);
                int gap_r = Math.abs(nx-rx)+Math.abs(ny-ry);
                // System.out.println("gl="+gap_l);
                // System.out.println("gr="+gap_r);
                
                if(gap_l<gap_r) { // 왼쪽이 가까우면 L 입력
                    l = numbers[i];
                    result.add("L");
                    answer = answer+"L";
                } else if(gap_l>gap_r) { // 오른쪽이 가까우면 R 입력
                    r = numbers[i];
                    result.add("R");
                    answer = answer+"R";
                } else { // 만약 거리가 같으면 hand 불러서 입력
                    if(hand.equals("left")) {
                        l = numbers[i];
                        result.add("l");
                        answer = answer+"L";
                    } else if(hand.equals("right")) {
                        r = numbers[i];
                        result.add("R");
                        answer = answer+"R";
                    }
                }
            }
        }
       // System.out.println(result);
        return answer;
    }
}