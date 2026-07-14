class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        
        String[][] answer = new String[n][n];
        
        for (int i = 0; i < n; i++) {
            String ar1 = Integer.toString(arr1[i], 2);
            String ar2 = Integer.toString(arr2[i], 2);
            
            String a1 = "";
            String a2 = "";
            
            if (ar1.length() < n) {
                a1 = "0".repeat(n - ar1.length()) + ar1;
            } else {
                a1 = ar1;
            }
            
            if (ar2.length() < n) {
                a2 = "0".repeat(n - ar2.length()) + ar2;
            } else {
                a2 = ar2;
            }
            
            for (int j = 0; j < n; j++) {
                if ((a1.charAt(j) - '0') == 1|| (a2.charAt(j) - '0') == 1) {
                    answer[i][j] = "#";
                } else {
                    answer[i][j] = " ";
                }
            }
        }
        String[] ans = new String[n];
        
        for (int i = 0; i < n; i++) {
            String a = "";
            for (int j = 0; j < n; j++) {
                a += answer[i][j];
            }
            ans[i] = a;
        }
        
        return ans;
    }
}