import org.hamcrest.core.Is;
import org.hamcrest.core.IsEqual;
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
        int[] additionExpResult01 = {-2, 0, 5, 5, 16, -30, 2, -12};
        repeatedListElmtInPredicate.addIfNotInPredicate(16);
        assertArrayEquals(additionExpResult01, repeatedListElmtInPredicate.getList());

        int[] additionExpResult02 = {-2, 0, 5, 5, 16, -30, 2, -12, 5};
        repeatedListElmtInPredicate.addIfNotInPredicate(5);
        assertArrayEquals(additionExpResult02, repeatedListElmtInPredicate.getList());

        int[] additionExpResult03 = {-2, 0, 5, 5, 16, -30, 2, -12};
        repeatedPredicateElmtInList.addIfNotInPredicate(5);
        assertArrayEquals(additionExpResult03, repeatedPredicateElmtInList.getList());

        int[] additionExpResult04 = {-2, 0, 5, 5, 16, -30, 2, -12, -30};
        repeatedPredicateElmtInList.addIfNotInPredicate(-30);
        assertArrayEquals(additionExpResult04, repeatedPredicateElmtInList.getList());

        int[] additionExpResult05 = {4};
        listIsEmpty.addIfNotInPredicate(4);
        assertArrayEquals(additionExpResult05, listIsEmpty.getList());

        int[] additionExpResult06 = {3, 6, 6};
        predicateEmpty.addIfNotInPredicate(6);
        assertArrayEquals(additionExpResult06, predicateEmpty.getList());

        int[] additionExpResult07 = {555};
        listIsNull.addIfNotInPredicate(555);
        assertArrayEquals(additionExpResult07, listIsNull.getList());

        int[] iterateExpResult07 = {-2, 0, 5, 5, 16, -30, 2, -12, 5};
        predicateIsNull.addIfNotInPredicate(5);
        assertArrayEquals(iterateExpResult07, predicateIsNull.getList());
    }

    @Test
    public void removeIfNotInPredicate() throws ArrayIndexOutOfBoundsException, NegativeArraySizeException {
        int[] removeExpResult01 = {-2, 0, 5, 5, 16, -30, 2, -12};
        repeatedListElmtInPredicate.removeIfNotInPredicate(4);
        assertArrayEquals(removeExpResult01, repeatedListElmtInPredicate.getList());

        int[] removeExpResult02 = {0, 5, 5, 16, -30, 2, -12};
        repeatedListElmtInPredicate.removeIfNotInPredicate(0);
        assertArrayEquals(removeExpResult02, repeatedListElmtInPredicate.getList());

        int[] removeExpResult03 = {-2, 0, 5, 5, 16, -30, 2, -12};
        try {
            repeatedPredicateElmtInList.removeIfNotInPredicate(12);
            fail("Expected an ArrayIndexOutOfBoundsException to be thrown");
        } catch (ArrayIndexOutOfBoundsException arrIO) {
            assertArrayEquals(removeExpResult03, repeatedPredicateElmtInList.getList());
        }

//        int[] additionExpResult04 = {-2, 0, 5, 5, 16, -30, 2, -12, -30};
//        repeatedPredicateElmtInList.addIfNotInPredicate(-30);
//        assertArrayEquals(additionExpResult04, repeatedPredicateElmtInList.getList());

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