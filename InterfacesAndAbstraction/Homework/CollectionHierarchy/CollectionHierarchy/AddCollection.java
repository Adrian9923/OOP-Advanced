package CollectionHierarchy;

import java.util.List;

public class AddCollection extends Collection implements Addable{

    public AddCollection(List<String> items) {
        super(items);
    }

    @Override
    public int add(String item) {
        items.add(item);
        return items.size() - 1;
    }
}
