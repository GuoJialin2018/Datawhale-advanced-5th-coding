
public class mergeTwoList_leetcode_21 {
	 public class ListNode {
	    int val;
		ListNode next;
		ListNode(int x) { val = x; }
}
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummpyhead=new ListNode(0);
        ListNode cur=dummpyhead;
        while(l1!=null &&l2!=null){
            if(l1.val<l2.val){
                cur.next=l1;
                l1=l1.next;
                cur=cur.next;
            }else{
                cur.next=l2;
                l2=l2.next;
                cur=cur.next;
            }
        }
        if(l1==null){
            cur.next=l2;
        }else{
            cur.next=l1;
        }
        return dummpyhead.next;
            
    }
}
