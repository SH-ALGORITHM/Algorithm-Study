import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        
        int[][] b_time = new int[book_time.length][2];
        
        for (int i = 0; i < b_time.length; i++) {
            int start = Integer.parseInt(book_time[i][0].split(":")[0]) * 60 + Integer.parseInt(book_time[i][0].split(":")[1]);
            int end = Integer.parseInt(book_time[i][1].split(":")[0]) * 60 + Integer.parseInt(book_time[i][1].split(":")[1]);
            
            b_time[i][0] = start;
            b_time[i][1] = end;
        }
        
        PriorityQueue<Integer> times = new PriorityQueue<>();
        
        Arrays.sort(b_time, (a, b) -> a[0] - b[0]);

        times.add(b_time[0][1]);
        
        for (int i = 1; i < b_time.length; i++) {
            
            if (times.peek() + 10 <= b_time[i][0]) {
                times.poll();
            }
            
            times.offer(b_time[i][1]);
        }
        
        return times.size();
    }
}