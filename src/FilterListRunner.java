public class FilterListRunner {
    public static void main(String[] args) {
        int[] list01 = {-2, 0, 5, 5, 16, -30, 2, -12};
        int[] list02 = {3, 6};
        int[] list03 = {};
        int[] predicate01 = {5, -30, 3};
        int[] predicate02 = {1, 16, 16, -4};
        int[] predicate03 = {};

        FilterList filterList01 = new FilterList(list01, predicate01);
        FilterList filterList02 = new FilterList(list02, predicate01);
        FilterList filterList03 = new FilterList(list03, predicate02);
        FilterList filterList04 = new FilterList(list03, predicate03);
        FilterList filterList05 = new FilterList(list01, predicate02);
        FilterList filterList06 = new FilterList(list01, null);

        System.out.println("First FilterList manipulations");
        FilterList.print(filterList01.getList());
        FilterList.print(filterList01.getPredicate());
        System.out.println("Remove element №3 (which is in the predicate and cannot be removed)");
        filterList01.removeIfNotInPredicate(3);
        System.out.println("Remove element №0 = -2 (the beginning of list)");
        filterList01.removeIfNotInPredicate(0);
        FilterList.print(filterList01.getList());
        System.out.println("Remove element №6 = -12 (the end of list)");
        filterList01.removeIfNotInPredicate(6);
        FilterList.print(filterList01.getList());
        try{
            filterList01.removeIfNotInPredicate(6);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Remove element №6 now throws ArrayOutOfBoundException");
        }
        System.out.println("Add -30 (which is in the predicate and cannot be added)");
        filterList01.addIfNotInPredicate(-30);
        System.out.println("Add 0");
        filterList01.addIfNotInPredicate(0);
        FilterList.print(filterList01.getList());
        System.out.println("Iterator result");
        FilterList.print(filterList01.iterate(filterList01));
        System.out.println("RemoveAll result - sees repeated numbers in the list");
        filterList01.removeAllNotInPredicate();
        FilterList.print(filterList01.getList());

        System.out.println();

        System.out.println("Second FilterList manipulations - a case when predicate is bigger than list");
        FilterList.print(filterList02.getList());
        FilterList.print(filterList02.getPredicate());
        System.out.println("Iterator result");
        FilterList.print(filterList02.iterate(filterList02));
        System.out.println("RemoveAll result");
        filterList02.removeAllNotInPredicate();
        FilterList.print(filterList02.getList());

        System.out.println();

        System.out.println("Third FilterList manipulations - a case where list.size = 0");
        FilterList.print(filterList03.getList());
        FilterList.print(filterList03.getPredicate());
        try{
            filterList03.removeIfNotInPredicate(0);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Removal of any element will throw ArrayOutOfBoundException");
        }
        System.out.println("Iterator result");
        FilterList.print(filterList03.iterate(filterList03));
        System.out.println("RemoveAll result");
        filterList03.removeAllNotInPredicate();
        FilterList.print(filterList03.getList());

        System.out.println();

        System.out.println("Fourth FilterList manipulations - where both list and predicate size = 0");
        FilterList.print(filterList04.getList());
        FilterList.print(filterList04.getPredicate());
        try{
            filterList04.removeIfNotInPredicate(0);
        } catch (NegativeArraySizeException e) {
            System.out.println("Removal of any element from list with size = 0 will generate NegativeSizeArrayException");
        }
        FilterList.print(filterList04.getList());
        System.out.println("Add 0 - no problems with adding anything");
        filterList04.addIfNotInPredicate(6);
        FilterList.print(filterList04.getList());
        System.out.println("Now we can safely remove element №0");
        filterList04.removeIfNotInPredicate(0);
        FilterList.print(filterList04.getList());
        System.out.println("Iterator result");
        FilterList.print(filterList04.iterate(filterList04));
        System.out.println("RemoveAll result");
        filterList04.removeAllNotInPredicate();
        FilterList.print(filterList04.getList());

        System.out.println("Fifth FilterList manipulations a case where there are repeated numbers in predicate");
        FilterList.print(filterList05.getList());
        FilterList.print(filterList05.getPredicate());
        System.out.println("Trying to remove element №4 (which is repeated in predicate)");
        filterList05.removeIfNotInPredicate(4);
        FilterList.print(filterList05.getList());
        System.out.println("Add 16 - which is repeated in predicate");
        filterList05.addIfNotInPredicate(16);
        FilterList.print(filterList05.getList());
        System.out.println("Iterator result");
        FilterList.print(filterList05.iterate(filterList05));
        System.out.println("RemoveAll result");
        filterList05.removeAllNotInPredicate();
        FilterList.print(filterList05.getList());

        System.out.println();

        System.out.println("Sixth FilterList manipulations - a case where predicate is null");
        FilterList.print(filterList06.getList());
        try {
            FilterList.print(filterList06.getPredicate());
        } catch (NullPointerException e) {
            System.out.println("And it will throw NullPointerException every time we call predicate");
        }
    }
}
