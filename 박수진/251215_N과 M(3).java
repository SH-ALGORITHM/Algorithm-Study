import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static int N;
    static int M;
    static StringBuilder answer = new StringBuilder();
    static int[] arr; // 결과를 저장할 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
				
		// 수열의 길이는 M
        arr = new int[M];
        
        perm(0);
        
        System.out.println(answer);
    }
    
    // 중복을 허용하는 순열(Permutation with Repetition)을 생성하는 DFS 함수
    static void perm(int depth) {
        if (depth == M) {
            for (int ar : arr) {
                answer.append(ar).append(" ");
            }
            answer.append('\n');
            return;
        }
        for (int i=1; i<=N; i++) {
		    // 중복 허용이므로, 별도의 방문 체크없이 숫자를 선택
            arr[depth] = i;
            perm(depth + 1);
        }
    }
}