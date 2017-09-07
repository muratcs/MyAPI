
import java.util.*;
import java.lang.reflect.*;

public  class ListUtil implements IListUtil{

    @Override
    public boolean listEquals(List l1, List l2) {

        if(l1.isEmpty() && l2.isEmpty()) return true;

        if(l1.size() != l2.size()) return false;

        Map<Object, Integer> map = new HashMap<>();

        for (Object x : l1){

            map.merge(x, 1, (a, b) -> a + b);
        }

        for (Object x : l2){
            Integer count = map.get(x);

            if(count == null){
                return false;
            }
            else{
                map.put(x, count-1);
            }
        }

        for (Integer count : map.values()){
            if(count != 0){
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        List<String> l1 = Arrays.asList("D", "B", "A", "C","A");
        List<String> l2 = Arrays.asList("F", "B", "A", "C","B");

        Map<Object, Integer> map = new HashMap<>();
        for (Object x : l1){
            map.merge(x, 1, (a, b) -> a + b);

            System.out.println(map.keySet());
            System.out.println(map.values());
            System.out.println("---------");
        }
        System.out.println();
        for (Object x : l2){
            Integer count = map.get(x);

            if(count == null){
                System.out.println("false");
            }
            else{

                map.put(x, count-1);
                System.out.println(map.keySet());
                System.out.println(map.values());
                System.out.println("-----");
            }
        }

    }

    @Override
    public List reflectProperty(List list, String fieldName) {
//        try {
//            Class x = Class.forName("fieldName");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
        List<Object> newList = new ArrayList<>();
        for(Object x : list){
            try {
                Field f = x.getClass().getDeclaredField(fieldName);
                f.setAccessible(true);
                //System.out.println(declaredField.get(x));
                newList.add(f.get(x));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }

        }

        return newList;
    }


}
