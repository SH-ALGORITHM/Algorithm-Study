import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] graph;
	static boolean[] visited;
	static int cnt = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[n];
		visited = new boolean[n];
		
		for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

		int root = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		
        for (int i = 0; i < n; i++) {
            int j = Integer.parseInt(st.nextToken());
            if(j == -1) {
            	root = i;
            	continue;
            }

            graph [i].add(j);
            graph[j].add(i); 
        }
        
        int cut = Integer.parseInt(br.readLine());
        
        if(cut == root) {
            System.out.println(0);
            return;
        }
        visited[cut] = true;
        
        graph[cut].clear();
        
        for(int i = 0; i < n; i++) {
        	if(graph[i].contains(cut)) {
        		graph[i].remove(graph[i].indexOf(cut));
        	}
        }
        
        dfs(root);
        
        System.out.println(cnt);
		
	}
	
	public static void dfs(int start) {
		visited[start] = true;
		boolean isLeaf = true;
		
        for (int next : graph[start]) {
            if (!visited[next]) {
            	isLeaf = false;
                dfs(next);
            }
        }
        if(isLeaf) cnt++; 
	}

}