import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilterListTest {
    private int[] list01 = {-2, 0, 5, 5, 16, -30, 2, -12};
    private int[] list02 = {3, 6};
    private int[] emptyList = {};
    private int[] predicate01 = {1, 16, 16, -4};
    private int[] predicate02 = {1, 5, 30};
    private int[] emptyPredicate = {};
    private FilterList repeatedListElmtInPredicate;
    private FilterList noListElmtInPredicate;
    private FilterList repeatedPredicateElmtInList;
    private FilterList listIsEmpty;
    private FilterList predicateEmpty;
    private FilterList listIsNull;
    private FilterList predicateIsNull;

    @Before
    public void setUp() throws Exception {
        repeatedListElmtInPredicate = new FilterList(list01, predicate01);
        noListElmtInPredicate = new FilterList(list02, predicate01);
        repeatedPredicateElmtInList = new FilterList(list01, predicate02);
        listIsEmpty = new FilterList(emptyList, predicate01);
        predicateEmpty = new FilterList(list02, emptyPredicate);
        listIsNull = new FilterList(null, predicate01);
        predicateIsNull = new FilterList(list01, null);
    }

    @Test
    public void iterate() {
        int[] iterateActResult = repeatedListElmtInPredicate.iterate(repeatedListElmtInPredicate);
        int[] iterateExpResult01 = {-2, 0, 5, 5, -30, 2, -12};
        assertArrayEquals(iterateExpResult01, iterateActResult);

        iterateActResult = noListElmtInPredicate.iterate(noListElmtInPredicate);
        int[] iterateExpResult02 = {3, 6};
        assertArrayEquals(iterateExpResult02, iterateActResult);

        iterateActResult = repeatedPredicateElmtInList.iterate(repeatedPredicateElmtInList);
        int[] iterateExpResult03 = {-2, 0, 16, -30, 2, -12};
        assertArrayEquals(iterateExpResult03, iterateActResult);

        iterateActResult = listIsEmpty.iterate(listIsEmpty);
        int[] iterateExpResult04 = {};
        assertArrayEquals(iterateExpResult04, iterateActResult);

        iterateActResult = predicateEmpty.iterate(predicateEmpty);
        int[] iterateExpResult05 = {3, 6};
        assertArrayEquals(iterateExpResult05, iterateActResult);

        iterateActResult = listIsNull.iterate(listIsNull);
        int[] iterateExpResult06 = {};
        assertArrayEquals(iterateExpResult06, iterateActResult);

        iterateActResult = predicateIsNull.iterate(predicateIsNull);
        int[] iterateExpResult07 = {-2, 0, 5, 5, 16, -30, 2, -12};
        assertArrayEquals(iterateExpResult07, iterateActResult);
    }

    @Test
    public void addIfNotInPredicate() {
        String message = "This element is in the predicate. It cannot be added";

    }

    @Test
    public void removeIfNotInPredicate() {
        String message = "This element is in the predicate. It cannot be deleted";

    }

    @Test
    public void removeAllNotInPredicate() {
        repeatedListElmtInPredicate.removeAllNotInPredicate();
        int[] removeAllActResult = repeatedListElmtInPredicate.getList();
        int[] removeAllExpResult01 = {16};
        assertArrayEquals(removeAllExpResult01, removeAllActResult);

        noListElmtInPredicate.removeAllNotInPredicate();
        removeAllActResult = noListElmtInPredicate.getList();
        int[] removeAllExpResult02 = {};
        assertArrayEquals(removeAllExpResult02, removeAllActResult);

        repeatedPredicateElmtInList.removeAllNotInPredicate();
        removeAllActResult = repeatedPredicateElmtInList.getList();
        int[] removeAllExpResult03 = {5, 5};
        assertArrayEquals(removeAllExpResult03, removeAllActResult);

        listIsEmpty.removeAllNotInPredicate();
        removeAllActResult = listIsEmpty.getList();
        int[] removeAllExpResult04 = {};
        assertArrayEquals(removeAllExpResult04, removeAllActResult);

        predicateEmpty.removeAllNotInPredicate();
        removeAllActResult = predicateEmpty.getList();
        int[] removeAllExpResult05 = {};
        assertArrayEquals(removeAllExpResult05, removeAllActResult);

        listIsNull.removeAllNotInPredicate();
        removeAllActResult = listIsNull.getList();
        int[] removeAllExpResult06 = {};
        assertArrayEquals(removeAllExpResult06, removeAllActResult);

        predicateIsNull.removeAllNotInPredicate();
        removeAllActResult = predicateIsNull.getList();
        int[] removeAllExpResult07 = {};
        assertArrayEquals(removeAllExpResult07, removeAllActResult);
    }
}