package leetcode;

public class AddTwoNumbers {
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int valResult = l1.val + l2.val;
        boolean isPromote = valResult > 9 ? true : false;
        ListNode result = new ListNode(valResult % 10, null);
        ListNode currentNode = result;

        while (l1.next != null || l2.next != null || isPromote) {
            if (l1.next != null && l2.next != null) {
                l1 = l1.next;
                l2 = l2.next;
                valResult = isPromote ? l1.val + l2.val + 1 : l1.val + l2.val;
                isPromote = valResult > 9 ? true : false;
                currentNode.next = new ListNode(valResult % 10, null);
                currentNode = currentNode.next;
            } else if (l1.next != null) {
                l1 = l1.next;
                valResult = isPromote ? l1.val + 1 : l1.val;
                isPromote = valResult > 9 ? true : false;
                currentNode.next = new ListNode(valResult % 10, null);
                currentNode = currentNode.next;
            } else if (l2.next != null) {
                l2 = l2.next;
                valResult = isPromote ? l2.val + 1 : l2.val;
                isPromote = valResult > 9 ? true : false;
                currentNode.next = new ListNode(valResult % 10, null);
                currentNode = currentNode.next;
            } else {
                currentNode.next = new ListNode(1, null);
                isPromote = false;
            }
        }
        return result;
    }
}
