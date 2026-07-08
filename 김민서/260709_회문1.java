import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {

            int N = Integer.parseInt(br.readLine());   // 회문 길이

            char[][] map = new char[8][8];

            for (int i = 0; i < 8; i++) {
                map[i] = br.readLine().toCharArray();
            }

            // 여기서 알고리즘 구현
            int cnt = 0;
            
			for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i + N - 1 < 8) {
                        int start = i;
                        int end = i + N - 1;
                        boolean right = true;
                        
                        while (start < end) {
                        	if (map[start][j] != map[end][j]) {
                                right = false;
                            	break;
                            } else {
                                start++;
                                end--;
                            }
                        }    
                        
                        if (right) cnt++;
                    }
                    
                    if (j + N - 1 < 8) {
                        int start = j;
                        int end = j + N - 1;
                        boolean right = true;
                        
                        while (start < end) {
                        	if (map[i][start] != map[i][end]) {
                                right = false;
                            	break;
                            } else {
                                start++;
                                end--;
                            }
                        }    
                        
                        if (right) cnt++;
                    }
                }
            }
            System.out.println("#" + tc + " " + cnt);
        }
    }
}