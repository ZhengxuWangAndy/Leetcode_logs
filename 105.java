// Construct Binary Tree from Preorder and Inorder Traversal

// Given two integer arrays preorder and inorder where preorder is the preorder traversal of a binary tree and inorder is the inorder traversal of the same tree, construct and return the binary tree.


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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0 ; i < preorder.length; i++){
            map.put(inorder[i], i);
        }
        return recursionTree(map, preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    public TreeNode recursionTree(HashMap<Integer, Integer> map, int[] preorder, int[] inorder, int preL, int preR, int inL, int inR){
        if (preL > preR || inL > preL){
            return null;
        }
        // find root index in preorder
        int preRoot = preL;
        // find root index in inorder
        int inRoot = map.get(preorder[preRoot]);

        // Create root
        TreeNode root = new TreeNode(preorder[preRoot]);

        int sizeOfLeftSubtree = inRoot - inL;
        root.left = recursionTree(map, preorder, inorder, preL+1, preL + sizeOfLeftSubtree, inL, inRoot - 1);

        root.right = recursionTree(map, preorder, inorder, preL + sizeOfLeftSubtree + 1, preR, inRoot+1, inR);

        return root;
    }
}