import java.util.*;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> answer = new ArrayList<>();

        Queue<TreeNode> que = new LinkedList<>();
        if(root != null) {
            que.offer(root);
        }

        while(!que.isEmpty()) {
            int size = que.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode cur = que.poll();

                if (cur.left != null) {
                    que.add(cur.left);
                }

                if (cur.right != null) {
                    que.add(cur.right);
                }

                level.add(cur.val);
            }

            answer.add(level);
        }

        return answer;
    }
}