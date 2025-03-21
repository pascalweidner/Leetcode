public class SumOfRootToLeafBinaryNumbers {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public int sumRootToLeaf(TreeNode root) {
        return sumRootToLeaf(root, 0);
    }

    public int sumRootToLeaf(TreeNode root, int val) {
        if(root == null) return 0;
        val = val * 2 + root.val;
        return root.left == root.right ? val : sumRootToLeaf(root.left, val) + sumRootToLeaf(root.right, val);
    }
}
