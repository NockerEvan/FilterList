import java.util.AbstractList;
import java.util.Iterator;

public class FilterList extends AbstractList<Integer>{
    private int[] filterList;
    private int[] predicate;

    public int[] getFilterList() {
        return filterList;
    }

    public int[] getPredicate() {
        return predicate;
    }

    @Override
    public Integer get(int index) {
        return filterList[index];
    }

    @Override
    public int size() {
        return filterList.length;
    }

    @Override
    public Iterator iterator() {
        return super.iterator();
    }

    public void removeAll() {
        int countPredicates = 0;
        int cursor = 0;
        for (int i = 0; i < filterList.length; i++) {
            if (predicate(i)) {
                countPredicates++;
            }
        }
        int[] newList = new int[countPredicates];
        for (int i = 0; i < filterList.length; i++) {
            if (predicate(i)) {
                newList[cursor] = filterList[i];
                cursor++;
            }
        }
        filterList = newList;
    }

    public void add(int i) {
        for (int k : predicate) {
            if (k == i) {
                System.out.println("This element is in the predicate. It cannot be deleted");
            } else {
                int[] newList = new int[filterList.length+1];
                for (int j = 0; j < filterList.length; j++) {
                    newList[j] = filterList[j];
                }
                newList[filterList.length] = i;
                filterList = newList;
            }
        }
    }

    public void removeElement(int index) {
        if (predicate(index)) {
            System.out.println("This element is in the predicate. It cannot be deleted");
        } else {
            int[] newList = new int[filterList.length - 1];
            for (int i = 0; i < index; i++) {
                newList[i] = filterList[i];
            }
            for (int i = index + 1; i < filterList.length; i++) {
                newList[i - 1] = filterList[i];
            }
            filterList = newList;
        }
    }

    private boolean predicate(int index) {
        for (int k : predicate) {
            if (k == filterList[index]) return true;
        }
        return false;
    }

    FilterList(int[] filterList, int[] predicate) {
        this.filterList=filterList;
        this.predicate=predicate;
    }
}
