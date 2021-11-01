package leetcode;

import java.util.HashMap;

public class GetIntersectionNode {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode, Integer> map = new HashMap<>();

        while (headA != null) {
            map.put(headA, 0);
            headA = headA.next;
        }

        while (headB != null) {
            if (map.get(headB) != null) {
                return headB;
            }
            headB = headB.next;
        }

        return null;
    }
}
