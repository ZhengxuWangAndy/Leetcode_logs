// Minimum Absolute Difference in BST

// Given the root of a Binary Search Tree (BST), return the minimum absolute difference between the values of any two different nodes in the tree.


// my mistake: only compared neighbor nodes.
// class Solution {
//     public int getMinimumDifference(TreeNode root) {
//         int[] dif = {Integer.MAX_VALUE};
//         dfs(root, dif);
//         return dif[0];
//     }

//     public void dfs(TreeNode root, int[] dif){
//         if(root != null){
//             if(root.left != null){
//                 dif[0] = Math.min(root.val - root.left.val, dif[0]);
//                 dfs(root.left, dif);
//             }
//             if(root.right != null){
//                 dif[0] = Math.min(root.right.val - root.val, dif[0]);
//                 dfs(root.right, dif);
//             }
//         }
//     }
// }

// use pre to record during in-order traverse, checking neighbor element in in-order 
class Solution {
    int pre;
    int ans;
    public int getMinimumDifference(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return;
        }
        dfs(root.left);
        if(pre == -1) {
            pre = root.val;
        } else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}