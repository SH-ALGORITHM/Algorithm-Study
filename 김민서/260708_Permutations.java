import java.util.*;

class Solution {

    static List<Integer> output;
    static List<List<Integer>> ans;
    static boolean[] visited;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        output = new ArrayList<>();

        ans = new ArrayList<>();

        dfs(nums, 0);

        return ans;
    }

    void dfs(int[] nums, int dept) {
        if (dept == nums.length) {
            ans.add(new ArrayList<>(output));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                output.add(nums[i]);
                visited[i] = true;
                dfs(nums, dept + 1);
                visited[i] = false;
                output.remove(output.size() - 1);
            }
        }
    }
}