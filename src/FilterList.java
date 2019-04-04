import java.util.AbstractList;
import java.util.Iterator;

public class FilterList extends AbstractList<Integer>{
    private int[] filterList;
    private int[] predicate;

    private boolean isInPredicateByIndex(int index) {
        for (int k : predicate) {
            if (k == filterList[index]) return true;
        }
        return false;
    }

    private boolean isInPredicateByValue(int value) {
        for (int k : predicate) {
            if (k == value) return true;
        }
        return false;
    }

    private int predicatesQuantity() {
        int countPredicates = 0;
        for (int i = 0; i < filterList.length; i++) {
            if (isInPredicateByIndex(i)) {
                countPredicates++;
            }
        }
        return countPredicates;
    }

    @Override
    public Integer get(int index) {
        return filterList[index];
    }

    @Override
    public int size() {
        return filterList.length;
    }

    public int[] iterate(FilterList fL) {
        int newListSize = filterList.length - predicatesQuantity();
        int[] newList = new int[newListSize];
        int cursor = 0;
        Iterator<Integer> iterator = fL.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (!isInPredicateByValue(value)) {
                newList[cursor] = value;
                cursor++;
            }
        }
        return newList;
    }

    public void removeAll() {
        int cursor = 0;
        int countPredicates = predicatesQuantity();
        int[] newList = new int[countPredicates];
        for (int i = 0; i < filterList.length; i++) {
            if (isInPredicateByIndex(i)) {
                newList[cursor] = filterList[i];
                cursor++;
            }
        }
        filterList = newList;
    }

    public void add(int i) {
        int newListSize = filterList.length+1;
        int[] newList = new int[newListSize];
        if (isInPredicateByValue(i)) {
            System.out.println("This element is in the predicate. It cannot be added");
        } else {
            for (int j = 0; j < filterList.length; j++) {
                newList[j] = filterList[j];
            }
            newList[filterList.length] = i;
            filterList = newList;
        }
    }

    public void removeElement(int index) {
        if (isInPredicateByIndex(index)) {
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

    public int[] getFilterList() {
        return filterList;
    }

    public int[] getPredicate() {
        return predicate;
    }

    FilterList(int[] filterList, int[] predicate) {
        this.filterList=filterList;
        this.predicate=predicate;
    }
}
