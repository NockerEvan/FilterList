import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FilterListTest {

    @Before
    public void setUp() throws Exception {
        int[] list01 = {-2, 0, 5, 5, 16, -30, 2, -12};
        int[] list02 = {3, 6};
        int[] emptyList = {};
        int[] predicate01 = {1, 16, 16, -4};
        int[] emptyPredicate = {};

        FilterList listLongerThanPredicate = new FilterList(list01, predicate01);
        FilterList listShorterThanPredicate = new FilterList(list02, predicate01);
        FilterList listIsEmpty = new FilterList(emptyList, predicate01);
        FilterList listAndPredicateEmpty = new FilterList(emptyList, emptyPredicate);
        FilterList listIsNull = new FilterList(null, predicate01);
        FilterList predicateIsNull = new FilterList(list01, null);
    }

    @Test
    public void iterate() {


    }

    @Test
    public void removeAllNotInPredicate() {
    }

    @Test
    public void addIfNotInPredicate() {
        String message = "This element is in the predicate. It cannot be added";
    }

    @Test
    public void removeIfNotInPredicate() {
        String message = "This element is in the predicate. It cannot be deleted";
    }
}