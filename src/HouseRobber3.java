public class HouseRobber3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.right = right;
            this.left = left;
        }
    }

    public int rob(TreeNode root) {
        return 0;
    }

    public int[] robTrac(TreeNode curr) {
        if(curr == null) return new int[]{0, 0, 0};
        int[] left = robTrac(curr.left);
        int[] right = robTrac(curr.right);
        return null;

    }
}
