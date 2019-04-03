import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;

public class FilterList extends AbstractList<Integer> {
    @Override
    public Integer get(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator<Integer> iterator() {
        return super.iterator();
    }

    public boolean remove() {
        return false;
    }

    public void add() {

    }

    FilterList(List<Integer> list, List<Integer> predicate) {

    }
}
