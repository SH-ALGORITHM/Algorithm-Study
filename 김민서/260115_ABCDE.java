import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	static List<Integer>[] graph;
	static boolean[] visited;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n];
		visited = new boolean[n];

		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
			graph[b].add(a);
		}

		for (int j = 0; j < n; j++) {
			if (dfs(j, 0)) {
				System.out.println(1);
				return;
			}
		}
		
		System.out.println(0);
	}

	public static boolean dfs(int start, int dept) {
		if (dept == 4) {
			return true;
		}
		visited[start] = true;
		for (int next : graph[start]) {
			if (!visited[next]) {
				if (dfs(next, dept + 1)) return true;
			}
		}
		visited[start] = false;

		return false;
	}
}
