/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null)
            return 0;

        // queue of elements [(node, col_index)]
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        Integer maxWidth = 0;

        queue.offer(new Pair<>(root, 1));
        while (queue.size() > 0) {
         
            int l = queue.peek().getValue();
            int r = l;
            Integer size = queue.size();
          
            for (int i = 0; i < size; ++i) {
                
                TreeNode node = queue.peek().getKey();
                r = queue.peek().getValue();
                queue.poll();                
                if (node.left != null)
                    queue.offer(new Pair<>(node.left, 2 * r));
                if (node.right != null)
                    queue.offer(new Pair<>(node.right, 2 * r + 1));
            }

            maxWidth = Math.max(maxWidth, r - l + 1);
        }

        return maxWidth;
    }
}