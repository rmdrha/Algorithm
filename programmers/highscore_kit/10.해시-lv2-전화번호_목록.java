import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashMap<String,String> map = new HashMap<>();
        // HashSet<String> set = new HashSet<>();
        boolean answer = true;
        for (int i=0; i<phone_book.length; i++) { //접두사가 맨 뒤에 있을 때 찾지 못함 
            map.put(phone_book[i],phone_book[i].substring(0,1));
            // System.out.println("넣었음"+map);
            // System.out.println(phone_book[i].length());
        }
        for (int i=0; i<phone_book.length; i++) {
            for (int j=1; j<phone_book[i].length(); j++) {
                if(!answer) {
                    break;
                }
                // System.out.println("찾아줘"+phone_book[i].substring(0,j));
                if(map.containsKey(phone_book[i].substring(0,j))) {
                    // System.out.println("중복인것같은데"+phone_book[i].substring(0,j));
                    // System.out.println("중복"+map);
                    answer = false;
                    break;
                }
            }
        }
        // System.out.println("--");
        // System.out.println(map);
        return answer;
    }
}