import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class FlattenListIterator implements Iterator<Integer> {
    public interface NestedInteger {
      // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

      // @return the single integer that this NestedInteger holds, if it holds a single integer
      // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

      // @return the nested list that this NestedInteger holds, if it holds a nested list
      // Return empty list if this NestedInteger holds a single integer
      public List<NestedInteger> getList();
   }

   private class Pair<T, U> {
        T x;
        U y;
        Pair(T x, U y) {
            this.x = x;
            this.y = y;
        }
   }

    List<NestedInteger> nestedList;
    Stack<Pair<List<NestedInteger>, Integer>> currentList;

    public FlattenListIterator(List<NestedInteger> nestedList) {
        currentList = new Stack<>();
        currentList.add(new Pair<>(nestedList, 0));
    }

    @Override
    public Integer next() {
        Pair<List<NestedInteger>, Integer> curr = currentList.peek();
        while(!curr.x.get(curr.y).isInteger()) {
            currentList.add(new Pair<>(curr.x.get(curr.y).getList(), 0));
            curr = currentList.peek();
        }

        Integer cache = curr.x.get(curr.y).getInteger();
        curr.y += 1;
        if(curr.y >= curr.x.size()) {
            currentList.pop();
        }

        return cache;
    }

    @Override
    public boolean hasNext() {

    }
}
