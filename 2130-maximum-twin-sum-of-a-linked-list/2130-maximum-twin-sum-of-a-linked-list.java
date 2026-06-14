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
    public int pairSum(ListNode head) {

        // find middle
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // reverse second half
        ListNode head2 = reverse(slow);   // <-- FIX HERE

        int maxSum = 0;
        ListNode head1 = head;

        while (head2 != null) {
            int sum = head1.val + head2.val;
            maxSum = Math.max(maxSum, sum);
            head1 = head1.next;
            head2 = head2.next;
        }

        return maxSum;
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
        }
        return prev;
    }
}
