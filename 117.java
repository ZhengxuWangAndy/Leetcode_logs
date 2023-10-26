// Populating next right pointer in each node


// Given a binary tree

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
// Initially, all next pointers are set to NULL.


// use bfs to link
class Solution {
    public Node connect(Node root) {
        Queue<Node> que = new LinkedList<>();
        if(root == null){
            return root;
        }
        que.add(root);
        while(!que.isEmpty()){
            Node pre = null;
            int size = que.size();
            for(int i = 0; i < size; i++){
                Node node = que.poll();
                if(pre != null){
                    pre.next = node;
                }
                pre = node;
                if(node.left != null){
                que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }
        }

        return root;
    }
}