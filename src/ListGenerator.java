public class ListGenerator {
    private int[] list;

    public int[] generateList(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = (int)(Math.random()*listSize*2 - listSize);
        }
        return list;
    }

    public int[] generatePredicate(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = ((int)(Math.random()*25 - 13));
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
