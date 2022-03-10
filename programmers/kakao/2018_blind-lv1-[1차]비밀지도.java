import java.util.*;
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        
        answer = new String[arr1.length];
        for(int i=0; i<arr1.length; i++) {
            String temp = Integer.toBinaryString(arr1[i]|arr2[i]);
            // 자리수 보정
            int correction = n - temp.length();
            if(correction != 0) {
                for(int j=0; j<correction; j++) {
                    temp = "0"+temp;
                }
            }
            // 변환
            temp = temp.replace("1", "#");
            temp = temp.replace("0", " ");
            answer[i] = temp;
        }
        
//         for(int i=0; i<arr1.length; i++) {
//             String map1 = Integer.toBinaryString(arr1[i]);
//             int correction1 = n - map1.length();
//             if(correction1 != 0) {
//                 for(int j=0; j<correction1; j++) {
//                     map1 = "0"+map1;
//                 }
//             }
//             System.out.println(map1);
//             System.out.println("------");
            
//             String map2 = Integer.toBinaryString(arr2[i]);
//             int correction2 = n - map2.length();
//             if(correction2 != 0) {
//                 for(int j=0; j<correction2; j++) {
//                     map2 = "0"+map2;
//                 }
//             }
//             System.out.println(map2);
//             System.out.println(map1|map2); 한개씩 뽑아서 했으면 되었을 것 ... ! 
            
//             System.out.println("=============");
//         }
        return answer;
    }
}