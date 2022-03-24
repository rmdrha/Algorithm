import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String,String> map = new HashMap<>(); // uid-nickname 쌍 저장
        ArrayList<String[]> list = new ArrayList<String[]>(); // 안내 메시지 저장
        for(int i=0; i<record.length; i++) {
            // System.out.println(record[i]);
            String[] record_arr = record[i].split(" ");
            
            if(record_arr[0].equals("Enter")) { // enter일 때  : map, list에 추가
                map.put(record_arr[1],record_arr[2]);
                list.add(new String[]{record_arr[1],"님이 들어왔습니다."});
                // System.out.println(record_arr[1]+"님이 들어왔습니다");
            }
            else if(record_arr[0].equals("Change")) { // change일 때 : map update
                map.put(record_arr[1],record_arr[2]);
            }
            else { // leave일 때 : list 추가
                list.add(new String[]{record_arr[1],"님이 나갔습니다."});
                // System.out.println(record_arr[1]+"님이 나갔습니다.");
            }
        }
        // System.out.println(map);
        // list 한개씩 불러와서 uid에 맞는 nickname 대입, answer에 추가
        String[] answer = new String[list.size()];
        for(int i=0; i<list.size(); i++) {
            String s = map.get(list.get(i)[0]) + list.get(i)[1];
            // System.out.println(s);
            answer[i] = s;
        }
        return answer;
    }
}