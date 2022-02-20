/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)return true;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<List<TreeNode>> list = new ArrayList<>();
        while(!queue.isEmpty()){
            List<TreeNode> tempList = new ArrayList<>();
            int len = queue.size();
            for(int i = 0; i<len; i++){
                TreeNode temp = queue.poll();
                tempList.add(temp);
                if(temp!=null)queue.offer(temp.left);
                if(temp!=null)queue.offer(temp.right);
            }
            list.add(tempList);
        }
        
        for(int i = 0; i<list.size(); i++){
            List<TreeNode> tempList = list.get(i);
            int start = 0, end = tempList.size() -1;
            while(start < end){
                if(tempList.get(start) == null && tempList.get(end) == null){
                    start++;
                    end--;
                    continue;
                }
                else{
                    if(tempList.get(start) == null || tempList.get(end) == null){
                        return false;
                    }
                    
                    else if(tempList.get(start).val != tempList.get(end).val) return false;
                    
                    else{
                        start++;
                        end--;
                    }
                }
            }
        }
        
        return true;
        
    }
}