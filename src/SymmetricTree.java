
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class SymmetricTree {
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

    public boolean isSymmetric(TreeNode root) {
        if(root == null) return true;
        return isSymmetric(root.left != null ? List.of(root.left) : List.of(), root.right != null ? List.of(root.right): List.of());
    }

    private boolean isSymmetric(List<TreeNode> left, List<TreeNode> right) {
        if (!isEqual(left, right)) return false;

        if(isNull(left) && isNull(right)) return true;

        List<TreeNode> newLeft = left.stream().<TreeNode>mapMulti((node, consumer) -> {
            if(node != null) {
                consumer.accept(node.left);
                consumer.accept(node.right);
            } else {
                consumer.accept(null);
                consumer.accept(null);
            }
        }).toList();
        List<TreeNode> newRight = right.stream().<TreeNode>mapMulti((node, consumer) -> {
            if(node != null) {
                consumer.accept(node.right);
                consumer.accept(node.left);
            } else {
                consumer.accept(null);
                consumer.accept(null);
            }
        }).toList();

        return isSymmetric(newLeft, newRight);
    }

    private boolean isNull(List<TreeNode> list) {
        return list.stream().allMatch(Objects::isNull);
    }

    private boolean isEqual(List<TreeNode> left, List<TreeNode> right) {
        if(left.size() != right.size()) return false;

        for (int i = 0; i < left.size(); i++) {
            if(left.get(i) == null ^ right.get(i) == null) return false;
            if(left.get(i) == null && right.get(i) == null) continue;
            if(left.get(i).val != right.get(i).val) return false;
        }

        return true;
    }
}
