// Count Complete Tree Nodes

// Given the root of a complete binary tree, return the number of the nodes in the tree.
// According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
// Design an algorithm that runs in less than O(n) time complexity.

// keep check the left sub tree and right sub tree to find the excat not full binary tree
class Solution {
    public int countNodes(TreeNode root) {
        TreeNode nodeR = root;
        TreeNode nodeL = root;
        int rh = 1;
        int lh = 1;
        if(root == null){
            return 0;
        }
        while(nodeR.right != null){
            nodeR = nodeR.right;
            rh += 1;
        }

        while(nodeL.left != null){
            nodeL = nodeL.left;
            lh += 1;
        }
        if(rh == lh){
            return (int) Math.pow(2, rh) - 1;
        }
        else{
            return countNodes(root.left) + countNodes(root.right) + 1;
        }


    }
}