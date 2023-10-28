// Flatten Binary Tree to Linked List

// Given the root of a binary tree, flatten the tree into a "linked list":

// The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list and the left child pointer is always null.
// The "linked list" should be in the same order as a pre-order traversal of the binary tree.

// my code: use preorder traverse to create a list and generate
// O(n) and O(n)
class Solution {
    ArrayList<Integer> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        dfs(root);
        TreeNode p = root;
        for(int i = 1; i < list.size(); i++){
            p.right = new TreeNode(list.get(i));
            p.left = null;
            p = p.right;
        }
        // return root;
    }

    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        list.add(node.val);
        dfs(node.left);
        dfs(node.right);
    }
}

// Better way:
public void flatten(TreeNode root) {
    while (root != null) { 
        //左子树为 null，直接考虑下一个节点
        if (root.left == null) {
            root = root.right;
        } else {
            // 找左子树最右边的节点
            TreeNode pre = root.left;
            while (pre.right != null) {
                pre = pre.right;
            } 
            //将原来的右子树接到左子树的最右边节点
            pre.right = root.right;
            // 将左子树插入到右子树的地方
            root.right = root.left;
            root.left = null;
            // 考虑下一个节点
            root = root.right;
        }
    }
}

// Another Better way: use postorder
private TreeNode pre = null;

public void flatten(TreeNode root) {
    if (root == null)
        return;
    flatten(root.right);
    flatten(root.left);
    root.right = pre;
    root.left = null;
    pre = root;
}
