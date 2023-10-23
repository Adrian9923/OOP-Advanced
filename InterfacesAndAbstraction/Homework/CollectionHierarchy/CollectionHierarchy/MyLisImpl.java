package CollectionHierarchy;

import java.util.List;

public class MyLisImpl extends Collection implements MyList{


    public MyLisImpl(List<String> items) {
        super(items);
    }

    @Override
    public String remove() {
        return items.remove(0);
    }

    @Override
    public int add(String item) {
        items.add(0, item);
        return 0;
    }

    @Override
    public int getUsed() {
        return items.size();
    }
}
