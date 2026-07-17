import java.util.*;

class Solution {

    List<int[]> list = new ArrayList<>();

    public int[][] solution(int n) {

        hanoi(n, 1, 2, 3);

        int[][] answer = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }

    private void hanoi(int n, int from, int by, int to) {

        // 원판이 1개면 바로 이동
        if (n == 1) {
            list.add(new int[]{from, to});
            return;
        }

        // 1. 위의 n-1개를 보조 기둥으로 이동
        hanoi(n - 1, from, to, by);

        // 2. 가장 큰 원판 이동
        list.add(new int[]{from, to});

        // 3. n-1개를 목적지로 이동
        hanoi(n - 1, by, from, to);
    }
}