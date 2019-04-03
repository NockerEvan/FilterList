public class FilterListRunner {
    public static void main(String[] args) {
        ListMaker listMaker = new ListMaker();
        int[] filterList = listMaker.createList(15);
        int[] predicate = listMaker.createPredicate(3);

        listMaker.listPrinter(filterList);
        System.out.println();
        listMaker.listPrinter(predicate);
    }
}
