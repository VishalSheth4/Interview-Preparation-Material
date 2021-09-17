
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        for(int i = 0; i<n; i++){
            if(second.next != null){
                second = second.next;
            }else{
                if(i==n-1){
                    head = head.next;
                    return head;
                }
                return null;
            }
        }
        while(second.next!=null){
            first = first.next;
            second = second.next;
        }
        first.next = first.next.next;
        return head;
    }
}
