// Kth Smallest Element in a BST

// Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

// My code: in-order traverse
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
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list);
        return list.get(k-1);
    }

    public ArrayList<Integer> dfs(TreeNode node, ArrayList<Integer> list){
        if(node != null){
            if(node.left != null){
                dfs(node.left, list);
            }
            list.add(node.val);
            if(node.right != null){
                dfs(node.right, list);
            }
        }
        return list;
    }
}


// My better solution: only traverse k elements
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        dfs(root, list, k);
        return list.get(k-1);
    }

    public void dfs(TreeNode node, ArrayList<Integer> list, int k){
        if(node != null){
            if(node.left != null){
                dfs(node.left, list, k);
            }
            list.add(node.val);
            if(list.size() == k){
                return;
            }
            if(node.right != null){
                dfs(node.right, list, k);
            }
        }
    }
}

// Official code: using stack to done the traverse, a good example of stack traversing
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()){
            while(root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            k--;
            if(k == 0){
                break;
            }
            root = root.right;
        }


        return root.val;

    }
}