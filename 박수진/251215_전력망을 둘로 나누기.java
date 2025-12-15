import java.util.Queue;
import java.util.LinkedList;

class Solution {
    static int[][] map;
    static int N;
    public int solution(int n, int[][] wires) {
        N = n;
        int answer = n;
        
        map = new int[n+1][n+1];
        
        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];
            map[a][b] = 1;
            map[b][a] = 1;
        }
        
        for (int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            
            map[a][b] = 0;
            map[b][a] = 0;
            
            int cnt = bfs(a);
            
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff); // 최솟값 갱신
            
            map[a][b] = 1;
            map[b][a] = 1;
        }
        return answer;
    }
    
    public int bfs(int start) {
        int count = 1;
        boolean[] visited = new boolean[N+1];
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            
            for (int i=1; i<=N; i++) {
                if (map[cur][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    count++;
                }
            }
        }
        
        return count;
    }
}