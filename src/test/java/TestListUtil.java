import listutil.IListUtil;
import listutil.ListUtil;
import org.junit.Assert;
import org.junit.Test;

import java.awt.*;
import java.util.*;
import java.util.List;

public class TestListUtil {

    @Test
    public void testListEqualsWhenNoDuplicate(){
        IListUtil listUtil = ListUtil.getInstance();
        boolean result = listUtil.listEquals(Arrays.asList("D","B","A","C"), Arrays.asList("A","B","D","C"));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testListEqualsWhenDuplicate(){
        IListUtil listUtil = ListUtil.getInstance();
        boolean result = listUtil.listEquals(Arrays.asList("A","A","B","Apple"),Arrays.asList("B","A", "Apple","A"));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testListEqualsWhenDuplicateAndDifferentObjects(){
        IListUtil listUtil = ListUtil.getInstance();
        boolean result = listUtil.listEquals(Arrays.asList("A","A","B", "Apple",34 ,3.14),Arrays.asList(3.14, "B","A", "Apple","A", 34));
        Assert.assertEquals(true, result);
    }

    @Test
    public void testListEqualsForObjects(){

//        for (int i = 1; i<4; i++){
//            for (int j = 1; j<4; j++){
//                Point p = new Point(i,j);
//            }
//        }
        Point p1 = new Point(1,2);
        Point p2 = new Point(2,3);
        Point p3 = new Point(5,4);

        Point p4 = new Point(2,3);
        Point p5 = new Point(5,4);
        Point p6 = new Point(1,2);

        IListUtil listUtil = ListUtil.getInstance();
        boolean result = listUtil.listEquals(Arrays.asList(p1, p2, p3),Arrays.asList(p4, p5 ,p6));
        Assert.assertEquals(true, result);
    }



    @Test
    public void testListNotEqualsWhenNoDuplicate(){
        IListUtil listUtil = ListUtil.getInstance();
        boolean result = listUtil.listEquals(Arrays.asList("A","B","D","Apple"), Arrays.asList("A","B","D","apple"));
        Assert.assertEquals(false, result);
    }

    @Test
    public void testListNotEqualsWhenDuplicate(){
        IListUtil listUtil = ListUtil.getInstance();
        boolean result = listUtil.listEquals(Arrays.asList("A", "B", "D", "FF", "Apple", "FF"), Arrays.asList("FF", "FF", "A", "B", "D", "pear"));
        Assert.assertEquals(false, result);
    }


    class TestObject {
        private String a;

        TestObject(String a) {
            this.a = a;
        }
    }

    @Test
    public void testReflectProperty(){
        IListUtil listUtil = ListUtil.getInstance();

        Rectangle r1 = new Rectangle(100, 150);
        Rectangle r2 = new Rectangle(150, 200);

        List source = listUtil.reflectProperty(Arrays.asList(r1,r2), "width");
        Assert.assertEquals(Arrays.asList("100","150"), source);
    }

    @Test
    public void testReflectPropertyWhenPrivate(){
        IListUtil listUtil = ListUtil.getInstance();

        TestObject t1 = new TestObject("1");
        TestObject t2 = new TestObject("2");

        List source = listUtil.reflectProperty(Arrays.asList(t1,t2), "a");
        Assert.assertEquals(Arrays.asList("1","2"), source);
    }

}
