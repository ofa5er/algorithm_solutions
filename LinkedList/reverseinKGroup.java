/*
Given a linked list l, reverse its nodes k at a time and return the modified list. k is a positive integer that is less than or equal to the length of l. If the number of nodes in the linked list is not a multiple of k, then the nodes that are left out at the end should remain as-is.

You may not alter the values in the nodes - only the nodes themselves can be changed.

Example

For l = [1, 2, 3, 4, 5] and k = 2, the output should be
reverseNodesInKGroups(l, k) = [2, 1, 4, 3, 5];
For l = [1, 2, 3, 4, 5] and k = 1, the output should be
reverseNodesInKGroups(l, k) = [1, 2, 3, 4, 5];
For l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11] and k = 3, the output should be
reverseNodesInKGroups(l, k) = [3, 2, 1, 6, 5, 4, 9, 8, 7, 10, 11].
*/
ListNode<Integer> reverseNodesInKGroups(ListNode<Integer> l, int k) {

    ListNode<Integer> result = new ListNode<Integer>(0);
    result.next = l;
    ListNode<Integer> begin = result;
    int i = 0;
    while (l != null) {
        i++;
        if (i%k == 0) {
            begin = reverse(begin,l.next);
            l = begin.next;
        } else {
            l = l.next;
        }
    }

    return result.next;
}

private ListNode<Integer> reverse(ListNode<Integer> begin, ListNode<Integer> end) {
    ListNode<Integer> curr = begin.next, next = null, prev = begin, first = curr;
    while (curr != end) {
        next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = next;
    }
    
	begin.next = prev;
	first.next = curr;
	return first;
}