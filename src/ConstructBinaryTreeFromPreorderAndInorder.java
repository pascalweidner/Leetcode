import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ConstructBinaryTreeFromPreorderAndInorder {
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

    public int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeIn(preorder, Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTreeIn(int[] preorder, List<Integer> inorder) {
        if (preorder.length <= index) return null;
        int temp = preorder[index];
        if(!inorder.contains(temp)) {
            index--;
            return null;
        }
        TreeNode curr = new TreeNode(temp);
        index++;
        curr.left = buildTreeIn(preorder, inorder.subList(0, inorder.indexOf(temp)));
        index++;
        curr.right = buildTreeIn(preorder, inorder.subList(inorder.indexOf(temp) + 1, inorder.size()));

        return curr;
    }
}
