public class FilterListRunner {
    public static void main(String[] args) {
        ListMaker listMaker = new ListMaker();

        int[] filterList = listMaker.createList(2);
        int[] predicate = listMaker.createPredicate(3);
        FilterList fList = new FilterList(filterList, predicate);

        listMaker.listPrinter(filterList);
        System.out.println();
        listMaker.listPrinter(predicate);

        System.out.println();
        fList.removeElement(1);
        listMaker.listPrinter(fList.getFilterList());
        System.out.println();
        fList.removeAll();
        listMaker.listPrinter(fList.getFilterList());
    }
}
