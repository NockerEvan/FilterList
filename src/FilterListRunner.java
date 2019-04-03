public class FilterListRunner {
    public static void main(String[] args) {
        ListMaker listMaker = new ListMaker();

        int[] filterList = listMaker.createList(0);
        int[] predicate = listMaker.createPredicate(3);
        FilterList fList = new FilterList(filterList, predicate);

        listMaker.listPrinter(fList.getFilterList());
        System.out.println();
        listMaker.listPrinter(fList.getPredicate());

        System.out.println();
        //fList.removeElement(0);
        fList.add(6);
        listMaker.listPrinter(fList.getFilterList());
        System.out.println();
        fList.removeAll();
        listMaker.listPrinter(fList.getFilterList());
    }
}
