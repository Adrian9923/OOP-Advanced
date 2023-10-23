package CollectionHierarchy;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));

        List<String> items = new ArrayList<>();
        String[] tokens = bfr.readLine().split("\\s+");
        items.addAll(Arrays.asList(tokens));

        int removeCount = Integer.parseInt(bfr.readLine());

        AddCollection addCollection = new AddCollection(items);
        for (String item : items) {
            System.out.print(addCollection.add(item) + " ");
        }

        System.out.println();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection(items);
        for (String item : items) {
            System.out.print(addRemoveCollection.add(item) + " ");
        }
        System.out.println();
        MyList myList = new MyLisImpl(items);
        for (String item : items) {
            System.out.print(myList.add(item) + " ");
        }
        System.out.println();
        for (int i = 0; i < removeCount; i++) {
            System.out.print(addRemoveCollection.remove() + " ");
        }
        System.out.println();
        for (int i = 0; i < removeCount; i++) {
            System.out.print(myList.remove() + " ");
        }


    }

}
