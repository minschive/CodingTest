import java.util.ArrayDeque;
import java.util.Queue;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> answer = new ArrayDeque<>();
        
        int n = progresses.length;
        
        int[] daysLeft = new int[n];
        for(int i = 0; i < n; i++) {
            daysLeft[i] = (int)Math.ceil((100.0 - progresses[i]) / speeds[i]);
        }
        
        int cnt = 0;
        int maxDay = daysLeft[0];
        
        for(int i = 0; i < n; i++) {
            if(daysLeft[i] <= maxDay) {
                cnt++;
            } else {
                answer.add(cnt);
                cnt = 1;
                maxDay = daysLeft[i];
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}