import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supo1 = {1,2,3,4,5}; //5
        int[] supo2 = {2,1,2,3,2,4,2,5}; //8
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5}; //10
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        
        // 점수 counting
        for(int i=0; i<answers.length; i++) {
            if(answers[i] == supo1[i%5]) {
                score1++;
            }
            if(answers[i] == supo2[i%8]) {
                score2++;
            }
            if(answers[i] == supo3[i%10]) {
                score3++;
            }
        }
        
        // 점수 비교
        int [][] compare = {{score1,1}, {score2,2}, {score3,3}};
        Arrays.sort(compare, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });

        // 첫 번째 점수 == 두 번째 점수 -> 세 번째 점수도 비교
        // 첫 번째 점수 != 두 번째 점수 -> 첫 번째 점수만 넣기
        int[] answer;
        if(compare[0][0] != compare[1][0]) {
            answer = new int[1];
            answer[0] = compare[0][1];
        } else {
            if(compare[1][0] != compare[2][0]) {
                answer = new int[2];
                answer[0] = compare[0][1];
                answer[1] = compare[1][1];
            } else {
                answer = new int[3];
                answer[0] = compare[0][1];
                answer[1] = compare[1][1];
                answer[2] = compare[2][1];
            }
        }
        return answer;
    }
}