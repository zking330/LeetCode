package 两数相加;

public class Solution {

    public static void main(String[] args) {
        ListNode nod1 = new ListNode(2);
        ListNode nod2 = new ListNode(4);
        ListNode nod3 = new ListNode(3);
        ListNode nod4 = new ListNode(5);
        ListNode nod5 = new ListNode(6);
        ListNode nod6 = new ListNode(4);

        nod2.next = nod3;
        nod1.next = nod2;
        nod4.next = nod5;
        nod5.next = nod6;

        addTwoNumbers(nod1, nod4);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int sum = num1 + num2 + carry;
            carry = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (l1 != null) {
                l1 = l1.next;
            }

            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }

        return result.next;
    }
}
