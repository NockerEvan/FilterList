public class FilterListRunner {
    public static void main(String[] args) {
        ListGenerator listGenerator = new ListGenerator();

        int[] fL01 = listGenerator.generateList(10);
        int[] fL02 = listGenerator.generateList(2);
        int[] fL03 = listGenerator.generateList(0);
        int[] pL01 = listGenerator.generatePredicate(3);
        int[] pL02 = listGenerator.generatePredicate(0);

        FilterList fList01 = new FilterList(fL01, pL01);
        FilterList fList02 = new FilterList(fL01, pL02);
        FilterList fList03 = new FilterList(fL02, pL01);
        FilterList fList04 = new FilterList(fL03, pL01);
        FilterList fList05 = new FilterList(fL03, pL02);

        System.out.println("First FilterList manipulations");
        listGenerator.listPrinter(fList01.getFilterList());
        listGenerator.listPrinter(fList01.getPredicate());
        System.out.println("Remove " + "3" + " element");
        fList01.removeElement(3);
        listGenerator.listPrinter(fList01.getFilterList());
        System.out.println("Add " + "6");
        fList01.add(6);
        listGenerator.listPrinter(fList01.getFilterList());
        System.out.println("Iterator result");
        listGenerator.listPrinter(fList01.iterate(fList01));
        System.out.println("RemoveAll result");
        fList01.removeAll();
        listGenerator.listPrinter(fList01.getFilterList());

        System.out.println("Second FilterList manipulations");
        listGenerator.listPrinter(fList02.getFilterList());
        listGenerator.listPrinter(fList02.getPredicate());
        System.out.println("Remove " + "0" + " element");
        fList02.removeElement(0);
        listGenerator.listPrinter(fList02.getFilterList());
        System.out.println("Add " + "0");
        fList02.add(0);
        listGenerator.listPrinter(fList02.getFilterList());
        System.out.println("Iterator result");
        listGenerator.listPrinter(fList02.iterate(fList02));
        System.out.println("RemoveAll result");
        fList02.removeAll();
        listGenerator.listPrinter(fList02.getFilterList());

        System.out.println("Third FilterList manipulations");
        listGenerator.listPrinter(fList03.getFilterList());
        listGenerator.listPrinter(fList03.getPredicate());
        System.out.println("Remove " + "1" + " element");
        fList03.removeElement(1);
        listGenerator.listPrinter(fList03.getFilterList());
        System.out.println("Add " + "15");
        fList03.add(15);
        listGenerator.listPrinter(fList03.getFilterList());
        System.out.println("Iterator result");
        listGenerator.listPrinter(fList03.iterate(fList03));
        System.out.println("RemoveAll result");
        fList03.removeAll();
        listGenerator.listPrinter(fList03.getFilterList());

        System.out.println("Fourth FilterList manipulations");
        listGenerator.listPrinter(fList04.getFilterList());
        listGenerator.listPrinter(fList04.getPredicate());
        System.out.println("If you remove anything from the list it will throw ArrayIndexOutOfBounds");
        listGenerator.listPrinter(fList04.getFilterList());
        System.out.println("Add " + "6");
        fList04.add(6);
        listGenerator.listPrinter(fList04.getFilterList());
        System.out.println("Iterator result");
        listGenerator.listPrinter(fList04.iterate(fList04));
        System.out.println("RemoveAll result");
        fList04.removeAll();
        listGenerator.listPrinter(fList04.getFilterList());

        System.out.println("Fifth FilterList manipulations");
        listGenerator.listPrinter(fList05.getFilterList());
        listGenerator.listPrinter(fList05.getPredicate());
        System.out.println("If you remove anything from the list it will throw ArrayIndexOutOfBounds");
        listGenerator.listPrinter(fList05.getFilterList());
        System.out.println("Add " + "6");
        fList05.add(6);
        listGenerator.listPrinter(fList05.getFilterList());
        System.out.println("Iterator result");
        listGenerator.listPrinter(fList05.iterate(fList05));
        System.out.println("RemoveAll result");
        fList05.removeAll();
        listGenerator.listPrinter(fList05.getFilterList());
    }
}
