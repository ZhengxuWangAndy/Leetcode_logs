// Binary Tree Level Order Traversal

// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).


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


// My code: BFS and record each level size
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Deque<TreeNode> queue = new LinkedList<>();

        if(root == null){
            return result;
        }

        result.add(Arrays.asList(root.val));

        if (root.left != null){
            queue.add(root.left);
        }
        if (root.right != null){
            queue.add(root.right);
        }

        while(!queue.isEmpty()){
            int currentLevelSize = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < currentLevelSize; i++){
                TreeNode tmp = queue.poll();
                level.add(tmp.val);
                if(tmp.left != null){
                    queue.add(tmp.left);
                }
                if(tmp.right != null){
                    queue.add(tmp.right);
                }
            }
            result.add(level);

        }

        return result;
    }
}