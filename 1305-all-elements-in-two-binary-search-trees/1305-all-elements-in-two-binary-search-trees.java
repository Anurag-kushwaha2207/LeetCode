class Solution {
    /**
     * Retrieves all elements from two binary search trees in sorted order.
     * 
     * @param root1 The root of the first binary search tree
     * @param root2 The root of the second binary search tree
     * @return A list containing all elements from both trees in ascending order
     */
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        // Lists to store inorder traversal of each tree
        List<Integer> tree1Elements = new ArrayList<>();
        List<Integer> tree2Elements = new ArrayList<>();
      
        // Perform inorder traversal on both trees to get sorted elements
        inorderTraversal(root1, tree1Elements);
        inorderTraversal(root2, tree2Elements);
      
        // Get sizes of both lists for iteration
        int size1 = tree1Elements.size();
        int size2 = tree2Elements.size();
      
        // Initialize pointers for merging
        int pointer1 = 0;
        int pointer2 = 0;
      
        // Result list to store merged elements
        List<Integer> mergedResult = new ArrayList<>();
      
        // Merge two sorted lists using two-pointer technique
        while (pointer1 < size1 && pointer2 < size2) {
            if (tree1Elements.get(pointer1) <= tree2Elements.get(pointer2)) {
                mergedResult.add(tree1Elements.get(pointer1));
                pointer1++;
            } else {
                mergedResult.add(tree2Elements.get(pointer2));
                pointer2++;
            }
        }
      
        // Add remaining elements from first list if any
        while (pointer1 < size1) {
            mergedResult.add(tree1Elements.get(pointer1));
            pointer1++;
        }
      
        // Add remaining elements from second list if any
        while (pointer2 < size2) {
            mergedResult.add(tree2Elements.get(pointer2));
            pointer2++;
        }
      
        return mergedResult;
    }

    /**
     * Performs inorder traversal on a binary tree and stores elements in a list.
     * Inorder traversal visits nodes in ascending order for BST.
     * 
     * @param root The root node of the binary tree
     * @param elements The list to store traversed elements
     */
    private void inorderTraversal(TreeNode root, List<Integer> elements) {
        // Base case: if node is null, return
        if (root == null) {
            return;
        }
      
        // Traverse left subtree
        inorderTraversal(root.left, elements);
      
        // Process current node
        elements.add(root.val);
      
        // Traverse right subtree
        inorderTraversal(root.right, elements);
    }
}
