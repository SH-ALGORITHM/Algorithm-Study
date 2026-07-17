import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        
        Stack<Integer> st = new Stack<>();
        int cnt = 0;
        
        for (int i : ingredient) {
            
            st.push(i);
            
            if (i == 1 && st.size() >= 4) {
                int size = st.size();
                
                if (st.get(size - 4) == 1 && st.get(size - 3) == 2 && st.get(size - 2) == 3 && st.get(size - 1) == 1) {
                    cnt++;
                    for (int j = 0; j < 4; j++) {
                        st.pop();
                    }
                }
            }
        }
        
        return cnt;
    }
}