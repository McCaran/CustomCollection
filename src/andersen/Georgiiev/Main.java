package andersen.Georgiiev;

public class Main {

    public static void main(String[] args) {
        CustomCollection<Number> customCollection = new CustomCollection<>();
        testCollection(customCollection);
        testCollection(customCollection);
    }

    public static void testCollection(CustomCollection collection) {
        testAdding(collection);
        testRemoving(collection);
        testCustomFunctions(collection);
        testIterating(collection);
        System.out.println("Очищаем коллекцию");
        collection.clear();
        System.out.println("Содержимое коллекции: " + collection);
    }

    private static void testAdding(CustomCollection collection) {
        System.out.println("Добавляем 10 элементов от 0 до 9");
        for (int i = 0; i < 10; i++) {
            collection.add(i);
        }
        System.out.println(collection);
        byte b = 15;
        short s = 17;
        long l = -50;
        float f = 15.3f;
        double d = 15.3;
        System.out.println("Добавляем разные типа значений");
        collection.add(b);
        collection.add(s);
        collection.add(l);
        collection.add(f);
        collection.add(d);
        System.out.println(collection);
        System.out.println("Добавляем элемент -2 в позицию 4");
        collection.add(4, -2);
        System.out.println(collection);
    }

    private static void testRemoving(CustomCollection collection) {
        System.out.println("Удаляем из коллекции элементы 15.3, 0, 17");
        collection.remove(15.3);
        collection.remove(0);
        collection.remove(17);
        System.out.println(collection);
        System.out.println("Удаляем элемент с позиции 3");
        collection.removeByIndex(3);
        System.out.println(collection);
    }

    private static void testCustomFunctions(CustomCollection collection) {
        System.out.println("Урезаем размер внутренноего массива коллекции: ");
        collection.trimToSize();
        System.out.println("Минимальное щначение в коллекции: " + collection.getMin());
        System.out.println("Среднее значение в коллекции: " + collection.getAverage());
        System.out.println("Максимальное значение в коллекции: " + collection.getMax());
    }

    private static void testIterating(CustomCollection<Number> collection) {
        System.out.println("Проходим по коллекции при помощи for each: ");
        for (Number number: collection) {
            System.out.print(number + " ");
        }
        System.out.println();
    }
}
