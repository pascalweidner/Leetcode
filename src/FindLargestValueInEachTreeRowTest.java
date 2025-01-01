import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
class FindLargestValueInEachTreeRowTest {
    FindLargestValueInEachTreeRow t;

    @BeforeEach
    void setUp() {
        t = new FindLargestValueInEachTreeRow();
    }

    @Test
    void largestValuesBalanced() {
        FindLargestValueInEachTreeRow.TreeNode t1 = new FindLargestValueInEachTreeRow.TreeNode(5);
        FindLargestValueInEachTreeRow.TreeNode t2 = new FindLargestValueInEachTreeRow.TreeNode(3);
        FindLargestValueInEachTreeRow.TreeNode t3 = new FindLargestValueInEachTreeRow.TreeNode(9);
        FindLargestValueInEachTreeRow.TreeNode t31 = new FindLargestValueInEachTreeRow.TreeNode(7);
        FindLargestValueInEachTreeRow.TreeNode t4 = new FindLargestValueInEachTreeRow.TreeNode(3, t1, t2);
        FindLargestValueInEachTreeRow.TreeNode t5 = new FindLargestValueInEachTreeRow.TreeNode(2, t31, t3);
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(1, t4, t5);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(1, 3, 9).toArray(), t.largestValues(root).toArray());
    }

    @Test
    void largestValuesNullRoot() {
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of().toArray(), t.largestValues(null).toArray());
    }

    @Test
    void largestValuesNearlyBalanced() {
        FindLargestValueInEachTreeRow.TreeNode t1 = new FindLargestValueInEachTreeRow.TreeNode(5);
        FindLargestValueInEachTreeRow.TreeNode t2 = new FindLargestValueInEachTreeRow.TreeNode(3);
        FindLargestValueInEachTreeRow.TreeNode t3 = new FindLargestValueInEachTreeRow.TreeNode(9);
        FindLargestValueInEachTreeRow.TreeNode t4 = new FindLargestValueInEachTreeRow.TreeNode(3, t1, t2);
        FindLargestValueInEachTreeRow.TreeNode t5 = new FindLargestValueInEachTreeRow.TreeNode(2, null, t3);
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(1, t4, t5);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(1, 3, 9).toArray(), t.largestValues(root).toArray());
    }

    @Test
    void largestValuesNegativeValuesBiggestNumber() {
        FindLargestValueInEachTreeRow.TreeNode t1 = new FindLargestValueInEachTreeRow.TreeNode(5);
        FindLargestValueInEachTreeRow.TreeNode t2 = new FindLargestValueInEachTreeRow.TreeNode(3);
        FindLargestValueInEachTreeRow.TreeNode t3 = new FindLargestValueInEachTreeRow.TreeNode(9);
        FindLargestValueInEachTreeRow.TreeNode t4 = new FindLargestValueInEachTreeRow.TreeNode(-5, t1, t2);
        FindLargestValueInEachTreeRow.TreeNode t5 = new FindLargestValueInEachTreeRow.TreeNode(-1, null, t3);
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(1, t4, t5);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(1, -1, 9).toArray(), t.largestValues(root).toArray());
    }

    @Test
    void largestValuesUnbalancedLeft() {
        FindLargestValueInEachTreeRow.TreeNode t1 = new FindLargestValueInEachTreeRow.TreeNode(5);
        FindLargestValueInEachTreeRow.TreeNode t2 = new FindLargestValueInEachTreeRow.TreeNode(3, null, t1);
        FindLargestValueInEachTreeRow.TreeNode t3 = new FindLargestValueInEachTreeRow.TreeNode(9, null, t2);
        FindLargestValueInEachTreeRow.TreeNode t5 = new FindLargestValueInEachTreeRow.TreeNode(2, null, t3);
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(1, null, t5);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(1, 2, 9, 3, 5).toArray(), t.largestValues(root).toArray());
    }

    @Test
    void largestValuesUnbalancedRight() {
        FindLargestValueInEachTreeRow.TreeNode t1 = new FindLargestValueInEachTreeRow.TreeNode(5);
        FindLargestValueInEachTreeRow.TreeNode t2 = new FindLargestValueInEachTreeRow.TreeNode(3, t1, null);
        FindLargestValueInEachTreeRow.TreeNode t3 = new FindLargestValueInEachTreeRow.TreeNode(9, t2, null);
        FindLargestValueInEachTreeRow.TreeNode t5 = new FindLargestValueInEachTreeRow.TreeNode(2, t3, null);
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(1, t5, null);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(1, 2, 9, 3, 5).toArray(), t.largestValues(root).toArray());
    }

    @Test
    void largestValuesSearchTree() {
        FindLargestValueInEachTreeRow.TreeNode t1 = new FindLargestValueInEachTreeRow.TreeNode(1);
        FindLargestValueInEachTreeRow.TreeNode t2 = new FindLargestValueInEachTreeRow.TreeNode(3);
        FindLargestValueInEachTreeRow.TreeNode t3 = new FindLargestValueInEachTreeRow.TreeNode(2, t1, t2);
        FindLargestValueInEachTreeRow.TreeNode t5 = new FindLargestValueInEachTreeRow.TreeNode(5);
        FindLargestValueInEachTreeRow.TreeNode t6 = new FindLargestValueInEachTreeRow.TreeNode(7);
        FindLargestValueInEachTreeRow.TreeNode t7 = new FindLargestValueInEachTreeRow.TreeNode(6, t5, t6);
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(4, t3, t7);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(4, 6, 7).toArray(), t.largestValues(root).toArray());
    }

    @Test
    void largestValuesOnlyRoot() {
        FindLargestValueInEachTreeRow.TreeNode root = new FindLargestValueInEachTreeRow.TreeNode(4, null, null);
        FindLargestValueInEachTreeRow t = new FindLargestValueInEachTreeRow();
        assertArrayEquals(List.of(4).toArray(), t.largestValues(root).toArray());
    }
}