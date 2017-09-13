package listutil;

import java.util.*;

public interface IListUtil {

    boolean listEquals(List l1, List l2);

    List reflectProperty(List l, String fieldName);
}
