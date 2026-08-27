class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null  || k ==0){
            return head;
        }


        int  length = 0;
        ListNode tail = head;
        while(tail!=null){
            tail = tail.next;
            length++;
        }

        k %= length;

        if(k==0){
            return head;
        }

        ListNode fast = head;
        ListNode slow = head;
        for(int i =0;i<k;i++){
            fast = fast.next;
        }
        while(fast.next!=null){
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newhead = slow.next;
        slow.next = null;
        fast.next = head;
        return newhead;
    }
}