class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i=0; i<m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        
        while(true) {
            int stop = 0;
            boolean popped[][] = new boolean[m][n];

            // 2x2 탐색
            for (int i=0; i<m-1; i++) {
                for (int j=0; j<n-1; j++) {
                    if (map[i][j] == '-') continue; // 빈칸은 패스
                    
                    if (map[i][j]==map[i][j+1] &&
                        map[i+1][j]==map[i][j] && 
                        map[i+1][j]==map[i+1][j+1]) {
                                
                                popped[i][j] = true;
                                popped[i][j+1] = true;
                                popped[i+1][j] = true;
                                popped[i+1][j+1] = true;
                                
                                stop = 1;
                    }
                }
            }
            if (stop==0)
                return answer;

            // popped 돌면서 해당 셀 삭제
            for (int i=0; i<m; i++) {
                for (int j=0; j<n; j++) {
                    if (popped[i][j]) {
                        if (map[i][j] != '-') {
                            answer++;
                            map[i][j] = '-';
                        }
                    }
                }
            }
                
            // '-' cell을 drop 시키기
            for (int i=m-1; i>=0; i--) {
                for (int j=n-1; j>=0; j--) {
                    if (map[i][j] == '-') {
                        for (int k=i-1; k>=0; k--) {
                            if (map[k][j] != '-') {
                                map[i][j] = map[k][j];
                                map[k][j] = '-';       
                                break;                 
                            }
                        }
                    }
                }
            }
        }
    }
}