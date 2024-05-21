package collection.compare;

import java.util.Comparator;

public class IdComparator implements Comparator<collection.compare.MyUser> {
    @Override
    public int compare(collection.compare.MyUser o1, collection.compare.MyUser o2) {
        return o1.getId().compareTo(o2.getId());
    }
}
