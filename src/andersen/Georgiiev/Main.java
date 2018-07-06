package andersen.Georgiiev;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        CustomCollection<Number> testCollection = new CustomCollection<>();
        for (int i = 0; i < 8; i++ ) {
            testCollection.add(i);
        }
        testCollection.add(15);
        testCollection.add(-15);
        testCollection.add(15.0);
        System.out.println(testCollection);
        System.out.println(testCollection.getMax());
        System.out.println(testCollection.getMin());
        System.out.println(testCollection.getAverage());
        testCollection.trimToSize();
    }
}
