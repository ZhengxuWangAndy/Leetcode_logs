// Construct Binary Tree from Inorder and Postorder Traversal
// Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return recursionTree(map, inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public TreeNode recursionTree(HashMap<Integer, Integer> map, int[] inorder, int[] postorder, int inL, int inR, int postL, int postR){
        if(inL > inR || postL > postR){
            return null;
        }

        int postRoot = postR;
        int inRoot = map.get(postorder[postRoot]);

        TreeNode root = new TreeNode(postorder[postRoot]);

        // left     root    right
        // left     right    root
        int sizeOfLeftSubtree = inRoot - inL;
        root.left = recursionTree(map, inorder, postorder, inL, inRoot-1, postL, postL + sizeOfLeftSubtree - 1);
        root.right = recursionTree(map, inorder, postorder, inRoot+1, inR, postL + sizeOfLeftSubtree, postR-1);

        return root;
    }
}