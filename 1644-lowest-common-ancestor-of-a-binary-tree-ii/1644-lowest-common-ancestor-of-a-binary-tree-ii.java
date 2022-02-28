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
    int count = 0;
    
    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == null) return root;
        
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right, p, q);
        
        if(root == p || root == q) {
            count++;
            return root;
        }
        
        if(left!=null && right!=null) return root;
        
        
        return left!=null ? left : right;
       
        
        
        
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lca = LCA(root, p, q);
        return count == 2 ? lca: null;
    }
}