class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        this.val = x;
    }
}

public class AddTwoNums {
    public ListNode addTwoNums(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;
        for (ListNode i = l1, j = l2; i != null || j != null; ) {
            int sum = carry;
            sum += (i != null) ? i.val : 0;
            sum += (j != null) ? j.val : 0;

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
            i = (i != null) ? i.next : i;
            j = (j != null) ? j.next : j;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
