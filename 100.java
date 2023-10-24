// Same Tree

// Given the roots of two binary trees p and q, write a function to check if they are the same or not.
// Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

// My code: dfs
class Solution {
    boolean same = true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }else if(p == null && q != null){
            return false;
        }else if(q == null && p != null){
            return false;
        }
        dfs(p,q);
        return same;
    }

    public void dfs(TreeNode p, TreeNode q){
        if(p.val != q.val){
            same = false;
        }
        if(p.left != null && q.left != null){
            dfs(p.left, q.left);
        }
        if(p.right != null && q.right != null){
            dfs(p.right, q.right);
        }
        if((p.right == null && q.right != null) || (p.right != null && q.right == null)){
            same = false;
        }
        if((p.left == null && q.left != null) || (p.left != null && q.left == null)){
            same = false;
        }
    }
}