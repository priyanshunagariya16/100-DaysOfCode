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
    public ListNode rotateRight(ListNode head, int k) {
        ListNode cur=head;
        if(k==0) return head;
        if(head==null) return head;
        int l=0;
        while(cur!=null){
            l++;
            cur=cur.next;
        }
        // System.out.println(l);
        cur=head;
        if(k>l) k=k%l;
        k=l-k;
        if(k==0) return head;
        // System.out.println(k);
        int i=1;
        while(i<k){
            cur=cur.next;
            i++;
        }
        if(cur==null || cur.next==null) return head;
        ListNode newhead=cur.next;
        cur.next=null;
        ListNode newcur=newhead;
        while(newcur.next!=null){
            newcur=newcur.next;
        }
        newcur.next=head;
        head=newhead;
        return head;
    }
}