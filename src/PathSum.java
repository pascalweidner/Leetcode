
public class PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root == null) return false;
        int newSum = targetSum - root.val;
        if(root.right == null && root.left == null) return newSum == 0;

        return hasPathSum(root.left, newSum) || hasPathSum(root.right, newSum);
    }
}
