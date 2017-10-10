/**
Let's define inorder and preorder traversals of a binary tree as follows:

Inorder traversal first visits the left subtree, then the root, then its right subtree;
Preorder traversal first visits the root, then its left subtree, then its right subtree.
For example, if tree looks like this:

    1
   / \
  2   3
 /   / \
4   5   6
then the traversals will be as follows:

Inorder traversal: [4, 2, 1, 5, 3, 6]
Preorder traversal: [1, 2, 4, 3, 5, 6]
Given the inorder and preorder traversals of a binary tree t, but not t itself, restore t and return it.
**/

Tree<Integer> restoreBinaryTree(int[] inorder, int[] preorder) {
    if (inorder == null || preorder == null || preorder.length == 0 ||preorder.length != inorder.length) {
        return new Tree<Integer>(0) ;
    }
    if (preorder.length == 1) return new Tree<Integer>(preorder[0]);
    HashMap<Integer, Integer> map = new HashMap<>();
    int i = 0;
    for (Integer elt : inorder) {
        map.put(elt, i++);
    }
    return helper(preorder, map, 0, 0, preorder.length - 1);
}

Tree<Integer> helper(int [] preorder, HashMap<Integer, Integer> map, int preStart, int inStart, int inEnd) {
    if (preStart >= preorder.length || inStart > inEnd) return null;
    Tree<Integer> root = new Tree<Integer>(preorder[preStart]);
    int inIndex =  map.get(preorder[preStart]);
    root.left = helper(preorder, map, preStart + 1, inStart , inIndex - 1);
    root.right = helper(preorder, map, preStart + inIndex - inStart + 1, inIndex + 1, inEnd  );
    return root;
}