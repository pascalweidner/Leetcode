import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {
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

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> current = new ArrayDeque<>();
        Deque<TreeNode> nextLevel = new ArrayDeque<>();
        current.add(root);

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currLevel = new ArrayList<>();

        while (!current.isEmpty()) {
            TreeNode curr = current.pollFirst();
            currLevel.add(curr.val);

            if(curr.left != null) nextLevel.addLast(curr.left);
            if(curr.right != null) nextLevel.addLast(curr.right);

            if(current.isEmpty()) {
                result.add(currLevel);
                currLevel = new ArrayList<>();
                current = nextLevel;
                nextLevel = new ArrayDeque<>();
            }
        }

        return result;
    }
}
