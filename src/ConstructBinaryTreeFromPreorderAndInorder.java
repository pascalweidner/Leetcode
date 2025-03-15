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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeIn(Arrays.stream(preorder).boxed().collect(Collectors.toList()), Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTreeIn(List<Integer> preorder, List<Integer> inorder) {
        if (preorder.isEmpty()) return null;
        int temp = preorder.getFirst();
        if(!inorder.contains(temp)) return null;
        TreeNode curr = new TreeNode(temp);
        List<Integer> sub = preorder.subList(1, preorder.size());
        curr.left = buildTreeIn(preorder.subList(1, preorder.size()), inorder.subList(0, inorder.indexOf(temp)));
        if(curr.left != null) preorder = sub;
        sub = preorder.subList(1, preorder.size());
        curr.right = buildTreeIn(sub, inorder.subList(inorder.indexOf(temp) + 1, inorder.size()));
        if(curr.left != null) preorder = sub;

        return curr;
    }
}
