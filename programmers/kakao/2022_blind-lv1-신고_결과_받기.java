import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> mail = new HashMap<>();
        HashMap<String,Integer> pre = new HashMap<>();
        ArrayList<String> report2 = new ArrayList<>();
        // HashSet<String> pre = new HashSet<String>();
        // map에 회원 id 넣기
        for(int i=0; i<id_list.length; i++) {
            map.put(id_list[i],0);
            mail.put(id_list[i],0);
        }
        
        // 중복신고 제거(map 이용)
        for(int j=0; j<report.length; j++) {
            pre.put(report[j],1);
        }
        // System.out.println(pre);
        
        // arraylist에 넣기(배열에 바로 넣기 불가능)
        for (String key : pre.keySet()) {
            report2.add(key);
        }
        // System.out.println(report2);
        
        // array에 넣기
        String[] report3 = new String[report2.size()];
        for(int i=0; i<report3.length; i++) {
            report3[i] = report2.get(i);
        }
        
        String[][] slice = new String[report3.length][2];
        // report 잘라서 넣어주기
        for(int j=0; j<report3.length; j++) {
            slice[j][0] = report3[j].split(" ")[0];
            slice[j][1] = report3[j].split(" ")[1];
            
            // slice의 [1]번째 이름 가져와서 map에서 찾아서 +1
            int temp = map.get(slice[j][1]);
            map.put(slice[j][1],temp+1);
        }
        // System.out.println(map);
        
        for (String key : map.keySet()) {
            Integer value = map.get(key);

            // k번 이상 신고당한 유저 찾기
            if (value >= k) {
                // stop.add(key);
                // slice[][1]이 stop인것 찾기.. 
                for(int j=0; j<report3.length; j++) {
                    // System.out.println("key="+key);
                    // System.out.println(key.getClass().getName());
                    // System.out.println("slice="+slice[j][1]);
                    // System.out.println((slice[j][1]).getClass().getName());
                    if(Objects.equals(key, slice[j][1])) { // 자바에서 스트링 비교는 equals 사용 
                        // System.out.println("!!!");
                        // System.out.println(slice[j][0]);
                        int temp = mail.get(slice[j][0]);
                        mail.put(slice[j][0],temp+1);    
                    } 
                }
            }
        }
        // System.out.println(mail);
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++) {
            answer[i] = mail.get(id_list[i]);
        }
        
        return answer;
    }
}