import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Deque<TreeNode> layer = new ArrayDeque<>();
        Deque<TreeNode> nextLayer = new ArrayDeque<>();

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currList = new ArrayList<>();

        boolean fromRight = false;

        layer.addLast(root);
        while (!layer.isEmpty()) {
            TreeNode curr = fromRight ? layer.pollLast() : layer.pollFirst();
            currList.add(curr.val);

            if(!fromRight) {
                if (curr.left != null) nextLayer.addLast(curr.left);
                if (curr.right != null) nextLayer.addLast(curr.right);
            } else {
                if(curr.right != null) nextLayer.addFirst(curr.right);
                if(curr.left != null) nextLayer.addFirst(curr.left);
            }

            if(layer.isEmpty()) {
                result.add(currList);
                currList = new ArrayList<>();
                fromRight = !fromRight;
                layer = nextLayer;
                nextLayer = new ArrayDeque<>();
            }
        }

        return result;
    }
}
