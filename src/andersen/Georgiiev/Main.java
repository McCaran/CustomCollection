package andersen.Georgiiev;

import java.util.ArrayList;
import java.util.Collection;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList();
        CustomCollection<Number> testCollection = new CustomCollection<>();
        for (int i = 0; i < 10; i++ ) {
            testCollection.add(i);
            System.out.println("Добавлен " + i);
        }
        Collection collection = new ArrayList();
        System.out.println(testCollection);
    }
}
