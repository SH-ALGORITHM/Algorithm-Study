import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static int[][] graph;
    static boolean[] visited;
    static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());    // 정점의 개수
        M = Integer.parseInt(st.nextToken());    // 간선의 개수
        
        graph = new int[N+1][N+1];
        visited = new boolean[N+1];
        
        // 간선 정보 입력
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            
            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        
        int count = 0; // 연결 요소의 개수
        
        // 정점 확인
        for (int i=1; i<=N; i++) {
            if(!visited[i]) {
                check(i);
                count++;
            }
        }
        
        System.out.println(count);
    }
    
    public static void check(int node) {
        visited[node] = true; 
        
        for (int i=1; i<=N; i++) {
            if (graph[node][i] == 1 && !visited[i]) {
                check(i);
            }
        }
    }
}