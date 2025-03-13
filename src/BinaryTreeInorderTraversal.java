import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
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

    public List<Integer> inorderTraversal(TreeNode treeNode) {
        Stack<TreeNode> nodeStack = new Stack<>();

        List<Integer> result = new ArrayList<>();
        TreeNode curr = treeNode;

        while (curr != null || !nodeStack.isEmpty()) {
            while(curr != null) {
                nodeStack.push(curr);
                curr = curr.left;
            }
            curr = nodeStack.pop();
            result.add(curr.val);

            curr = curr.right;
        }
        return result;
    }
}
