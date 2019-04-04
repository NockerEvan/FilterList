public class ListGenerator {
    private int[] list;

    public int[] generateList(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = (int)(Math.random()*listSize);
            //list[i] = 0;
        }
        return list;
    }

    public int[] generatePredicate(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = ((int)(Math.random()*10));
            //list[i] = 0;
        }
        return list;
    }

    public void listPrinter(int[] listToPrint) {
        for (int i: listToPrint) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
