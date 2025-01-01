import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class FindLargestValueInEachTreeRow {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> largestValues(TreeNode root) {
        if(root == null) return new ArrayList<>();
        Queue<TreeNode> nodeQueue = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();

        nodeQueue.add(root);

        int count = 1;
        int maxRow = Integer.MIN_VALUE;

        while(!nodeQueue.isEmpty()) {
            if(count == 0) {
                res.add(maxRow);
                maxRow = Integer.MIN_VALUE;
                count = nodeQueue.size();
            }

            TreeNode curr = nodeQueue.poll();
            if(curr.left != null) nodeQueue.add(curr.left);
            if(curr.right != null) nodeQueue.add(curr.right);

            if (curr.val > maxRow) maxRow = curr.val;
            count--;
        }

        res.add(maxRow);

        return res;
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(5);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(9);
        TreeNode t4 = new TreeNode(3, t1, t2);
        TreeNode t5 = new TreeNode(2, null, t3);
        TreeNode root = new TreeNode(1, null, t5);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        System.out.println(t.largestValues(root));
    }
}
