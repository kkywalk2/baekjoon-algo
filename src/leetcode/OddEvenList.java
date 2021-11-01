package leetcode;

public class OddEvenList {
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
    
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return  head;
        if(head.next == null) return  head;

        ListNode oddList = new ListNode(head.val, null);
        ListNode evenList = new ListNode(head.next.val, null);

        ListNode result = oddList;
        ListNode firstEvenNode = evenList;
        ListNode currentNode = head.next.next;

        int i = 1;
        while (currentNode != null) {
            if(i % 2 == 0) {
                evenList.next = new ListNode(currentNode.val, null);
                evenList = evenList.next;
            } else {
                oddList.next = new ListNode(currentNode.val, null);
                oddList = oddList.next;
            }
            currentNode = currentNode.next;
            i++;
        }

        oddList.next = firstEvenNode;
        return result;
    }
}
