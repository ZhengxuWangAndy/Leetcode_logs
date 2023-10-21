// Binary Search Tree Iterator


// Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):

// BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
// boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
// int next() Moves the pointer to the right, then returns the number at the pointer.
// Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.

// You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.


// use stack to save itermediate roots and get most left
class BSTIterator {
    Deque<TreeNode> stack = new LinkedList<>();
    TreeNode cur;

    public BSTIterator(TreeNode root) {
        cur = root;
    }
    
    public int next() {
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }
    
    public boolean hasNext() {
        if(!stack.isEmpty() || cur != null){
            return true;
        }else{
            return false;
        }
    }
}


// low level inOrder:

class BSTIterator {

    List<Integer> list = new ArrayList<>();
    int cur;
    public BSTIterator(TreeNode root) {
        cur = 0;
        inOrder(root);
    }

    public void inOrder(TreeNode node){
        if(node == null){
            return;
        }
        inOrder(node.left);
        list.add(node.val);
        inOrder(node.right);
    }
    
    public int next() {
        cur++;
        return list.get(cur-1);
    }
    
    public boolean hasNext() {
        return cur < list.size();
    }
}