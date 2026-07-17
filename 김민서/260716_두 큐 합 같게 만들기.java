import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        Queue<Long> que1 = new LinkedList<>();
        Queue<Long> que2 = new LinkedList<>();
        
        long total = 0;
        long q1 = 0;
        long q2 = 0;
        
        for (int q : queue1) {
            que1.offer((long)q);
            total += q;
            q1 += q;
        }
        
        for (int q : queue2) {
            que2.offer((long)q);
            total += q;
            q2 += q;
        }
        
        if (total % 2 == 1) {
            return -1;
        } else {
            total /= 2;
        }
        
        long out = 0;
        int cnt = 0;
        
        while (q1 != q2) {
            if (q1 > q2) {
                out = que1.poll();
                que2.offer(out);
                
                q1 -= out;
                q2 += out;
            } else {
                out = que2.poll();
                que1.offer(out);
                
                q2 -= out;
                q1 += out;
            }
            
            cnt++;
            
            if (cnt > (queue1.length + queue2.length) * 2) {
                break;
            }
        }
        
        if (q1 == q2) {
            return cnt;
        } else {
            return -1;
        }
    }
}