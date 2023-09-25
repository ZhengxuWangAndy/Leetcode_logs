
// Merge k Sorted Lists

// You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
// Merge all the linked-lists into one sorted linked-list and return it.

// Example 1:

// Input: lists = [[1,4,5],[1,3,4],[2,6]]
// Output: [1,1,2,3,4,4,5,6]
// Explanation: The linked-lists are:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// merging them into one sorted list:
// 1->1->2->3->4->4->5->6


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


// my code: get each list's first, find smallest to add to new nodelist
class Solution {

    public Boolean checkEmpty(ListNode[] lists){
        for (int i = 0; i < lists.length; i++){
            if(lists[i] != null){
                return true;
            }
        }
        return false;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pointer = new ListNode();
        ListNode ans = pointer;



        if(lists.length < 1){
            return null;
        }
        
        while(checkEmpty(lists)){
            int smallest = Integer.MAX_VALUE;
            int idx = 0;
            for (int i = 0; i < lists.length; i++){
                if (lists[i] != null){
                    if (lists[i].val < smallest){
                        idx = i;
                        smallest = lists[i].val;
                    }
                }
            }
            lists[idx] = lists[idx].next;
            ListNode tmp = new ListNode(smallest);
            pointer.next = tmp;
            pointer = pointer.next;
        }

        return ans.next;
    }
}


// better way: Using PriorityQueue, implement the PriorityQueue's Comparable interfacte, DIY new Status use for compare element's priority
class Solution {
    class Status implements Comparable<Status> {
        int val;
        ListNode ptr;

        Status(int val, ListNode ptr) {
            this.val = val;
            this.ptr = ptr;
        }

        public int compareTo(Status status2) {
            return this.val - status2.val;
        }
    }

    PriorityQueue<Status> queue = new PriorityQueue<Status>();

    public ListNode mergeKLists(ListNode[] lists) {
        for (ListNode node: lists) {
            if (node != null) {
                queue.offer(new Status(node.val, node));
            }
        }
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (!queue.isEmpty()) {
            Status f = queue.poll();
            tail.next = f.ptr;
            tail = tail.next;
            if (f.ptr.next != null) {
                queue.offer(new Status(f.ptr.next.val, f.ptr.next));
            }
        }
        return head.next;
    }
}

