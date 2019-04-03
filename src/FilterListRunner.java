public class FilterListRunner {
    public static void main(String[] args) {
        ListMaker listMaker = new ListMaker();

        int[] filterList = listMaker.createList(15);
        int[] predicate = listMaker.createPredicate(3);
        FilterList fList = new FilterList(filterList, predicate);

        listMaker.listPrinter(filterList);
        System.out.println();
        listMaker.listPrinter(predicate);

        System.out.println(fList.predicate(1));

        listMaker.listPrinter(fList.removeElement(2));
        System.out.println();
        try {
            listMaker.listPrinter(fList.add(12));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
