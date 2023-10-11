// Reverse Linked List

// Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


 // my code, used stack to reverse
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null || left == right){
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pointer = dummy;
        ListNode start = dummy;
        int pos = 1;
        Deque<ListNode> stack = new LinkedList<>();
        ListNode tail = null;
        while(pointer != null){
            if(pointer.next!=null){
                pointer = pointer.next;
            }


            if (pos < left){
                start = pointer;
            }

            if(pos >= left && pos <= right){
                stack.push(pointer);
            }

            if(pos > right){
                break;
            }

            if(pos == right && pointer.next == null){
                pointer = null;
            }


            pos += 1;

        }

        System.out.println(stack.size());
        ListNode prev = stack.pop();
        prev.next = null;
        start.next = prev;
        ListNode cur = new ListNode();
        while(!stack.isEmpty()){
            cur = stack.pop();
            cur.next = null;
            prev.next = cur;
            prev = cur;
        }
        cur.next = pointer;
        return dummy.next;
    }
}
