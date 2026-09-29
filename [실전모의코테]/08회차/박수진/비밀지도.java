class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            int merged = arr1[i] | arr2[i];
            
            String row = Integer.toBinaryString(merged);

            while (row.length() < n) {
                row = "0" + row;
            }

            row = row.replace('1', '#');
            row = row.replace('0', ' ');

            answer[i] = row;
        }

        return answer;
    }
}