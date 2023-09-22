
// 109. Convert Sorted List to Binary Search Tree
// Given the head of a singly linked list where elements are sorted in ascending order, convert it to a height-balanced binary search tree.

// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

// Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
 
class Solution {
    public ListNode getMid(ListNode left, ListNode right){
      
      ListNode slow = left;
      ListNode fast = left;
      if (left == right){
        return null;
      }
      int temp = 0;
      while (fast.next != null && fast != right){
        // fast and slow pointer
        // ****fast != right keeps the right boudary!
        fast = fast.next;
        temp += 1;
        if (temp % 2 == 0){
          slow = slow.next;
        }
      }
      return slow;
    }

    public TreeNode buildTree(ListNode left, ListNode right){
      if (left == right){
        return null;
      }
      ListNode mid = getMid(left, right);
      TreeNode root = new TreeNode(mid.val);
      
      root.left = buildTree(left, mid);
      root.right = buildTree(mid.next, right);

      return root;
    }

    public TreeNode sortedListToBST(ListNode head) {


      // ListNode tail = new ListNode();
      // while(head.next != null){
      //   tail = head.next;
      // }
      
      return buildTree(head, null);
      // ****the real right boudary is null instead of tail!

        
    }
}