package net.go.medium;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse
 * order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
 *
 * @author gaochuanjun
 * @since 2017/2/28
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int flag = 0;
        int val = l1.val + l2.val + flag;
        if (val > 9) {
            val = val - 10;
            flag = 1;
        } else {
            flag = 0;
        }
        ListNode listNode = new ListNode(val);
        ListNode nextNode = listNode;
        while (l1 != null || l2 != null) {
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (l1 != null || l2 != null) {
                val = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + flag;
                if (val > 9) {
                    val = val - 10;
                    flag = 1;
                } else {
                    flag = 0;
                }
                nextNode.next = new ListNode(val);
                nextNode = nextNode.next;
            }
        }

        if (flag == 1) {
            nextNode.next = new ListNode(1);
        }
        return listNode;
    }

    public static void main(String[] args) {
        AddTwoNumbers addTwoNumbers = new AddTwoNumbers();
        //ListNode l1 = new ListNode(2);
        //l1.next = new ListNode(4);
        //l1.next.next = new ListNode(3);
        //ListNode l2 = new ListNode(5);
        //l2.next = new ListNode(6);
        //l2.next.next = new ListNode(4);

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(8);
        ListNode l2 = new ListNode(0);
        ListNode listNode = addTwoNumbers.addTwoNumbers(l1, l2);
        System.out.print(listNode.val);
        while (listNode.next != null) {
            System.out.print(" -> " + listNode.next.val);
            listNode = listNode.next;
        }
    }
}

class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

