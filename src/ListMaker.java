public class ListMaker {
    private int[] list;

    public int[] createList(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = (int)(Math.random()*listSize);
        }
        return list;
    }

    public int[] createPredicate(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = ((int)(Math.random()*10));
        }
        return list;
    }

    public void listPrinter(int[] listToPrint) {
        for (int i: listToPrint) {
            System.out.print(i + " ");
        }
    }
}
