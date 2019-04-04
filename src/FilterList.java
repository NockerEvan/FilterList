import java.util.AbstractList;
import java.util.Iterator;

public class FilterList extends AbstractList<Integer>{
    private int[] list;
    private int[] predicate;

    /**
     * Метод проверяет, есть ли в предикате элемент из листа. Элемент определяется по его индексу в листе.     *
     * @param index - индекс некоторого элемента в массиве list
     * @return - true, если элемент в предикате есть.
     */
    private boolean isInPredicateByIndex(int index) {
        for (int k : predicate) {
            if (k == list[index]) return true;
        }
        return false;
    }

    /**
     * Метод проверяет наличие в предикате некоторого значения.
     * @param value - значение типа int, отсутствие которого проверяется в предикате
     * @return - true, если значение в предикате есть
     */
    private boolean isInPredicateByValue(int value) {
        for (int k : predicate) {
            if (k == value) return true;
        }
        return false;
    }

    /**
     * Метод считает сколько элементов из list присутствуют в предикате
     * @return - число элементов list, имеющихся в предикате
     */
    private int predicatesInListQuantity() {
        int countPredicates = 0;
        for (int i = 0; i < list.length; i++) {
            if (isInPredicateByIndex(i)) {
                countPredicates++;
            }
        }
        return countPredicates;
    }

    @Override
    public Integer get(int index) {
        return list[index];
    }

    @Override
    public int size() {
        return list.length;
    }

    /**
     * Метод, возвращающий новый массив, в котором нет элементов из предиката
     * Не изменяет list и predicate
     * @param fL - объект FilterList
     * @return - массив int[], содержащий элементы из предиката
     */
    public int[] iterate(FilterList fL) {
        int newListSize = list.length - predicatesInListQuantity();
        int[] newList = new int[newListSize];
        int cursor = 0;
        Iterator<Integer> iterator = fL.iterator();
        while (iterator.hasNext()) {
            int value = iterator.next();
            if (!isInPredicateByValue(value)) {
                newList[cursor] = value;
                cursor++;
            }
        }
        return newList;
    }

    /**
     * Метод, удаляющий из list все элементы, которых нет в предикате
     */
    public void removeAllNotInPredicate() {
        int cursor = 0;
        int countPredicates = predicatesInListQuantity();
        int[] newList = new int[countPredicates];
        for (int i = 0; i < list.length; i++) {
            if (isInPredicateByIndex(i)) {
                newList[cursor] = list[i];
                cursor++;
            }
        }
        list = newList;
    }

    /**
     * Метод, добавляющий в list int, которого нет в предикате. Если int есть в предикате, то выдается предупреждение
     * @param i - int, добавляемый в массив
     */
    public void addIfNotInPredicate(int i) {
        int newListSize = list.length+1;
        int[] newList = new int[newListSize];
        if (!isInPredicateByValue(i)) {
            for (int j = 0; j < list.length; j++) {
                newList[j] = list[j];
            }
            newList[list.length] = i;
            list = newList;
        } else {
            System.out.println("This element is in the predicate. It cannot be added");
        }
    }

    /**
     * Метод, удаляющий из list элемент, которого нет в предикате
     * Если int есть в предикате, то выдается предупреждение
     * @param index - индекс элемента, который нужно удалить
     */
    public void removeIfNotInPredicate(int index) {
        if (isInPredicateByIndex(index)) {
            System.out.println("This element is in the predicate. It cannot be deleted");
        } else {
            int[] newList = new int[list.length - 1];
            for (int i = 0; i < index; i++) {
                newList[i] = list[i];
            }
            for (int i = index + 1; i < list.length; i++) {
                newList[i - 1] = list[i];
            }
            list = newList;
        }
    }

    public static void print(int[] listToPrint) {
        for (int i: listToPrint) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int[] getFilterList() {
        return list;
    }

    public int[] getPredicate() {
        return predicate;
    }

    FilterList(int[] list, int[] predicate) {
        this.list=list;
        this.predicate=predicate;
    }
}
