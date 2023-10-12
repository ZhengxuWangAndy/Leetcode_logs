// Palindrome list

// Check if a singly linked list is a Palindrome.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // My code: fast slow pointer, O(n) O(n)
class Solution {
    public boolean isPalindrome(ListNode head) {
        List<Integer> prefix = new ArrayList<>();
        ListNode slow = head;
        ListNode fast = head;
        int length = 1;
        if(head == null){
            return true;
        }
        while(fast.next != null){
            prefix.add(slow.val);
            fast = fast.next;
            slow = slow.next;
            length++;
            if (fast.next != null){
                fast = fast.next;
                length++;
            }
        }
        if(length % 2 != 0 && length > 2){
            slow = slow.next;
        }
        for(int i = prefix.size() - 1; i >= 0; i--){
            if(slow.val == prefix.get(i)){
                slow = slow.next;
            }else{
                return false;
            }
        }
        return true;
    }
}



// official solution: fast slow pointer and reverse the last half to compare. O(n) O(1)

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }        

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
