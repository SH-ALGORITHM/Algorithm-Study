import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bg = new LinkedList<>(); // 다리 위 트럭 큐
        
        int sec = 1;    // 경과 시간
        int totalW = 0; // 다리 위 트럭 무게 합
        
        for (int i=0; i<truck_weights.length; sec++) {
            // 떠날 차는 떠나
            if (bg.size() == bridge_length) {
                totalW -= bg.peek();
                bg.poll();    
            }
                
            // 무거워서 안돼
            if (totalW + truck_weights[i] > weight) {
                bg.offer(0);
                continue;
            }
            
            // 들어와
            bg.offer(truck_weights[i]);
            totalW += truck_weights[i];
            i++;
        }
        
        // 마지막 트럭이 다리를 건너는 시간 더해주기
        sec += (bridge_length-1);
        return sec;
    }
}