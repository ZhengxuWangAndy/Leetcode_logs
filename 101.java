// Symmetric Tree
// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

// use dfs to check symmetric
class Solution {
    boolean isSym = true;
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        if(root.left == null && root.right == null){
            return true;
        }
        if(root.left == null || root.right == null){
            return false;
        }

        dfs(root.left, root.right);
        return isSym;
    }

    public void dfs(TreeNode l, TreeNode r){
        if(l == null && r == null){
            return;
        }
        if(l == null || r == null){
            isSym = false;
            return;
        }
        if(l.val == r.val){
            dfs(l.left, r.right);
            dfs(l.right, r.left);
        }else{
            isSym = false;
            return;
        }
    }
}



// another way: use stack to record there children nodes
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return check(root, root);
    }

    public boolean check(TreeNode u, TreeNode v) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(u);
        q.offer(v);
        while (!q.isEmpty()) {
            u = q.poll();
            v = q.poll();
            if (u == null && v == null) {
                continue;
            }
            if ((u == null || v == null) || (u.val != v.val)) {
                return false;
            }

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
