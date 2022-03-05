import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        // ArrayList<Integer> lostlist = new ArrayList<Integer>(Arrays.asList(lost));
        // List<Integer> lostlist = Arrays.asList(lost);
        // List<Integer> lostlist = new ArrayList<Integer>(List.of(lost));
        // ArrayList<Integer> lostlist = new ArrayList<Integer>(List.of(lost));
        // string들만 가능...
        
        //1. reserve와 lost 비교, 같은 숫자는 제거 => arraylist로 변경
        ArrayList<Integer> lostlist = new ArrayList<>();
        for (int i : lost) {
            lostlist.add(i);
        }
        ArrayList<Integer> reservelist = new ArrayList<>();
        for (int i : reserve) {
            reservelist.add(i);
        }
        ArrayList<Integer> llist = (ArrayList<Integer>)lostlist.clone();
        ArrayList<Integer> rlist = (ArrayList<Integer>)reservelist.clone();
        lostlist.removeAll(rlist);
        reservelist.removeAll(llist);
        
        Collections.sort(lostlist);
        ArrayList<Integer> indexlist = new ArrayList<>();
        //2. lost를 한개씩 읽으면서 reserve에 -1값이나 +1값이 있는지 확인, 있으면 제거
        for (int i=0; i<lostlist.size(); i++) {
            if(reservelist.size() < 1) {//빌려줄 애도 없는데 돌아서 뭐해..
                // System.out.println("---그만혀---");
                break;
            }
            int temp = lostlist.get(i);
            if (reservelist.contains(temp-1)) {
                int idx = reservelist.indexOf(temp-1);
                reservelist.remove(idx);
                indexlist.add(temp);
                //reserve에서 temp-1 제거, lost에서 temp 제거
                //lost는 제거하면 size error, temp 받아서 한번에 제거
                // System.out.println("------");
                // System.out.println(idx);
                // System.out.println(temp-1);
                // System.out.println("------");
            } else if (reservelist.contains(temp+1)) {
                int idx = reservelist.indexOf(temp+1);
                reservelist.remove(idx);
                indexlist.add(temp);
            }
        }
        // System.out.println("------");
        lostlist.removeAll(indexlist);
        // System.out.println(lostlist);
        // System.out.println(reservelist);
        int answer = n - lostlist.size();
        return answer;
    }
}