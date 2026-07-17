import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for (int i = 1; i < temperatures.length; i++) {

            while(!stack.isEmpty() && temperatures[stack.peek()] < temperatures[i]) {
                int day = stack.pop();
                answer[day] = i - day;
            }

            stack.push(i);
        }

        return answer;
    }
}