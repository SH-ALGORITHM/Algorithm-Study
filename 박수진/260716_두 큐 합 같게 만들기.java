import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0;
        long sum2 = 0;

        for (int n : queue1) {
            q1.offer(n);
            sum1 += n;
        }

        for (int n : queue2) {
            q2.offer(n);
            sum2 += n;
        }
        
        long target = (sum1 + sum2);
        
        // 총합이 홀수면 불가능
        if (target % 2 != 0) return -1;
        target /= 2;
        
        int count = 0;
        int limit = (queue1.length + queue2.length) * 3;
        
        while (count <= limit) {
            if (sum1 == target) {
                return count;
            }

            if (sum1 > target) {
                int num = q1.poll();
                q2.offer(num);
                sum1 -= num;
            } else {
                int num = q2.poll();
                q1.offer(num);
                sum1 += num;
            }

            count++;
        }
        
        return -1;
    }
}