import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FilterList extends AbstractList<Integer>{
    private int[] filterList;
    private int[] predicate;

    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public int size() {
        return filterList.length;
    }

    @Override
    public Iterator iterator() {
        return super.iterator();
    }

    public void add(int i) {

    }

    public int[] removeElement(int index) throws Exception {
        for (int k : predicate) {
            if (k == filterList[index]) {
                throw new Exception("This element is in the predicate. It cannot be deleted");
            }
        }
        int[] newList = new int[filterList.length-1];
        for (int i = 0; i < index; i++) {
            newList[i] = filterList[i];
        }
        for (int i = index+1; i < filterList.length; i++) {
            newList[i-1] = filterList[i];
        }
        filterList=newList;
        return filterList;
    }

    public boolean predicate(int index) {
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
