package com.lullaby.link.lc2;

import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean isAdvance = false;
        int addVal = (l1.val + l2.val) % 10;
        if (l1.val + l2.val >= 10) {
            isAdvance = true;
        }
        ListNode first = new ListNode(addVal);
        ListNode p = first;
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            addVal = isAdvance ? l1.val + l2.val + 1 : l1.val + l2.val;
            if (addVal >= 10) {
                addVal %= 10;
                isAdvance = true;
            } else {
                isAdvance = false;
            }
            p.next = new ListNode(addVal);
            p = p.next;
        }
        while (l1.next != null) {
            l1 = l1.next;
            addVal = isAdvance ? l1.val + 1 : l1.val;
            if (addVal >= 10) {
                addVal %= 10;
                isAdvance = true;
            } else {
                isAdvance = false;
            }
            p.next = new ListNode(addVal);
            p = p.next;
        }
        while (l2.next != null) {
            l2 = l2.next;
            addVal = isAdvance ? l2.val + 1 : l2.val;
            if (addVal >= 10) {
                addVal %= 10;
                isAdvance = true;
            } else {
                isAdvance = false;
            }
            p.next = new ListNode(addVal);
            p = p.next;
        }

        if (isAdvance) {
            p.next = new ListNode(1);
        }

        return first;
    }
}
