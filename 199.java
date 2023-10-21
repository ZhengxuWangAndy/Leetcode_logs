// Binary Tree Right Side View

// Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// My code: BFS + Queue to traverse and get the last item will be the most right one.
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> all = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if(root == null){
            return list;
        }

        que.add(root);
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = que.size();

            for(int i = 0; i < size; i++){
                TreeNode node = que.poll();
                level.add(node.val);
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }

            all.add(level);
        }

        for(int i = 0; i < all.size(); i++){
            list.add(all.get(i).get(all.get(i).size() - 1));
        }
        return list;
    }
}


// Official DFS code: get the right subtree first will lead to getting most right value.
class Solution {
    List<Integer> res = new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0); // 从根节点开始访问，根节点深度是0
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        // 先访问 当前节点，再递归地访问 右子树 和 左子树。
        if (depth == res.size()) {   // 如果当前节点所在深度还没有出现在res里，说明在该深度下当前节点是第一个被访问的节点，因此将当前节点加入res中。
            res.add(root.val);
        }
        depth++;
        dfs(root.right, depth);
        dfs(root.left, depth);
    }
}
