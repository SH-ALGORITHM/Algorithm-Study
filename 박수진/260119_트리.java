import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] children; // 자식 노드 목록
    static int del; // 삭제할 노드 번호 
    static int leafCount = 0; // 리프 노드 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim()); // 노드 개수

        children = new ArrayList[N];
        for (int i = 0; i < N; i++) {
          children[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int root = -1; 
        int[] parent = new int[N];

        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken()); // 각 노드의 부모
            if (parent[i] == -1) 
                root = i; 
            else children[parent[i]].add(i);
        }

        del = Integer.parseInt(br.readLine().trim());

        // 루트가 삭제되면 남는 노드가 없음 (트리 전체가 삭제)
        if (del == root) {
            System.out.println(0);
            return;
        }

        dfs(root);
        System.out.println(leafCount);
    }

    static void dfs(int u) {
        if (u == del) 
          return;

        int validChild = 0;
        for (int v : children[u]) {
            if (v == del) 
              continue;
            dfs(v);
            validChild++;
        }

        if (validChild == 0) 
          leafCount++;
    }
}
