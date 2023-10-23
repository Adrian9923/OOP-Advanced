package CollectionHierarchy;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    int maxSize = 100;
    List<String> items;
    public Collection(List<String> items) {
        this.items = new ArrayList<>(maxSize);
    }
}
