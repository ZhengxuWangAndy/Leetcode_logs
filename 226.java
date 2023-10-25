// Invert Binary Tree

// Given the root of a binary tree, invert the tree, and return its root.


// My code use stack to implement dfs
class Solution {
    public TreeNode invertTree(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        if(root == null){
            return root;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            TreeNode l = node.left;
            TreeNode r = node.right;
            node.left = r;
            node.right = l;
            if(node.left != null){
                stack.push(node.left);
            }
            if(node.right != null){
                stack.push(node.right);
            }
        }
        return root;
    }
}


// Official code: use recursion to implement this
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        root.left = r;
        root.right = l;
        return root;
    }
}