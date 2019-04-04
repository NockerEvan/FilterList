public class FilterListRunner {
    public static void main(String[] args) {
        ListMaker listMaker = new ListMaker();

        int[] filterList = listMaker.createList(10);
        int[] predicate = listMaker.createPredicate(3);
        FilterList fList = new FilterList(filterList, predicate);

        listMaker.listPrinter(fList.getFilterList());
        System.out.println();
        listMaker.listPrinter(fList.getPredicate());

        System.out.println("Remove " + "3" + " element");
        fList.removeElement(3);
        System.out.println("Add " + "6");
        fList.add(6);
        listMaker.listPrinter(fList.getFilterList());
        System.out.println("Iterator result");
        listMaker.listPrinter(fList.iterate(fList));
        System.out.println("RemoveAll result");
        fList.removeAll();
        listMaker.listPrinter(fList.getFilterList());
    }
}
