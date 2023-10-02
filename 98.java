// Validate Binary Search Tree

// Given the root of a binary tree, determine if it is a valid binary search tree (BST).

// A valid BST is defined as follows:

// *** The left subtree of a node contains only nodes with keys less than the node's key.
// *** The right subtree of a node contains only nodes with keys greater than the node's key.
// *** Both the left and right subtrees must also be binary search trees.


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

 // Check on every node(root), is it exceed upper bond or lower bond. No need to check his children
 // Remember the concept of subtree

 // Remember the constrains:
 // Int : -2^31 to 2^31 - 1  4 bytes
 // Long : -2^63 to 2^63 - 1  8 bytes
 // Double : 8 bytes
 // Float : 4 bytes


class Solution {
    public boolean check(TreeNode root, long upper, long lower){
        // if no left or right child
        if(root == null){
            return true;
        }
        // exceed bond
        if(root.val >= upper || root.val <= lower){
            return false;
        }

        // recursion of sub-trees
        return check(root.left, root.val, lower) && check(root.right, upper, root.val);

    }
    public boolean isValidBST(TreeNode root) {
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
}

// inorder tree walk 
// The inorder of a BST is a increasing list

class Solution {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
              // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}




// Not a good way at all!

// class Solution {


//     public boolean check(TreeNode root, int leftMax, int rightMin){

//         if (root.val < leftMax || root.val > rightMin){
//             return false;
//         }

//         if(root.left != null && root.right == null){
//             if(root.left.val < root.val && root.left.val < rightMin){
//                 return check(root.left, Math.max(leftMax, root.left.val), rightMin);
//             }else{
//                 return false;
//             }
//         }

//         if(root.right != null && root.left == null){
//             if(root.right.val > root.val && root.right.val > leftMax){
//                 return check(root.right, leftMax, Math.min(root.right.val, rightMin));
//             }else{
//                 return false;
//             }
//         }

//         if(root.right != null && root.left != null){
//             if(root.right.val > root.val && root.left.val < root.val && root.right.val > leftMax && root.left.val < rightMin){
//                 return check(root.right, Math.max(leftMax, root.left.val), Math.min(rightMin, root.right.val)) && check(root.left, Math.max(leftMax, root.left.val), Math.min(rightMin, root.right.val));
//             }else{
//                 return false;
//             }
//         }

//         return true;
//     }
//     public boolean isValidBST(TreeNode root) {

//         return check(root, root.val, root.val);
//     }

// }