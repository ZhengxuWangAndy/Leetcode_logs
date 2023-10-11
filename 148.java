// Sort List

// Given the head of a linked list, return the list after sorting it in ascending order.
// sort a singly linked list

//My code: convert to array and create a new linked list.

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
class Solution {
    public ListNode sortList(ListNode head) {
        List<Integer> nums = new ArrayList<Integer>();
        while(head != null){
            nums.add(head.val);
            head = head.next;
        }
        // Arrays.sort(nums);
        Collections.sort(nums);
        ListNode pointer = new ListNode();
        ListNode result = pointer;
        for(int i = 0; i < nums.size(); i++){
            ListNode tmp = new ListNode(nums.get(i));
            pointer.next = tmp;
            pointer = pointer.next;
        }

        return result.next;
    }
}


// merge sort, from top
class Solution {
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null){
            return head;
        }
        if (head.next == tail){
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail){
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummyHead = new ListNode();
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val){
                temp.next = temp1;
                temp1 = temp1.next;
            }
            else{
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if(temp1 != null){
            temp.next = temp1;
        }
        if(temp2 != null){
            temp.next = temp2;
        }

        return dummyHead.next;
    }
}