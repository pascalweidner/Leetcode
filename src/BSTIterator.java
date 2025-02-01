import java.util.Stack;

public class BSTIterator {
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

    private final Stack<TreeNode> next;

    public BSTIterator(TreeNode root) {
        next = new Stack<>();
        inorderMostLeft(root);
    }

    private void inorderMostLeft(TreeNode root) {
        if(root == null) return;
        next.push(root);
        if(root.left == null) return;
        inorderMostLeft(root.left);
    }

    public int next() {
        if(!hasNext()) throw new IllegalArgumentException();
        TreeNode curr = next.pop();
        int val = curr.val;
        inorderMostLeft(curr.right);
        return val;
    }

    public boolean hasNext() {
        return !next.isEmpty();
    }
}
