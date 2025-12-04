import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> brackets = new Stack<>();
        
        char curr = '0';
        
        for (int i=0; i<s.length(); i++) {
            curr = s.charAt(i);
            
            try {
                if (curr == '(')
                    brackets.push(curr);
                else 
                    brackets.pop();
            } catch (Exception e) {
                return false;
            }
        }
        boolean answer = brackets.empty() ? true : false;
        return answer;
    }
}