import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

public class NestedIterator implements Iterator<Integer> {
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

    Stack<Pair<List<NestedInteger>, Integer>> currentList;

    public NestedIterator(List<NestedInteger> nestedList) {
        currentList = new Stack<>();
        currentList.push(new Pair<>(nestedList, 0));
        if(nestedList.isEmpty()) {
            currentList.pop();
            return;
        }
        Pair<List<NestedInteger>, Integer> curr = currentList.peek();
        out:
        do {
            while(curr.y < curr.x.size()) {
                if(curr.x.get(curr.y).isInteger()) break out;
                currentList.add(new Pair<>(curr.x.get(curr.y).getList(), 0));
                curr = currentList.peek();
            }
            while (!currentList.isEmpty() && curr.y + 1 >= curr.x.size()) {
                currentList.pop();
                if(!currentList.isEmpty()) curr = currentList.peek();
            }
            curr.y++;
        } while (!currentList.isEmpty() && !curr.x.get(curr.y).isInteger());

        System.out.println(currentList.size());
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
        Pair<List<NestedInteger>, Integer> curr = currentList.peek();
        Integer cache = curr.x.get(curr.y++).getInteger();

        out:
        do {
            while(curr.y < curr.x.size()) {
                if(curr.x.get(curr.y).isInteger()) break out;
                currentList.add(new Pair<>(curr.x.get(curr.y).getList(), 0));
                curr = currentList.peek();
            }

            while (!currentList.isEmpty() && curr.y + 1 >= curr.x.size()) {
                currentList.pop();
                if(!currentList.isEmpty()) curr = currentList.peek();
            }
            curr.y++;
        } while (!currentList.isEmpty() && !curr.x.get(curr.y).isInteger());

        return cache;
    }

    @Override
    public boolean hasNext() {
        return !currentList.isEmpty();
    }
}
