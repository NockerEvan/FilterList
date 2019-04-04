public class ListGenerator {
    private int[] list;

    /**
     * Генерация массива, заполняемого случайными числами от -list.size до list.size-1
     * @param listSize - размер массива
     * @return - возвращает сгенерированный массив
     */
    public int[] generateList(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = (int)(Math.random()*listSize*2 - listSize);
        }
        return list;
    }

    /**
     * Генерация массива, заполняемого случайными числами от -10 до 9
     * @param listSize - размер массива
     * @return - возвращает сгенерированный массив
     */
    public int[] generatePredicate(int listSize) {
        this.list = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            list[i] = ((int)(Math.random()*20 - 10));
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
