/*
Given a singly linked list of integers l and a non-negative integer n, move the last n list nodes to the beginning of the linked list.

Example

For l = [1, 2, 3, 4, 5] and n = 3, the output should be
rearrangeLastN(l, n) = [3, 4, 5, 1, 2];
For l = [1, 2, 3, 4, 5, 6, 7] and n = 1, the output should be
rearrangeLastN(l, n) = [7, 1, 2, 3, 4, 5, 6]
*/

ListNode<Integer> rearrangeLastN(ListNode<Integer> l, int n) {
 if (n < 1 || l == null) return l;
    
    ListNode<Integer> slow = l, fast = l;
    
    for (int i = 0; i < n; i++) {
      fast = fast.next;
    }
  
    if (fast == null) return l;
  
    while (fast.next != null) {
     slow = slow.next;
     fast = fast.next;
    }
    
    ListNode<Integer> result = slow.next;
    slow.next = null;
    fast.next = l;
  return result;
}